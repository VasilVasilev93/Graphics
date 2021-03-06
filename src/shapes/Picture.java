package shapes;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import algorithms.Algorithms;
import client.MultiClient;
import images.Image;
import images.Pgm;
import images.Ppm;
import pixel.PgmPixelColor;
import pixel.PixelColor;
import pixel.PpmPixelColor;

public class Picture extends Figure {
	Image receivedImage = null;
	Color color = null;
	String algo = null;
	Image filteredImage = null;

	@Override
	public void draw(InputStream input) throws IOException {

		coordY = input.read();
		coordX = input.read();
		int algoIndex = input.read();
		if(algoIndex != 0){
			algo = Algorithms.getAlgorithms()[algoIndex - 1];
		}
		int type = input.read();
		if(type == 0){
			receivedImage = new Pgm();
			filteredImage = new Pgm();
		}
		else if(type == 1){
			receivedImage = new Ppm();
			filteredImage = new Ppm();
		}
		
		receivedImage.read(input);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		receivedImage.write(bos);
		filteredImage.read(new ByteArrayInputStream(bos.toByteArray()));
		//Reflection
		if(algo != null){
			try {
				Method method = Algorithms.class.getMethod(algo, Image.class, Image.class);
				method.invoke(Algorithms.class, receivedImage, filteredImage);
			} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("No such method!");
				e.printStackTrace();
			}
		}

		for (int countY = 0; countY < filteredImage.getHeight(); countY++) {
			for (int countX = 0; countX < filteredImage.getWidth(); countX++) {
				PixelColor c = filteredImage.getPixelColor(countY, countX);
				if(c instanceof PpmPixelColor){
					
					int r = ((PpmPixelColor) c).getRed();
					int g = ((PpmPixelColor) c).getGreen();
					int b = ((PpmPixelColor) c).getBlue();
					
					color = new Color(r, g, b);
				}
				
				else{
					int c1 = ((PgmPixelColor) c).getColor();
					color = new Color(c1, c1, c1);
				}

				MultiClient.getGraphics().setColor(color);
				MultiClient.getGraphics().drawLine(countX + coordX, countY + coordY, countX + coordX, countY + coordY);
			}
		}

	}

}
