package server;

import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import shapes.Circle;
import shapes.Ellipse;
import shapes.Figures;
import shapes.Picture;
import shapes.Square;

public class MultiClient extends Thread {
	public static final int IMAGE = 0;
	public static final int CIRCLE = 1;
	public static final int SQUARE = 2;
	public static final int ELLIPSE = 3; 
	
	private Socket socket;
	private int clientNumber;
	private int clientChoice;
	protected static final JFrame frame = new JFrame("Picture Server");
	protected static Graphics graphics = null;
	public static Graphics getGraphics() {
		return graphics;
	}

	public static void setGraphics(Graphics graphics) {
		MultiClient.graphics = graphics;
	}

	private Map<Integer, Figures> dictionary = new HashMap<Integer, Figures>();

	public MultiClient(Socket socket, int clientNumber) {
		this.socket = socket;
		this.clientNumber = clientNumber;
		System.out.println("New client with # " + clientNumber);
		dictionary.put(IMAGE, new Picture());
		dictionary.put(CIRCLE, new Circle());
		dictionary.put(SQUARE, new Square());
		dictionary.put(ELLIPSE, new Ellipse());
	}

	@Override
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			clientChoice = input.read();
			frame.setSize(400, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			graphics = frame.getGraphics();
			
			Figures shape = dictionary.get(clientChoice);
			shape.draw(input);
			

		} catch (IOException e) {
			System.out.println("Failed to read from stream");
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("Failed to close connection");
				e.printStackTrace();
			}
		}
	}
}
