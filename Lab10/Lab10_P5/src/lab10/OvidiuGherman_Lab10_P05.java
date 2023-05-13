package lab10;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 5. 
 * Write a Frame application that draws a circle colored in all the possible colors. The starting color is red and the color
 * transitions must be made as smooth as possible.
 */

class MyFrame extends Frame {
	public MyFrame() {
		super("CircleGenerator");
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
	private Color color;
	public MyCanvas() {
		color = Color.RED;
	}
	@Override
    public void update(Graphics g) {
		int rad = 300;		
		g.setColor(color);
		g.fillOval(getWidth()/2 - rad/2 ,getHeight()/2 - rad/2 ,rad ,rad);
    }
	public void setColor(Color color) {
		this.color = color;
	}


}

public class OvidiuGherman_Lab10_P05 {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);

        Thread thread = new Thread(() -> {
            float hue = 0.0f;

            while (true) {
                hue = (hue + 0.001f) % 1.0f;
                canvas.setColor(Color.getHSBColor(hue, 1.0f, 1.0f));
                canvas.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
	}

}
