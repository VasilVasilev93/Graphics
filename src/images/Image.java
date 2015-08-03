package images;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.Algorithms;
import pixel.PixelColor;

public abstract class Image {

	Algorithms algo = new Algorithms();

	abstract protected void resize(int width, int height); // ???

	public abstract void read(InputStream input) throws FileNotFoundException, IOException;

	public abstract void write(OutputStream output) throws FileNotFoundException;

	abstract public int getHeight();

	abstract public int getWidth();

	abstract int getMaxColor();

	abstract public PixelColor getEmptyColor();

	abstract public PixelColor getPixelColor(int y, int x);

	abstract public void setPixelColor(int y, int x, PixelColor c);
}
