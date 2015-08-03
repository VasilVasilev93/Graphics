package images;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import pixel.PixelColor;
import pixel.PpmPixelColor;

public class Ppm extends Image {

	private byte buffer[][];
	private int maxColor = -1;
	private PpmPixelColor color = new PpmPixelColor();

	public Ppm() {
		this.buffer = null;
		this.maxColor = 255;
		this.color.setRed(255);
		this.color.setGreen(255);
		this.color.setBlue(255);
	}

	@Override
	protected void resize(int width, int height) {
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("Width and height must be non negative numbers!");
		}
		buffer = new byte[height][width * 3];
	}

	@Override
	public
	void read(InputStream input) throws FileNotFoundException, IOException {
		buffer = null;
		String type = null;
		maxColor = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = null;

		int width = -1;
		int height = -1;

		while ((line = br.readLine()) != null) {
			if (type == null) {
				if (!line.equals("P3")) {
					System.out.println("Unsupported format");
					System.exit(1);
				}
				type = line;
				continue;
			}

			if (line.matches("^#.*")) {
				continue;
			}

			if (buffer == null) {
				width = Integer.parseInt(line.split(" ")[0]);
				height = Integer.parseInt(line.split(" ")[1]);

				buffer = new byte[height][];
				continue;
			}

			if (maxColor == -1) {
				maxColor = Integer.parseInt(line);
				break;
			}

		}

		for (int countY = 0; countY < getHeight(); countY++) {
			buffer[countY] = new byte[width * 3];

			for (int countX = 0; countX < getWidth() * 3;) {

				if ((line = br.readLine()) == null) {
					System.out.println("Inconsistent file");
					System.exit(2);
				}

				String[] values = line.split(" ");
				int vCount = 0;

				for (; vCount < values.length; vCount++) {
					buffer[countY][vCount + countX] = (byte) Integer.parseInt(values[vCount]);
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

		pw.println("P3");
		pw.println(getWidth() + " " + getHeight());
		pw.println(maxColor);

		for (int countY = 0; countY < getHeight(); countY++) {
			for (int countX = 0; countX < getWidth() * 3; countX++) {
				pw.println((buffer[countY][countX] & 0x00ff) + " ");
			}
		}

		pw.close();
	}

	@Override
	public int getHeight() {
		return buffer.length;
	}

	@Override
	public int getWidth() {
		return (buffer[0].length / 3);
	}

	@Override
	int getMaxColor() {
		return maxColor;
	}

	@Override
	public PixelColor getPixelColor(int y, int x) {
		this.color.setRed(0x00ff & buffer[y][x * 3 + 0]);
		this.color.setGreen(0x00ff & buffer[y][x * 3 + 1]);
		this.color.setBlue(0x00ff & buffer[y][x * 3 + 2]);
		return this.color;
	}

	@Override
	public void setPixelColor(int y, int x, PixelColor color) {
		if (color instanceof PpmPixelColor) {
			PpmPixelColor c = (PpmPixelColor) color;
			if ((c.getRed() >= 0 && c.getRed() <= getMaxColor()) && c.getGreen() >= 0 && c.getGreen() <= getMaxColor()
					&& c.getBlue() >= 0 && c.getBlue() <= getMaxColor()) {
				buffer[y][x * 3 + 0] = (byte) c.getRed();
				buffer[y][x * 3 + 1] = (byte) c.getGreen();
				buffer[y][x * 3 + 2] = (byte) c.getBlue();
			} else {
				throw new IllegalArgumentException("Color must be between 0 and " + getMaxColor() + " : " + c.getRed());
			}
		} else
			throw new IllegalArgumentException("Color must be of PpmPixelColor type!");
	}

	@Override
	public PixelColor getEmptyColor() {
		return new PpmPixelColor();
	}

}
