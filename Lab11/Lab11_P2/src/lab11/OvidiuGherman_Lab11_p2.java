package lab11;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/* 2. 
 * Implement a Java application that uses GridBagLayout for arranging the components specific to a computing
 * application. (TextField for I/O operations, buttons for numbers, mathematical operations, screen cleaning, etc.).
 */

class MyJPanel extends JPanel {
	public MyJPanel(String []list) {
		this.setLayout(new GridBagLayout());
		JTextField myTextField = new JTextField("0");		
		myTextField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(myTextField, constraints);
		
		int row = 1;
		int column = 0;
		constraints.gridwidth = 1;
		for(int i = 0; i < list.length;i++) {
			if(column == 4) {
				row++;
				column = 0;
				
			}
			constraints.fill = GridBagConstraints.BOTH;
			constraints.anchor = GridBagConstraints.EAST;
			constraints.gridx = column++;
			constraints.gridy = row;
			
			constraints.insets.top = 5;
			constraints.insets.bottom = 5;
			constraints.insets.right = 5;
			constraints.insets.left = 5;
			this.add(new JButton(list[i]), constraints);
		}
	}
}

public class OvidiuGherman_Lab11_p2 {
	private static String []buttons = {"C"," ", " " , "/", "7","8", "9", "X", "4","5", "6", "-", "1", "2", "3", "+", "+/-", "0", ".", "="};
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Calcualtor");
		MyJPanel myPanel = new MyJPanel(buttons);
			
		myFrame.add(myPanel);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);;
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
