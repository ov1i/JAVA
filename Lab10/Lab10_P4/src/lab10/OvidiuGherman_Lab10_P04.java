package lab10;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/* 4. 
 * Write a Frame application that displays a TV test card. The card will contain at least 10 levels of grey and the basic
 * colors red, green, blue, yellow, cyan and magenta. The card will cover the entire surface of the component that displays
 * it (Canvas, etc.).
 */

class MyFrame extends Frame {
	public MyFrame() {
		super("Tv Test Card");
		this.setSize(1280, 720);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		this.setVisible(true);
	}
}

class MyCanvas extends Canvas {
	private Integer[] greyValues;
	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA};
	public MyCanvas() {
		Random random = new Random();
		greyValues = new Integer[10];
		for(int i = 0; i < this.greyValues.length;i++) {
			this.greyValues[i] = random.nextInt(0,256);
		}
		Arrays.sort(this.greyValues, Collections.reverseOrder());
	}
	@Override
	public void paint(Graphics g) {
		int level = this.getWidth() / (this.greyValues.length + colors.length);
		int x = 0;

        for (int currentVal : greyValues) {
            g.setColor(new Color(currentVal, currentVal, currentVal));
            g.fillRect(x, 0, level, this.getHeight());
            x += level;
        }
        for (Color color : colors) {
            g.setColor(color);
            g.fillRect(x, 0, level, this.getHeight());
            x += level;
        }
	}
}

public class OvidiuGherman_Lab10_P04 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		MyCanvas canvas = new MyCanvas();
		frame.add(canvas);
	}

}
