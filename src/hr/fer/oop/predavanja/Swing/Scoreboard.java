package hr.fer.oop.predavanja.Swing;

import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JFrame {
    private JButton redPoints = new JButton("New points for red");
    private JButton bluePoints = new JButton("New points for blue");
    private JButton resetButton = new JButton("Reset");
    private JLabel redLabel = new JLabel("0", SwingConstants.CENTER);
    private JLabel blueLabel = new JLabel("0", SwingConstants.CENTER);

    public Scoreboard() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Scoreboard");
        setLayout(new GridLayout(3, 1));

        JPanel northPanel = new JPanel();
        resetButton.addActionListener((e) -> {
            redLabel.setText("0");
            blueLabel.setText("0");
        });
        northPanel.add(resetButton);

        add(northPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        redLabel.setOpaque(true);
        redLabel.setBackground(Color.RED);
        blueLabel.setOpaque(true);
        blueLabel.setBackground(Color.BLUE);

        centerPanel.add(redLabel);
        centerPanel.add(blueLabel);

        add(centerPanel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        southPanel.add(redPoints);
        redPoints.addActionListener((e) -> {
            int bodovi = Integer.valueOf(redLabel.getText());
            redLabel.setText(String.valueOf(bodovi + 1));
        });
        southPanel.add(bluePoints);
        bluePoints.addActionListener((e) -> {
            int bodovi = Integer.valueOf(blueLabel.getText());
            blueLabel.setText(String.valueOf(bodovi + 1));
        });

        add(southPanel);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Scoreboard sb = new Scoreboard();
            sb.setVisible(true);
        });
    }
}
