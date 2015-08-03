package pixel;

public class PgmPixelColor extends PixelColor {

	private int color = 0;

	@Override
	public PixelColor add(PixelColor color) {
		if (color instanceof PgmPixelColor) {
			setColor((getColor() + ((PgmPixelColor) color).getColor()));
			return this;
		} else {
			throw new IllegalArgumentException("Color must be of type PgmPixelColor!");
		}
	}

	@Override
	public PixelColor div(int divisor) {
		setColor(getColor() / divisor);
		return this;
	}

	@Override
	public PixelColor sub(PixelColor color) {
		if (color instanceof PgmPixelColor) {
			setColor(getColor() - ((PgmPixelColor) color).getColor());
			return this;
		} else {
			throw new IllegalArgumentException("Color must be of type PgmPixelColor!");
		}
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	static public PixelColor[] sort(PixelColor[] colors) {
		for (int i = 0; i < colors.length - 1; i++) {
			for(int j = 0; j < colors.length - 1; j++){
				if(((PgmPixelColor)colors[j]).getColor() > ((PgmPixelColor)colors[j + 1]).getColor()){
					swap(colors, j, j + 1);
				}
			}
		}
		return colors;
	}

	static public void swap(PixelColor[] colors, int pos1, int pos2) {
		final int temp = ((PgmPixelColor) colors[pos1]).getColor();
		((PgmPixelColor) colors[pos1]).setColor(((PgmPixelColor)colors[pos2]).getColor());
		((PgmPixelColor) colors[pos2]).setColor(temp);
	}

}
