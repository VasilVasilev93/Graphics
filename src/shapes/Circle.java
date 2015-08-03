package shapes;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

import server.MultiClient;

public class Circle extends Figures {

	private int r = 0;
	private int color = 0;

	@Override
	public void draw(InputStream input) throws IOException {
		coordX = input.read();
		coordY = input.read();
		r = input.read();
		color = input.read();
		input.read();

		Color c = new Color(color);
		MultiClient.getGraphics().setColor(c);

		int d = (5 - r * 4) / 4;
		int x = 0;
		int y = r;

		do {
			MultiClient.getGraphics().drawLine(r + x + coordX, r + y + coordY, r + x + coordX, r + y + coordY);
			MultiClient.getGraphics().drawLine(r + x + coordX, r - y + coordY, r + x + coordX, r - y + coordY);
			MultiClient.getGraphics().drawLine(r - x + coordX, r + y + coordY, r - x + coordX, r + y + coordY);
			MultiClient.getGraphics().drawLine(r - x + coordX, r - y + coordY, r - x + coordX, r - y + coordY);
			MultiClient.getGraphics().drawLine(r + y + coordX, r + x + coordY, r + y + coordX, r + x + coordY);
			MultiClient.getGraphics().drawLine(r + y + coordX, r - x + coordY, r + y + coordX, r - x + coordY);
			MultiClient.getGraphics().drawLine(r - y + coordX, r + x + coordY, r - y + coordX, r + x + coordY);
			MultiClient.getGraphics().drawLine(r - y + coordX, r - x + coordY, r - y + coordX, r - x + coordY);
			if (d < 0) {
				d += 2 * x + 1;
			} else {
				d += 2 * (x - y) + 1;
				y--;
			}
			x++;
		} while (x <= y);

	}

}
