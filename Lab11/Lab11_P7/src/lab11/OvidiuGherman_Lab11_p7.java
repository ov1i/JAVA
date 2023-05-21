package lab11;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/* 7. 
 * Implement a Java application that concatenates in a TextArea component the content of the text files selected by the
 * user, as the user chooses the files. Each file’s content is preceded by the file’s name.
 */

class MyFrame extends JFrame {
	private JTextArea textArea;
	public MyFrame() {
		this.setTitle("FileOpener");
		this.setPreferredSize(new Dimension(800,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.textArea = new JTextArea();
		this.textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		this.add(scrollPane, BorderLayout.CENTER);


		JButton btn = new JButton("ADD");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(MyFrame.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					if(!selectedFile.getName().endsWith(".txt")) {
						throw new Exception();
					}
					displayResult(selectedFile);
				}
				} catch(Exception except) {
					textArea.append("INVALID FILE");
				}
			}
		});

		this.add(btn, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null);
	}
	private void displayResult(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			this.textArea.setText("");
			String fileName = file.getName();
			this.textArea.append("File: " + fileName + "\n");
			String line;
			while ((line = reader.readLine()) != null) {
				this.textArea.append(line + "\n");
			}
			this.textArea.append("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class OvidiuGherman_Lab11_p7 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
