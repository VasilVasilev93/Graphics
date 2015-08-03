package algorithms;

import images.Pgm;

public class BinarizeThread extends Thread {

	private int offsetX, offsetY, w, h;
	Pgm src, dest;
	
	BinarizeThread(Pgm src, Pgm dest, int offsetX, int offsetY, int w, int h) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.w = w;
		this.h = h;
		this.src = src;
		this.dest = dest;
	}

	@Override
	public void run() {
		Algorithms.binarize(src, dest, 7, -5, offsetX, offsetY, w, h);
	}
}
