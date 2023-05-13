package lab10;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 6.
 * Write a Frame application that draws a schematic car. Use different colors for different car parts (doors, wheels, etc.)
 */

class MyFrame extends Frame {
	public MyFrame() {
		super("Car Schematic");
		this.setSize(1280, 720);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}

class MyCanvas extends Canvas {
	@Override
	public void paint(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D g2d = (Graphics2D) g;

		CarRoof.drawPart(g2d, width, height);
		CarBody.drawPart(g2d, width, height);
		CarDoor.drawPart(g2d, width, height);
		CarWheels.drawPart(g2d, width, height);

	}
}
class CarDoor {
	public static void drawPart(Graphics2D g, int w, int h) {
		int doorWidth = w / 12;
		int doorHeight = h / 4;
		int doorX = w / 2 - doorWidth + 20;
		int doorY = h / 4;

		g.setColor(Color.BLUE);
		
		g.fillRect(doorX, doorY, doorWidth, doorHeight);
		
		g.setColor(Color.RED);
		
		g.fillRect(doorX - doorWidth, doorY, doorWidth, doorHeight);
	}
}

class CarRoof {
	public static void drawPart(Graphics2D g, int w, int h) {
		int arcWidth = 50;
		int arcHeight = 50;
		int roofX = w / 4 + w / 16;
		int roofY = h / 4 - h / 10;
		int roofWidth = w / 4;
		int roofHeight = h / 8; 
		
		g.setColor(Color.gray);
		
		g.fillRoundRect(roofX, roofY, roofWidth, roofHeight, arcWidth, arcHeight);
	}
}
class CarWheels {
	public static void drawPart(Graphics2D g, int w, int h) {
		int wheelSize = 150;
        int wheelY = h / 4 + h / 8 + 30;
        int wheelX1 = w / 4 + 20;
        int wheelX2 = w / 2 + w / 16 + 50;
        
		g.setColor(Color.BLACK);
		
		g.fillOval(wheelX1, wheelY, wheelSize, wheelSize);
        g.fillOval(wheelX2, wheelY, wheelSize, wheelSize);
	}
}
class CarBody {
	public static void drawPart(Graphics2D g, int w, int h) {
		int arcWidth = w / 16;
        int arcHeight = h / 8;
        int bodyX = w / 4;
        int bodyY = h / 4;
        int bodyWidth = w / 2;
        int bodyHeight = h / 4;
        
		g.setColor(Color.magenta);
		
		g.fillRoundRect(bodyX, bodyY, bodyWidth, bodyHeight, arcWidth, arcHeight);
	}
}
public class OvidiuGherman_Lab10_P06 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		MyCanvas canvas = new MyCanvas();
		frame.add(canvas);
	}

}
