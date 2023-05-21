package lab11;


import java.awt.Canvas;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.text.StyleContext;

/* 3. 
 * Implement a TabbedView Java application that displays in each graphical panel:
 * 		- a drawing area
 * 		- the necessary components for selecting a font type, size and color
 * 		- the necessary components for choosing a geometrical shape (from a predefined set) and a size for the side / radius (as the case)
 */
class MyTabbedPane extends JTabbedPane {
	private MyCanvas drawingSection;
	private SettingsPanel settings;
	private ShapesPanel shapes;
	public MyTabbedPane() {

		this.drawingSection = new MyCanvas();
		this.settings = new SettingsPanel();
		this.shapes = new ShapesPanel(this.drawingSection.getShapes());
		this.add(drawingSection);
		this.add(settings);
		this.add(shapes);
	}
}

class MyCanvas extends Canvas {
	private String shapes[];
	private Color color;
	public static String shape = "circle";
	public MyCanvas() {
		this.setName("Drawing Section");
		this.shapes = new String[]{"Circle", "Square", "Rectangle"};
		this.color = Color.black;
	}
	public String[] getShapes() {
		return this.shapes;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return this.color;
	}

	@Override
	public void paint(Graphics g) {
		if(MyCanvas.shape.equalsIgnoreCase(this.shapes[0])) {
			g.drawOval(this.getWidth()/2 - 100 , this.getHeight()/2 - 100, 200, 200);
		}
		else if(MyCanvas.shape.equalsIgnoreCase(this.shapes[1])) {
			g.drawRect(this.getWidth()/2 - 20, this.getHeight()/2 - 20, 20, 20);
		}
		else {
			g.drawRect(this.getWidth()/2 - 20, this.getHeight()/2 - 50, 20, 50);
		}
	};

} 
class SettingsPanel extends JPanel {
	public SettingsPanel() {
		this.setName("Settings");
		this.setLayout(new GridLayout());	
		List fonts = new List();
		List colors = new List();
		List sizes = new List();

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] strFonts = ge.getAvailableFontFamilyNames();
		String[] strColors = {"Red", "Black", "White", "Blue", "Yellow", "Grey" };
		int[] intSizes = new int[20];	
		for(int i = 1; i < intSizes.length;i++) {
			sizes.add(Integer.toString(i));
		}		
		for (String tempStr : strFonts) {
			fonts.add(tempStr);			
		}		
		for (String tempStr : strColors) {
			colors.add(tempStr);				
		}		
		
		this.add(fonts);
		this.add(sizes);
		this.add(colors);
	}
}

class ShapesPanel extends JPanel {
	private String lastCommand;
	public ShapesPanel(String[] strShapes) {
		this.setName("Shapes");
		this.setLayout(new GridLayout());
		this.lastCommand = " ";
		List shapes = new List();
		for(String tempStr : strShapes) {
			shapes.add(tempStr);		
		}

		shapes.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedShape = shapes.getSelectedItem();

					if (selectedShape.equalsIgnoreCase("Circle") && !lastCommand.equalsIgnoreCase(selectedShape)) {
						removeTextFields();
						add(new TextField("0"));         
						lastCommand = selectedShape;
						MyCanvas.shape = selectedShape;   


					} else if (selectedShape.equalsIgnoreCase("Square")&& !lastCommand.equalsIgnoreCase(selectedShape)) {	
						removeTextFields();
						add(new TextField("0"));   
						lastCommand = selectedShape;
						MyCanvas.shape = selectedShape;
					} else if (selectedShape.equalsIgnoreCase("Rectangle")&& !lastCommand.equalsIgnoreCase(selectedShape)) {
						removeTextFields();
						add(new TextField("0"));   
						add(new TextField("0"));   
						lastCommand = selectedShape;
						MyCanvas.shape = selectedShape;

					}
					revalidate();
					repaint();

				}
			}
		});

		this.add(shapes);

	}
	private void removeTextFields() {
		Component[] components = this.getComponents();
		for (Component component : components) {
			if (component instanceof TextField) {
				this.remove(component);
			}
		}
	}
}


public class OvidiuGherman_Lab11_p3 {	
	public static void main(String[] args) {
		JFrame frame = new JFrame("TabbedView");
		MyTabbedPane tabs = new MyTabbedPane();
		frame.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.add(tabs);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
