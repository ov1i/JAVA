package lab10;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 7. 
 * Implement a Frame application that fills a visual container with circles having randomly generated radius. The circles
 * are tangent and have random colors.
 */

class MyFrame extends Frame {
	public MyFrame() {
		super("Random Circles");
		this.setSize(800, 600);
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

	private List<Circle>circles;

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		this.setSize(800,600);
		int width = this.getWidth();
		int height = this.getHeight();
		
		
		Random random = new Random();
		int circlesCount = random.nextInt(10,50);
		circles = new ArrayList<>();
		
		int radius = random.nextInt(20,50);
		int x = random.nextInt(0 ,width);
		int y = random.nextInt(radius, height);
		Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		circles.add(new Circle(x, y, radius, color));
		circlesCount--;

		while (circlesCount != 0) {
			do { 
				radius = random.nextInt(20,50);
				x = random.nextInt(radius ,width - radius);
				y = random.nextInt(radius, height - radius);
				color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
				Circle tempCircle = new Circle(x, y, radius, color);
				if(tempCircle.isTangent(circles)) {
					circles.add(tempCircle);
					circlesCount--;
					break;
				}
			} while(true);
			
		}
		
		for(Circle currentCircle : circles) {
			currentCircle.drawCircle(g2d);
		}		
	}
}
class Circle {
	private int x,y;
	private int radius;
	private Color color;
	public Circle() {
		this.x = 0;
		this.y = 0;
		this.radius = 0;
		this.color = new Color(0);
	}
	public Circle(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	} 
	public void drawCircle(Graphics2D g) {
		g.setColor(this.color); 
		g.fillOval(this.x - this.radius, this.y - this.radius, this.radius * 2, this.radius * 2);
	}
	public int getterX() {
		return x;
	}
	public void setterX(int x) {
		this.x = x;
	}
	public int getterY() {
		return y;
	}
	public void setterY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public boolean isTangent(List<Circle> circles) {
		for(Circle other : circles) {
			int dx = other.getterX() - this.x;
			int dy = other.getterY() - this.y;
			int sum = this.radius + other.getRadius();
			int dist = dx * dx + dy * dy;

			if(dist == sum*sum) 
				return dist == sum * sum;
		}
		return false;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}

public class OvidiuGherman_Lab10_P07 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		MyCanvas canvas = new MyCanvas();
		frame.add(canvas);
	}

}
