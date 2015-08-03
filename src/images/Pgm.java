package images;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import pixel.PgmPixelColor;
import pixel.PixelColor;

public class Pgm extends Image {

	private byte buffer[][];
	private int maxColor = -1;
	private PgmPixelColor color = new PgmPixelColor();

	public Pgm() {
		this.setBuffer(null);
		this.maxColor = 255;
		this.color.setColor(255);
	}

	@Override
	protected void resize(int width, int height) {
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("Width and height must be non negative numbers!");
		}
		setBuffer(new byte[height][width]);
	}

	@Override
	public
	void read(InputStream input) throws IOException {
		setBuffer(null);
		String type = null;
		maxColor = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = null;

		int width = -1;
		int height = -1;

		while ((line = br.readLine()) != null) {
			if (type == null) {
				if (!line.equals("P2")) {
					System.out.println("Unsupported file");
					System.exit(1);
				}
				type = line;
				continue;
			}

			if (line.matches("^#.*")) {
				continue;
			}

			if (getBuffer() == null) {
				width = Integer.parseInt(line.split(" ")[0]);
				height = Integer.parseInt(line.split(" ")[1]);

				setBuffer(new byte[height][]);
				continue;
			}

			if (maxColor == -1) {
				maxColor = Integer.parseInt(line);
				break;
			}
		}

		for (int countY = 0; countY < height; countY++) {
			getBuffer()[countY] = new byte[width];

			for (int countX = 0; countX < getWidth();) {

				if ((line = br.readLine()) == null) {
					System.out.println("Inconsistent file");
					System.exit(2);
				}
				String[] values = line.split(" ");
				int vCount = 0;

				for (; vCount < values.length; vCount++) {
					double d = 0.0;
					try{
						d = Double.parseDouble(values[vCount]);
					}
					catch(NumberFormatException nfe){
						getBuffer()[countY][countX + vCount] = (byte) d;
						continue;
					}
					getBuffer()[countY][countX + vCount] = (byte) d;
				}
				countX += vCount;
			}

		}
		br.close();
	}

	@Override
	public
	void write(OutputStream output) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new OutputStreamWriter(output));

		pw.println("P2");
		pw.println(getWidth() + " " + getHeight());
		pw.println(getMaxColor());

		for (int countY = 0; countY < getHeight(); countY++) {
			for (int countX = 0; countX < getWidth(); countX++) {
				pw.println((getBuffer()[countY][countX] & 0x00ff) + " ");
			}

		}
		pw.close();
	}

	@Override
	public int getHeight() {
		return getBuffer().length;
	}

	@Override
	public int getWidth() {
		return getBuffer()[0].length;
	}

	@Override
	int getMaxColor() {
		return maxColor;
	}

	@Override
	public PixelColor getPixelColor(int y, int x) {
		this.color.setColor(0x00ff & getBuffer()[y][x]);
		return this.color;

	}

	@Override
	public void setPixelColor(int y, int x, PixelColor color) {
		if (color instanceof PgmPixelColor) {
			if (this.color.getColor() >= 0 && this.color.getColor() <= getMaxColor()) {
				getBuffer()[y][x] = (byte) ((PgmPixelColor) color).getColor();
			} else {
				throw new IllegalArgumentException("Color must be between 0 and " + getMaxColor());
			}
		}

		else
			throw new IllegalArgumentException("Color must be of type PgmPixelColor!");
	}

	@Override
	public PixelColor getEmptyColor() {
		return new PgmPixelColor();
	}

	public byte[][] getBuffer() {
		return buffer;
	}

	private void setBuffer(byte buffer[][]) {
		this.buffer = buffer;
	}

}
