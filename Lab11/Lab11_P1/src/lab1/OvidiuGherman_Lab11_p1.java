package lab1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/* 1. 
 * Implement a Java application that uses GridLayout for arranging the components specific to a computing application.
 * (TextField for I/O operations, buttons for numbers, mathematical operations, screen cleaning, etc.).
 */

class MyJPanel extends JPanel {
	public MyJPanel(String []list) {
		this.setLayout(new GridLayout(5,4,5,5));
		for(int i = 0; i < list.length;i++) {
			this.add(new JButton(list[i]));
		}
	}
}

public class OvidiuGherman_Lab11_p1 {
	private static String []buttons = {"C"," ", " " , "/", "7","8", "9", "X", "4","5", "6", "-", "1", "2", "3", "+", "+/-", "0", ".", "="};
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Calcualtor");
		MyJPanel myPanel = new MyJPanel(buttons);
		myFrame.setLayout(new GridLayout(2,0));
		JTextField myTextField = new JTextField("0");		
		myTextField.setHorizontalAlignment(SwingConstants.CENTER);
		myFrame.add(myTextField);
		myFrame.add(myPanel);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);;
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
