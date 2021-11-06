package hr.fer.oop.predavanja.Swing;

import javax.swing.*;
import java.awt.*;

public class EmailClient extends JFrame {

    public EmailClient() {
        setTitle("E-mail Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 480);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel panel = (JPanel) this.getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel panelGore = new JPanel();
        panelGore.setLayout(new BorderLayout());

        JPanel panelGore1 = new JPanel();
        JPanel panelGore2 = new JPanel();
        panelGore1.setLayout(new GridLayout(3, 1));
        panelGore2.setLayout(new GridLayout(3, 1));
        panelGore1.add(new JLabel("From:", SwingUtilities.RIGHT));
        panelGore2.add(new JTextField());
        panelGore1.add(new JLabel("To:", SwingUtilities.RIGHT));
        panelGore2.add(new JTextField());
        panelGore1.add(new JLabel("Subject:", SwingUtilities.RIGHT));
        panelGore2.add(new JTextField());

        panelGore.add(panelGore1, BorderLayout.WEST);
        panelGore.add(panelGore2, BorderLayout.CENTER);

        panel.add(panelGore, BorderLayout.NORTH);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(new JLabel("Message:"), BorderLayout.NORTH);
        JTextArea taMessage = new JTextArea();
        taMessage.setLineWrap(true);
        taMessage.setWrapStyleWord(true);
        panel1.add(taMessage, BorderLayout.CENTER);

        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(new JButton("Send E-mail"));
        panel2.add(new JButton("Clear Message"));

        add(panel2, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailClient emailClient = new EmailClient();
            emailClient.setVisible(true);
            emailClient.pack();
        });
    }

}
