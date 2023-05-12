package lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/* 3. 
 * Write a Frame application that displays an image stored in a local file. Below the image display the filename with a
 * predefined Font. The text is drawn using a color composed of 3 predefined components (red, green, blue).
 */


class MyFrame extends Frame {
	private Image img;
	private String imageName;
	public MyFrame(String imageName) {
		super("ImageReader");
		
		this.setSize(1280,720);
		this.imageName = imageName;
		try {
			img = ImageIO.read(new File(imageName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addWindowListener(new exitListener());
		this.setVisible(true);
	}
	public Image getImage() {
		return this.img;
	}
	public String getImageName() {
		return this.imageName.replaceAll(".jpg", "");
	}
}

class exitListener extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent event) {
		System.exit(0);
	}
}

class MyPanel extends Panel {

	private Image img;
	private String imgName;
	public MyPanel(int width, int height, Image img, String imageName) {	
		this.img = img;
		this.imgName = imageName;
		
		this.setSize(width,height);
	}
	
	@Override
	public void paint(Graphics g) {
		int imgWidth = this.getWidth() - this.getWidth() / 4;
		int imgHeight = this.getHeight() - this.getHeight() / 4;
		g.drawImage(img, this.getWidth() / 8 , this.getHeight() / 8 , imgWidth , imgHeight , null);
		g.setColor(new Color(255,0,128));
		g.setFont(new Font("Comic Sans", Font.BOLD, 20));
		FontMetrics m = g.getFontMetrics();
		
		int panelCenterX = this.getWidth() / 8 + imgWidth / 2;
		int panelCenterY = this.getHeight() / 8 + imgHeight;
		
		int posX = panelCenterX - (m.stringWidth(this.imgName) / 2);
		int posY = panelCenterY + m.getHeight();
		
		g.drawString(imgName, posX, posY);
	}
}

public class OvidiuGherman_Lab10_P03 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("image.jpg");
		MyPanel panel = new MyPanel(frame.getWidth(), frame.getHeight(), frame.getImage(), frame.getImageName());
		frame.add(panel);
	}

}
