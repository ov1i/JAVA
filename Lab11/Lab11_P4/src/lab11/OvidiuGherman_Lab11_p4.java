package lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/* 4.
 * Create an application which takes from two text fields your name and the group you are part of and displays this info
 * in a label colored in RGB (122,123,129).
 */

class MyFrame extends JFrame {
	private JTextField name;
	private JTextField group;
	private JLabel info;
	public MyFrame() {
		this.setTitle("Name and Group App");
		this.setPreferredSize(new Dimension(550,100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		this.name = new JTextField(15);
		this.group = new JTextField(15);
		JButton btn = new JButton("Display");
		btn.addActionListener(e -> {
			display();
			});

		this.info = new JLabel();	
		this.info.setForeground(new Color(122, 123, 129));

		this.add(new JLabel("Name: "));
		this.add(name);
		this.add(new JLabel("Group: "));
		this.add(group);
		this.add(btn);
		this.add(new JLabel("OUTPUT:"));
		this.add(info);

		this.setLocationRelativeTo(null);
		this.pack();
		this.setResizable(false);
	}
	
	private void display() {
        String name = this.name.getText();
        String group = this.group.getText();
        String output = "Name: " + name + " || Group: " + group;
        this.info.setText(output);
    }
}

public class OvidiuGherman_Lab11_p4 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
