package shapes;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

import client.MultiClient;

public class Square extends Figure {
	private int coordY = 0;
	private int color = 0;
	private Color c = null;
	private int side = 0;
	private int fill = 0;

	@Override
	public void draw(InputStream input) throws IOException {
		coordX = input.read();
		coordY = input.read();
		side = input.read();
		color = input.read();
		//fill = input.read();

		c = new Color(color);
		MultiClient.getGraphics().setColor(c);
		Point a = new Point();
		Point a1 = new Point();
		
		drawPoints(side, a, a1, fill);
	}

	public void drawPoints(int side, Point a, Point a1, int typeOfDraw){
		for (int countY = 0; countY <= side; countY++) {
			for (int countX = 0; countX <= side; countX++) {
				a.setX(countX);
				a.setY(countY);
				if (countY != side) {
					a1 = a.topProjection();
				} else {
					a1 = a.topProjection().topProjection();
				}
				if(typeOfDraw == 0){
					if ((a1.getX() == 0 && a1.getY() == 0)) {
						MultiClient.getGraphics().drawLine(countX + coordX, countY + coordY, countX + coordX, countY + coordY);
					} else if (a.distance(a1) == side * side) {
						MultiClient.getGraphics().drawLine(countX + coordX, countY + coordY, countX + coordX, countY + coordY);
					}
				}
				else{
					if(a.distance(a1) <= side*side){
						MultiClient.getGraphics().drawLine(countX + coordX, countY + coordY, countX + coordX, countY + coordY);
					}
				}
			}

		}
	}
	
}
