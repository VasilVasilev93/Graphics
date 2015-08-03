package client;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import server.MultiClient;

public class ImageClient {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 9090);

		new ImageClient(s);
	}

	public ImageClient(Socket s) throws IOException {
		//MUCH BETTER
		OutputStream output = s.getOutputStream();
		OutputStream copy = output;
		ClientInterface newInterface = ClientInterface.getInstance();
		newInterface.setFrameText("Image Client");
		newInterface.setFrameSize(400, 400);
		newInterface.addListener(newInterface.createButton("Send Image", BorderLayout.EAST), copy, MultiClient.IMAGE);
		newInterface.addListener(newInterface.createButton("Draw Circle", BorderLayout.NORTH), copy, MultiClient.CIRCLE);
		newInterface.addListener(newInterface.createButton("Draw Square", BorderLayout.SOUTH), copy, MultiClient.SQUARE);
		newInterface.addListener(newInterface.createButton("Draw Ellipse", BorderLayout.WEST), copy, MultiClient.ELLIPSE);
		output = copy;
		
		
		
		
		
		
		
		
		
		
		
		
		
		// V E R B O S E
		
//		accept.setBounds(500, 800, 180, 30);
//		drawC.setBounds(400, 800, 180, 30);
//		drawSq.setBounds(400, 600, 180, 30);
//		drawEl.setBounds(500, 600, 180, 30);
//		button.setBounds(800, 800, 180, 30);
//		button.add(accept);
//		button.add(drawC);
//		button.add(drawSq);
//		button.add(drawEl);
//
//		frame.add(button, BorderLayout.EAST);
//		frame.add(drawButton, BorderLayout.WEST);
//		frame.add(drawSqButton, BorderLayout.NORTH);
//		frame.add(drawElButton, BorderLayout.SOUTH);
//		frame.setSize(800, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);

		
		

//		accept.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//
//					coordY = Integer.parseInt(JOptionPane.showInputDialog("Select coordinate Y: "));
//					coordX = Integer.parseInt(JOptionPane.showInputDialog("Select coordinate X: "));
//
//					OutputStream output = s.getOutputStream();
//					output.write(MultiClient.IMAGE);
//					output.write(coordY);
//					output.write(coordX);
//
//					Pgm image = new Pgm();
//					File file = new File("src/butterfly.pgm");
//					FileInputStream input = null;
//					input = new FileInputStream(file);
//					image.read(input);
//					image.write(output);
//
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} finally {
//					try {
//						s.close();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//				// System.exit(0);
//				frame.remove(button);
//
//			}
//
//		});
//
//		drawC.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int red = 0, green = 0, blue = 0;
//					int radius = 0;
//					int coordX = 20;
//					int coordY = 20;
//					// coordY =
//					// Integer.parseInt(JOptionPane.showInputDialog("Select
//					// coordinate Y: "));
//					// coordX =
//					// Integer.parseInt(JOptionPane.showInputDialog("Select
//					// coordinate X: "));
//					radius = Integer.parseInt(JOptionPane.showInputDialog("Select radius: "));
//					red = Integer.parseInt(JOptionPane.showInputDialog("Select Red: "));
//					green = Integer.parseInt(JOptionPane.showInputDialog("Select Green: "));
//					blue = Integer.parseInt(JOptionPane.showInputDialog("Select Blue: "));
//					OutputStream output = s.getOutputStream();
//					output.write(MultiClient.CIRCLE);
//					output.write(radius);
//					output.write(coordX);
//					output.write(coordY);
//					output.write(red);
//					output.write(green);
//					output.write(blue);
//
//				} catch (IOException e1) {
//					System.out.println("Failed to get output stream from socket!");
//					e1.printStackTrace();
//				}
//
//			}
//
//		});
//
//		drawSq.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int color = 0;
//					int side = 0;
//
//					// coordY =
//					// Integer.parseInt(JOptionPane.showInputDialog("Select
//					// coordinate Y: "));
//					// coordX =
//					// Integer.parseInt(JOptionPane.showInputDialog("Select
//					// coordinate X: "));
//					OutputStream output = s.getOutputStream();
//					side = Integer.parseInt(JOptionPane.showInputDialog("Select side: "));
//					color = Integer.parseInt(JOptionPane.showInputDialog("Select Color: "));
//					output.write(MultiClient.SQUARE);
//					output.write(side);
//					output.write(color);
//					// output.write(coordY);
//					// output.write(coordX);
//
//				} catch (IOException e1) {
//					System.out.println("Failed to get output stream from socket!");
//					e1.printStackTrace();
//				}
//
//			}
//
//		});
//
//		drawEl.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int majorAxis = 20;
//					int minorAxis = 10;
//					int centerX = 30;
//					int centerY = 30;
//
//					OutputStream output = s.getOutputStream();
//
//					output.write(MultiClient.ELLIPSE);
//					output.write(majorAxis);
//					output.write(minorAxis);
//					output.write(centerX);
//					output.write(centerY);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//			}
//
//		});
	}

}
