package lab12;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 5.
 * Write a Java GUI application which includes a course registration form. The interface contains 2 TextField components
 * for entering the name and the group and a ComboBox selection list for choosing the course name. The form has a
 * ”Register” button that saves in a file the data entered by the user. Monitor the keyboard events for allowing only letters
 * in the first TextField and only digits in the second one.
 */

class MyFrame extends JFrame {
    private JTextField nameField;
    private JTextField groupField;
    private JComboBox<String> courseMenu;

    public MyFrame() {
        setTitle("Course Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel myPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;

        myPanel.add(new JLabel("Name:"), constraints);
        constraints.gridy++;
        myPanel.add(new JLabel("Group:"), constraints);
        constraints.gridy++;
        myPanel.add(new JLabel("Course:"), constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        nameField = new JTextField(20);
        nameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        myPanel.add(nameField, constraints);

        constraints.gridy++;
        groupField = new JTextField(20);
        groupField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        myPanel.add(groupField, constraints);

        constraints.gridy++;
        String[] courseOptions = { "Course 1", "Course 2", "Course 3", "Course 4" };
        courseMenu = new JComboBox<>(courseOptions);
        myPanel.add(courseMenu, constraints);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        add(myPanel, BorderLayout.NORTH);
        add(registerButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void register() {
        String name = nameField.getText();
        String group = groupField.getText();
        String course = (String) courseMenu.getSelectedItem();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Group: " + group);
            writer.newLine();
            writer.write("Course: " + course);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class OvidiuGherman_Lab12_P05 {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }
}
