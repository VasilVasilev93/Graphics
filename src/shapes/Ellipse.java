package shapes;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

import client.MultiClient;

public class Ellipse extends Figure {

	private int majorAxis = 0, minorAxis = 0, color = 0;

	@Override
	public void draw(InputStream input) throws IOException {

		coordX = input.read();
		coordY = input.read();
		minorAxis = input.read();
		majorAxis = input.read();
		color = input.read();

		Point F = new Point();
		Point G = new Point();
		Point P = new Point();
		Point P1 = new Point();
		Point P2 = new Point();
		Point P3 = new Point();
		Point C = new Point();

		C.setX(coordX);
		C.setY(coordY);

		C.setX(10.0);
		C.setY(5.0);

		int semiMajor = majorAxis / 2;
		int semiMinor = minorAxis / 2;

		double dist = Math.sqrt(semiMajor * semiMajor - semiMinor * semiMinor);

		F.setX(C.getX() + dist);
		F.setY(C.getY());

		G.setX(C.getX() - dist);
		G.setY(C.getY());
		//MultiClient.getGraphics().setColor(new Color(color));

		for (int countX = 0; countX < majorAxis; countX++) {
			for (int countY = 0; countY < minorAxis; countY++) {
				P.setX(countX);
				P.setY(countY);
				P1 = P.symetricX(minorAxis);
				P2 = P.symetricY(minorAxis);
				P3 = P2.symetricX(minorAxis);

				// not finished yet
				if (Math.sqrt(P.distance(F)) + Math.sqrt(P.distance(G)) <= majorAxis) {
					MultiClient.getGraphics().drawLine((int) P.getX() + coordX, (int) P.getY() + coordY, (int) P.getX() + coordX,
							(int) P.getY() + coordY);
					MultiClient.getGraphics().drawLine((int) P1.getX() + coordX, (int) P1.getY() + coordY, (int) P1.getX() + coordX,
							(int) P1.getY() + coordY);
					MultiClient.getGraphics().drawLine((int) P2.getX() + coordX, (int) P2.getY() + coordY, (int) P2.getX() + coordX,
							(int) P2.getY() + coordY);
					MultiClient.getGraphics().drawLine((int) P3.getX() + coordX, (int) P3.getY() + coordY, (int) P3.getX() + coordX,
							(int) P3.getY() + coordY);

				}
			}
		}
	}

}
