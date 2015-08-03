package pixel;

public class PpmPixelColor extends PixelColor {

	private int red = -1;
	private int green = -1;
	private int blue = -1;

	@Override
	public PixelColor add(PixelColor color) {
		if (color instanceof PpmPixelColor) {
			PpmPixelColor c = (PpmPixelColor) color;
			setRed(getRed() + c.getRed());
			setGreen(getGreen() + c.getGreen());
			setBlue(getBlue() + c.getBlue());
			return this;
		} else {
			throw new IllegalArgumentException("Color must be of type PpmPixelColor!");
		}
	}

	@Override
	public PixelColor div(int divisor) {
		setRed(getRed() / divisor);
		setGreen(getGreen() / divisor);
		setBlue(getBlue() / divisor);
		return this;
	}

	@Override
	public PixelColor sub(PixelColor color) {
		if (color instanceof PpmPixelColor) {
			PpmPixelColor c = (PpmPixelColor) color;
			setRed(getRed() - c.getRed());
			setGreen(getGreen() - c.getGreen());
			setBlue(getBlue() - c.getBlue());
			return this;
		} else {
			throw new IllegalArgumentException("Color must be of type PpmPixelColor!");
		}
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	static public PixelColor[] sort(PixelColor[] colors) {
		//colors = (PpmPixelColor[]) colors;
		for(int i = 0; i < colors.length - 1; i ++){
			for(int j = 0; j < colors.length - 1; j ++){
				int r = ((PpmPixelColor) colors[j]).getRed() - ((PpmPixelColor) colors[j + 1]).getRed();
				int g = ((PpmPixelColor) colors[j]).getGreen() - ((PpmPixelColor) colors[j + 1]).getGreen();
				int b = ((PpmPixelColor) colors[j]).getGreen() - ((PpmPixelColor) colors[j + 1]).getGreen();
				
				if(r + g + b > 0){
					swap(colors, j, j + 1);
				}
			}
		}
		return colors;
	}

	static public void swap(PixelColor[] colors, int pos1, int pos2) {
		final int r = ((PpmPixelColor) colors[pos1]).getRed();
		final int g = ((PpmPixelColor) colors[pos1]).getGreen();
		final int b = ((PpmPixelColor) colors[pos1]).getBlue();
		
		((PpmPixelColor) colors[pos1]).setRed(((PpmPixelColor) colors[pos2]).getRed());
		((PpmPixelColor) colors[pos1]).setGreen(((PpmPixelColor) colors[pos2]).getGreen());
		((PpmPixelColor) colors[pos1]).setBlue(((PpmPixelColor) colors[pos2]).getBlue());
		
		
		((PpmPixelColor) colors[pos2]).setRed(r);
		((PpmPixelColor) colors[pos2]).setGreen(g);
		((PpmPixelColor) colors[pos2]).setBlue(b);
		
	}

}
