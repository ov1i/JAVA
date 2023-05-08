package lab10;


import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 1. 
 * Write a Frame application that will display in a panel your name and group. The text will be blue and centered both on
 * the horizontal and vertical, given the dimension of the panel.
 */

class myFrame extends Frame {

	public myFrame(String title) {
		super(title);
		this.addWindowListener(new exitListener());
		this.setSize(800,600);
		this.setVisible(true);
	}	
}

class myPanel extends Panel {
	public myPanel(int width, int height) {
		this.setSize(width, height);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		
		String input  = "Gherman Ovidiu -> Group 2023";
		FontMetrics m = g.getFontMetrics();
		
		int panelCenterX = this.getWidth()/2;
		int panelCenterY = this.getHeight()/2;
		
		int posX = panelCenterX - (m.stringWidth(input) / 2);
		int posY = panelCenterY - (m.getHeight() / 2);
		
		g.drawString(input, posX, posY);
	}

}


class exitListener extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent event) {
		System.exit(0);
	}
}

public class OvidiuGherman_Lab10_P01 {

	public static void main(String[] args) {
		myFrame frame = new myFrame("GhermanOvidiu_Lab10_P01");
		myPanel panel = new myPanel(frame.getWidth(), frame.getHeight());
		frame.add(panel);
		
		
	}
}
