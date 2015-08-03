package shapes;

import java.io.IOException;
import java.io.InputStream;

public abstract class Figures {
	protected int coordX = 0, coordY = 0;

	public abstract void draw(InputStream input) throws IOException;
}
