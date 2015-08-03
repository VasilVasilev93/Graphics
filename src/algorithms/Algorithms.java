package algorithms;

import images.Image;
import images.Pgm;
import pixel.PgmPixelColor;
import pixel.PixelColor;
import pixel.PpmPixelColor;

public class Algorithms {

	private static final String[] algorithms = {"meanFilter", "medianFilter", "binarize"};
	public static void meanFilter(Image src, Image dest) {
		PixelColor sum = src.getEmptyColor();
		for (int countY = 1; countY < src.getHeight() - 1; countY++)
			for (int countX = 1; countX < src.getWidth() - 1; countX++) {
				sum.sub(sum); // zero sum

				for (int iNeighb = 0; iNeighb < 9; iNeighb++) {
					PixelColor c = src.getPixelColor(countY + (iNeighb % 3) - 1, countX + (iNeighb / 3) - 1);
					sum.add(c);
				}

				sum.div(9);
				dest.setPixelColor(countY, countX, sum);
			}
	}

	public static void binarize(Pgm src, Pgm dest, int neighb, int delta, int offsetX, int offsetY, int w, int h) {
		if (neighb % 2 == 0) {
			throw new IllegalArgumentException("Neighbours must be odd number");
		}
		if (neighb < 3) {
			throw new IllegalArgumentException("Neighbours must be at least 9");
		}

		PgmPixelColor sum = (PgmPixelColor) src.getEmptyColor();
		PgmPixelColor black = new PgmPixelColor();
		black.setColor(0);
		PgmPixelColor white = new PgmPixelColor();
		white.setColor(255);

		int neighbSize = neighb * neighb;

		for (int countY = Math.max(offsetY, neighb / 2); countY < Math.min(src.getHeight() - neighb / 2,
				h + Math.max(offsetY, neighb / 2)); countY++)
			for (int countX = Math.max(offsetX, neighb / 2); countX < Math.min(src.getWidth() - neighb / 2,
					w + Math.max(offsetX, neighb / 2)); countX++) {
				sum.sub(sum); // zero sum

				/*
				 * for (int iNeighb = 0; iNeighb < neighbSize; iNeighb++) {
				 * PgmPixelColor c = (PgmPixelColor) src.getPixelColor( countY +
				 * (iNeighb % neighb) - ((neighb - 1) / 2), countX + (iNeighb /
				 * neighb) - ((neighb - 1) / 2)); sum.add(c); }
				 */

				for (int yNeighb = 0; yNeighb < neighb; yNeighb++) {
					for (int xNeighb = 0; xNeighb < neighb; xNeighb++) {
						PgmPixelColor c = (PgmPixelColor) src.getPixelColor(countY + yNeighb - ((neighb - 1) / 2),
								countX + xNeighb - ((neighb - 1) / 2));
						sum.add(c);
					}
				}

				sum.div(neighbSize);

				if ((((PgmPixelColor) src.getPixelColor(countY, countX)).getColor()) < delta + sum.getColor()) {
					dest.setPixelColor(countY, countX, black);
				} else {
					dest.setPixelColor(countY, countX, white);
				}
			}

	}

	public static void medianFilter(Image src, Image dest) {
		for (int y = 1; y < src.getHeight() - 1; y++) {
			for (int x = 1; x < src.getWidth() - 1; x++) {
				PixelColor[] colors = new PixelColor[9];
				for(int i = 0; i < 9; i++){
					colors[i] = src.getEmptyColor();
				}
				PixelColor c = null;
				for (int iNeighb = 0; iNeighb < 9; iNeighb ++) {
					c = src.getPixelColor(y + (iNeighb % 3) - 1, x + (iNeighb / 3) - 1);
					if(c instanceof PpmPixelColor){
						((PpmPixelColor) colors[iNeighb]).setRed(((PpmPixelColor) c).getRed());
						((PpmPixelColor) colors[iNeighb]).setGreen(((PpmPixelColor) c).getGreen());
						((PpmPixelColor) colors[iNeighb]).setBlue(((PpmPixelColor) c).getBlue());
					}
					else{
						((PgmPixelColor) colors[iNeighb]).setColor(((PgmPixelColor) c).getColor());
					}
					
				}
				if(colors[0] instanceof PpmPixelColor){
					PpmPixelColor.sort(colors);
				}
				else if (colors[0] instanceof PgmPixelColor){
					PgmPixelColor.sort(colors);
				}
				dest.setPixelColor(y, x, colors[colors.length / 2]);
			}
		}
	}

	public static String[] getAlgorithms() {
		return algorithms;
	}
}
