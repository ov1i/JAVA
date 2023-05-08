package lab10;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 2. 
 * Write a Frame application that will draw, inside a Canvas component, a circle tangent to smaller side of the canvas
 */

class myFrame extends Frame {
	public myFrame(String title) {
		super(title);
		this.addWindowListener(new exitListener());
		this.setSize(800,600);
		this.setVisible(true);
	}	
}

class exitListener extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent event) {
		System.exit(0);
	}
}

class myCanvas extends Canvas{
	public myCanvas(int width, int height) {
		this.setSize(width, height);
	}
	@Override
	public void paint(Graphics g) {	
		g.setColor(Color.CYAN);
		
		int r = Math.min(this.getWidth(), this.getHeight()) / 2;
		int posX = (this.getWidth() / 2) - r;
		int posY = (this.getHeight() / 2) - r;
		
		g.drawOval(posX, posY, r * 2, r * 2);
	}

}


public class OvidiuGherman_Lab10_P02 {

	public static void main(String[] args) {
		myFrame frame = new myFrame("OvidiuGherman_Lab10_P02");
		myCanvas canvas = new myCanvas(frame.getWidth(), frame.getHeight());
		frame.add(canvas);
	}

}
