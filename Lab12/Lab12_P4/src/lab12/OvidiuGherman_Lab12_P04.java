package lab12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/* 4. 
 * Implement a graphical Java application that displays in the main frame a button labeled ”Start” and a Canvas
 * component. After pushing the button its label is changed to ”Stop” and a thread is started. The thread draws a circle on
 * the canvas. The circle is descending from the upper left corner and is moved to the right in the same time. When hitting
 * the canvas margins, the circle changes its moving direction. The drawing thread is stopped when the user presses the
 * button again.
 */

class MyFrame extends JFrame {
	private MyPanel drawingPanel;
	private JButton startButton;
	private boolean isDrawing;
	private Thread drawingThread;

	public MyFrame() {
		this.setTitle("Circle Drawing App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,600));
		setResizable(false);

		drawingPanel = new MyPanel();
		startButton = new JButton("Start");

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isDrawing = !isDrawing;
				if (isDrawing) {
					startButton.setText("Stop");
					startDrawing();
				} else {
					startButton.setText("Start");
					stopDrawing();
				}
			}
		});

		this.setLayout(new BorderLayout());
		this.add(drawingPanel, BorderLayout.CENTER);
		this.add(startButton, BorderLayout.SOUTH);
		this.pack();
	}

	private void startDrawing() {
		drawingThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (isDrawing) {
					drawingPanel.drawCircle();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		drawingThread.start();
	}

	private void stopDrawing() {
		isDrawing = false;
		try {
			drawingThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		drawingPanel.clear();
	}
}


class MyPanel extends JPanel {
	private BufferedImage buffer;
	private Graphics2D bufferGraphics;

	private int circleX;
	private int circleY;
	private int dx;
	private int dy;

	public MyPanel() {
		this.setPreferredSize(new Dimension(800, 600));
		this.buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.bufferGraphics = buffer.createGraphics();

		this.clear();
	}

	public void drawCircle() {
		this.bufferGraphics.setColor(Color.BLACK);
		this.bufferGraphics.fillRect(0, 0, 800, 600);

		this.bufferGraphics.setColor(Color.RED);
		this.bufferGraphics.fillOval(circleX, circleY, 50, 50);

		this.circleX += this.dx;
		this.circleY += this.dy;

		if (circleX <= 0 || circleX >= 800 - 50) {
			this.dx = -this.dx;
		}
		if (circleY <= 0 || circleY >= 500) {
			this.dy = -this.dy;
		}

		Graphics g = getGraphics();
		if (g != null) {
			g.drawImage(buffer, 0, 0, null);
			g.dispose();
		}
	}

	public void clear() {
		bufferGraphics.setColor(Color.BLACK);
		bufferGraphics.fillRect(0, 0, 800, 600);

		this.circleX = 0;
		this.circleY = 0;
		this.dx = 5;
		this.dy = 5;

		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
	}
}


public class OvidiuGherman_Lab12_P04 {

	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame frame = new MyFrame();
                frame.setVisible(true);
            }
        });
	}

}
