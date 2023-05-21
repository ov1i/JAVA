package lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* 5. 
 * Implement a graphical application that displays 3 TextField components for setting the amounts of R, G and B from a
 * color. After pressing a button, a Label component will display a text representing the specified quantities, with the
 * resulting color, if the values are correct (numerical, between 0-255). Oherwise, an error message will be displayed with
 * red. Try to use exceptions for validating the input
 */

class MyFrame extends JFrame {
	private JTextField redField;
	private JTextField greenField;
	private JTextField blueField;
	private JLabel result;

	public MyFrame() {
		this.setTitle("Valid color");
		this.setPreferredSize(new Dimension(400,100));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		this.redField = new JTextField(5);
		this.greenField = new JTextField(5);
		this.blueField = new JTextField(5);
		JButton btn = new JButton("Check");
		this.result = new JLabel();

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int red = extractValue(redField.getText());
					int green = extractValue(greenField.getText());
					int blue = extractValue(blueField.getText());

					if (checkValue(red) && checkValue(green) && checkValue(blue)) {
						Color color = new Color(red, green, blue);
						result.setText("Color: (" + red + ", " + green + ", " + blue + ")");
						result.setForeground(color);
					} else {

						throw new NumberFormatException();
					}
				} catch (NumberFormatException ex) {
					result.setText("Invalid input");
					result.setForeground(Color.RED);
				}
			}
		});

		add(new JLabel("Red: "));
		add(this.redField);
		add(new JLabel("Green: "));
		add(this.greenField);
		add(new JLabel("Blue: "));
		add(this.blueField);
		add(btn);
		add(new JLabel("Output: "));
		add(this.result);
		
		this.setLocationRelativeTo(null);
		this.pack();
	}
	private int extractValue(String value) {
		return Integer.parseInt(value);
	}

	private boolean checkValue(int value) {
		return value >= 0 && value <= 255;
	}
}

public class OvidiuGherman_Lab11_p5 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
