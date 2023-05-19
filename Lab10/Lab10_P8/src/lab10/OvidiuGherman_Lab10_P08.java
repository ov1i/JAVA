package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/* 8.
 * Write a Java application that draws the trajectory of an object ”thrown” horizontally with a predefined velocity. The
 * trajectory is limited by the visual container’s lower bound. If the trajectory intersects the left or right container sides, the
 * object will bounce in the opposite direction. Display the object’s final vertical velocity.
 */


class MyJFrame extends JFrame {
	public MyJFrame() {
		super("Trajectory Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.add(new MyJPanel());
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
class MyJPanel extends JPanel implements ActionListener {

	private BufferedImage backBuffer;
	private Graphics2D backBufferGraphics;
	private Obj obj;

	public MyJPanel() {	
		this.setPreferredSize(new Dimension(1280, 720));
		backBuffer = new BufferedImage(this.getPreferredSize().width, this.getPreferredSize().height, BufferedImage.TYPE_INT_RGB);
		backBufferGraphics = backBuffer.createGraphics();
		obj = new Obj(5, 1, this.getWidth()/2,this.getHeight()/2,50);
		Timer timer = new Timer(15, this);
		timer.start();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backBuffer, 0, 0, null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		obj.setterX(obj.getterX() + obj.getVelocityX());
		obj.setterY(obj.getterY() + obj.getVelocityY());
		if (obj.getterX() + obj.getterSize() > this.getWidth() || obj.getterX() < 0) {
			obj.setVelocityX(obj.getVelocityX() * -1);
		}
		if (obj.getterY() + obj.getterSize() > this.getHeight() || obj.getterY() < 0) {
			obj.setVelocityY(obj.getVelocityY() * -1);
		}
		backBufferGraphics.setColor(Color.BLACK);
		backBufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		backBufferGraphics.setColor(Color.RED);
		backBufferGraphics.fillRect(obj.getterX(), obj.getterY(), obj.getterSize(), obj.getterSize());
		
		backBufferGraphics.setColor(Color.WHITE);
		backBufferGraphics.fillRoundRect(20, 20, 50, 50,10,10);
		
		backBufferGraphics.setColor(Color.blue);
		backBufferGraphics.drawString("X= " + Integer.toString(obj.getVelocityX()), 35 , 40);
		
		backBufferGraphics.setColor(Color.red);
		backBufferGraphics.drawString("Y= " + Integer.toString(obj.getVelocityY()), 35, 60);
		repaint();
	}
}
class Obj {
	private int velocityX;
	private int velocityY;
	private int x;
	private int y;
	private int size;

	public Obj() {
		this.velocityX = 0;
		this.x = 0;
		this.y = 0;
		this.size = 0;
	}
	public Obj(int velocityX, int velocityY, int x, int y, int size) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public int getVelocityX() {
		return velocityX;
	}
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}
	public int getVelocityY() {
		return velocityY;
	}
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
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
	public int getterSize() {
		return size;
	}
	public void setterSize(int size) {
		this.size = size;
	}
}

public class OvidiuGherman_Lab10_P08 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MyJFrame frame = new MyJFrame();
			frame.setVisible(true);
		});								
	}

}
