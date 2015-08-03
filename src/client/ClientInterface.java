package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algorithms.Algorithms;
import images.Image;
import images.Pgm;
import images.Ppm;
import server.MultiClient;

public class ClientInterface {
	private String frameText = null;
	private static JFrame Frame = null;

	public String getFrameText() {
		return frameText;
	}

	/**
	 * Resizes this component so that it has width width and height height.
	 * 
	 * @param width
	 * @param height
	 */
	public void setFrameSize(int width, int height) {
		Frame.setSize(width, height);
	}

	/**
	 * Setting up the frameText of the Frame
	 * 
	 * @param frameText
	 *            the text of the frame
	 */
	public void setFrameText(String frameText) {
		this.frameText = frameText;
	}

	private static ClientInterface clientInterface = new ClientInterface();

	private ClientInterface() {
		Frame = new JFrame();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setVisible(true);
	}

	/**
	 * 
	 * 
	 * @return clientInterface the instance of this class
	 */
	public static ClientInterface getInstance() {
		return clientInterface;
	}

	/**
	 * Creates, moves and resizes this component. The name is specified by
	 * <code>name</code> and the new location of the top-left corner is
	 * specified by <code>x</code> and <code>y</code>, and the new size is
	 * specified by <code>width</code> and <code>height</code>.
	 * <code>layout</code>
	 * <p>
	 * 
	 * @param layout
	 *            the position of the component on the frame.
	 */
	public JButton createButton(String name, Object constraints) {
		JPanel panel = new JPanel();
		JButton button = new JButton(name);
		panel.add(button);
		Frame.add(panel, constraints);
		return button;
	}

	public void addListener(JButton button, OutputStream output, int type) throws IOException {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int coordY = Integer.parseInt(JOptionPane.showInputDialog("Select row: "));
				int coordX = Integer.parseInt(JOptionPane.showInputDialog("Select column: "));
				int param = 0, color = 0, fill = 0;
				try {
					output.write(type);
					output.write(coordX);
					output.write(coordY);
					switch (type) {
					case MultiClient.IMAGE:
						final JFileChooser fc = new JFileChooser();
						int returnVal = fc.showOpenDialog(Frame);
						
						String algorithmChoice = (String) JOptionPane.showInputDialog(null, "Choose algorithm", "Image algorithms", JOptionPane.QUESTION_MESSAGE, null,
						        Algorithms.getAlgorithms(), null);
						//output.write(algorithmChoice);
						for(int i = 0; i <  Algorithms.getAlgorithms().length; i ++){
							if ( Algorithms.getAlgorithms()[i] == algorithmChoice){
								output.write(i);
							}
						}
						if(returnVal == JFileChooser.APPROVE_OPTION){
							String name = fc.getSelectedFile().getName();
							Image image = null;
							if(name.endsWith("pgm")){
								image = new Pgm();
								output.write(0);
							}
							else if(name.endsWith("ppm")){
								image = new Ppm();
								output.write(1);
							}
							
							File file = new File(fc.getSelectedFile().getPath());
							FileInputStream input = null;
							input = new FileInputStream(file);
							image.read(input);
							image.write(output);
						}
						else{
							System.out.println("No file was selected.");
							return;
						}
						break;

					case MultiClient.SQUARE:
						param = Integer.parseInt(JOptionPane.showInputDialog("Enter side: "));
						break;

					case MultiClient.CIRCLE:
						param = Integer.parseInt(JOptionPane.showInputDialog("Enter radius: "));
						break;

					case MultiClient.ELLIPSE:
						param = Integer.parseInt(JOptionPane.showInputDialog("Enter Major Axis: "));
						int param1 = Integer.parseInt(JOptionPane.showInputDialog("Enter Minor Axis: "));
						output.write(param1);
						break;
					}

					if (type != MultiClient.IMAGE) {
						color = Integer.parseInt(JOptionPane.showInputDialog("Enter Color: "));
						//fill = Integer.parseInt(JOptionPane.showInputDialog("Draw(0) or Fill(1): "));
						output.write(param);
						output.write(color);
						//output.write(fill);
					}
				} catch (IOException e1) {
					System.out.println("Failed to write into stream, socket is closed.");
				}
			}

		});

	}

}
