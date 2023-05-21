package lab11;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* 6. 
 * Write a Java application which includes a sign-up form for an online course. The form includes information regarding
 * the name, surname, year of study, faculty, financing (tax/budget) and the course. The year of study, faculty and course
 * are drop-down lists, and the financing is a check-box field. In a TextArea field print the filled-in information after the
 * Sign-up button is pressed.
 */

class MyFrame extends JFrame {
	private JTextField nameField;
	private JTextField surnameField;
	private JComboBox<String> yearMenu;
	private JComboBox<String> facultyMenu;
	private JComboBox<String> courseMenu;
	private JCheckBox financingMenu;
	private JTextArea output;
	private JPanel myPanel;
	public MyFrame() {
		
		this.setTitle("Course Sign-up");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.myPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;

		this.myPanel.add(new JLabel("Name:"), constraints);
		constraints.gridy++;
		this.myPanel.add(new JLabel("Surname:"), constraints);
		constraints.gridy++;
		this.myPanel.add(new JLabel("Year of Study:"), constraints);
		constraints.gridy++;
		this.myPanel.add(new JLabel("Faculty:"), constraints);
		constraints.gridy++;
		this.myPanel.add(new JLabel("Financing:"), constraints);
		constraints.gridy++;
		this.myPanel.add(new JLabel("Course:"), constraints);

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 1.0;

		this.nameField = new JTextField(20);
		this.myPanel.add(nameField, constraints);
		
		constraints.gridy++;
		this.surnameField = new JTextField(20);
		this.myPanel.add(surnameField, constraints);
		
		constraints.gridy++;
		String[] yearOptions = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
		this.yearMenu = new JComboBox<>(yearOptions);
		this.myPanel.add(yearMenu, constraints);
		
		constraints.gridy++;
		String[] facultyOptions = {"Electrical Engineering", "Computer Sciene"};
		this.facultyMenu = new JComboBox<>(facultyOptions);
		this.myPanel.add(facultyMenu, constraints);
		
		constraints.gridy++;
		this.financingMenu = new JCheckBox("Tax");
		this.myPanel.add(financingMenu, constraints);
		
		constraints.gridy++;
		String[] courseOptions = {"Computer Programming Languages", "Software Engineering", "PECC", "Introduction to Computer Science"};
		this.courseMenu = new JComboBox<>(courseOptions);
		this.myPanel.add(courseMenu, constraints);

		
		this.output = new JTextArea(10, 30);
		this.output.setEditable(false);
		JScrollPane outputScrollPane = new JScrollPane(output);

		JButton btn = new JButton("Sign-up");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				results();
			}
		});

	
		this.add(this.myPanel, BorderLayout.NORTH);
		this.add(outputScrollPane, BorderLayout.CENTER);
		this.add(btn, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null);

	}
	private void results() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String yearOfStudy = (String) yearMenu.getSelectedItem();
        String faculty = (String) facultyMenu.getSelectedItem();
        String financing = financingMenu.isSelected() ? "Tax" : "Budget";
        String course = (String) courseMenu.getSelectedItem();

        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(name).append("\n");
        result.append("Surname: ").append(surname).append("\n");
        result.append("Year of Study: ").append(yearOfStudy).append("\n");
        result.append("Faculty: ").append(faculty).append("\n");
        result.append("Financing: ").append(financing).append("\n");
        result.append("Course: ").append(course);

        this.output.setText(result.toString());
    }
}


public class OvidiuGherman_Lab11_p6 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
