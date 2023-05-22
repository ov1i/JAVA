package lab12;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/* 2. 
 * Write a Java application which includes 3 sliders which enables the user to set the color of a 100x100 square. The
 * square will be drawn using a specific component (Canvas, etc.).
 */

class MyFrame extends JFrame { 
	public MyFrame() {
		super("Sliders");
		this.setPreferredSize(new Dimension(800,600));
		this.setLayout(new GridLayout(2,0));
		MyCanvas canvas = new MyCanvas();
		MyPanel panel = new MyPanel(canvas);
		this.add(panel);
		this.add(canvas);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel  {	
    private int R;
    private int G;
    private int B;
    private MyCanvas canvas;
	public MyPanel(MyCanvas canvas) {
		this.R = 0;
		this.G = 0;
		this.B = 0;
		this.canvas = canvas;
		this.setLayout(new GridLayout(3,0));
        JSlider redSlider = createSlider();
        redSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                R = redSlider.getValue();
                canvas.updateColor(R, G, B);
                repaint();
            }
        });
        
        JSlider greenSlider = createSlider();
        greenSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                G = greenSlider.getValue();
                canvas.updateColor(R, G, B);
                repaint();
            }
        });
        
        JSlider blueSlider = createSlider();
        blueSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                B = blueSlider.getValue();
                canvas.updateColor(R, G, B);
                repaint();
            }
        });
        
        this.add(redSlider);
        this.add(greenSlider);
        this.add(blueSlider);
    
	}
	private JSlider createSlider() {
        JSlider tempSlider = new JSlider(0, 255, 0);
        tempSlider.setPaintTicks(true);
        tempSlider.setMajorTickSpacing(50);
        tempSlider.setMinorTickSpacing(10);
        tempSlider.setPaintLabels(true);
        return tempSlider;
    }
}

class MyCanvas extends Canvas {
	private int R;
	private int G;
	private int B;

	public MyCanvas() {
		this.R = 0;
		this.G = 0;
		this.B = 0;
	}
	public void updateColor(int R, int G, int B) {
		this.R = R;
		this.G = G;
		this.B = B;
		this.repaint();
	}
	@Override
	public void paint(Graphics g) {
		Color color = new Color(this.R,this.G,this.B);
		g.setColor(color);
		g.fillRect(this.getWidth()/2 - 50 , this.getHeight() / 2 - 50 , 100 , 100);
	}
}

public class OvidiuGherman_Lab12_P02 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

}
