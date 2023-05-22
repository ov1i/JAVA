package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 3.
 * Build an application which measures the user's response time. The application randomly generates 10 red and black
 * circles. The application includes two buttons labelled RED and BLACK. The user must press the correct button. At the end
 * of the game, the app will display the number of correct answers and the user's average reaction time (use the method
 * System.currentTimeMillis()).
 */

class Circle {
    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class CircleCanvas extends JPanel {
    private Circle circle;

    public void setCircle(Circle circle) {
        this.circle = circle;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (circle != null) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = 50;

            g.setColor(circle.getColor());
            g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
    }
}

class CircleReaction {
    private static final int NUM_CIRCLES = 10;

    private List<Circle> circles;
    private int currentIndex;
    private long startTime;
    private long totalTime;
    private int correctAnswers;

    private JFrame frame;
    private JLabel promptLabel;
    private CircleCanvas circleCanvas;
    private JPanel buttonPanel;
    private JButton redButton;
    private JButton blackButton;

    public CircleReaction() {
        circles = new ArrayList<>();
        currentIndex = 0;
        startTime = 0;
        totalTime = 0;
        correctAnswers = 0;

        Random random = new Random();
        for (int i = 0; i < NUM_CIRCLES; i++) {
            Color color = random.nextBoolean() ? Color.RED : Color.BLACK;
            circles.add(new Circle(color));
        }

        frame = new JFrame("Response Time Measurement");
        frame.setPreferredSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        promptLabel = new JLabel("Press the correct button for the color of the circle");
        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(promptLabel, BorderLayout.NORTH);

        circleCanvas = new CircleCanvas();
        frame.add(circleCanvas, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout());

        redButton = new JButton("RED");
        redButton.addActionListener(new ButtonActionListener());
        buttonPanel.add(redButton);

        blackButton = new JButton("BLACK");
        blackButton.addActionListener(new ButtonActionListener());
        buttonPanel.add(blackButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void startGame() {
        currentIndex = 0;
        totalTime = 0;
        correctAnswers = 0;
        showNextCircle();
        frame.setVisible(true);
    }

    private void showNextCircle() {
        if (currentIndex >= circles.size()) {
            finishGame();
            return;
        }

        Circle circle = circles.get(currentIndex);
        circleCanvas.setCircle(circle);
        startTime = System.currentTimeMillis();
        currentIndex++;
    }

    private void finishGame() {
        circleCanvas.setCircle(null);
        frame.setVisible(false);
        buttonPanel.setVisible(false);

        int totalCircles = circles.size();
        double averageTime = totalTime / (double) totalCircles;

        System.out.println("Game over!");
        System.out.println("Total circles: " + totalCircles);
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Average reaction time: " + averageTime + " milliseconds");
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;

            JButton clickedButton = (JButton) e.getSource();
            Color buttonColor = clickedButton.getText().equals("RED") ? Color.RED : Color.BLACK;
            Circle currentCircle = circles.get(currentIndex - 1);

            if (currentCircle.getColor() == buttonColor) {
                correctAnswers++;
            }

            showNextCircle();
        }
    }
}

public class OvidiuGherman_Lab12_P03 {
    public static void main(String[] args) {
        CircleReaction app = new CircleReaction();
        app.startGame();
    }
}

