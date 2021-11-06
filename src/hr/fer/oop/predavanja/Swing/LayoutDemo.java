package hr.fer.oop.predavanja.Swing;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo extends JFrame {

    public LayoutDemo() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane jtPane = new JTabbedPane();
        jtPane.addTab("Layout 1", new PanelWithLayout1());
        jtPane.addTab("Layout 2", new PanelWithLayout2());
        jtPane.addTab("Layout 3", new PanelWithLayout3());
        jtPane.addTab("Input Data Form", new InputDataForm());
        add(jtPane);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutDemo().setVisible(true));
    }

    private class PanelWithLayout1 extends JPanel {
        public PanelWithLayout1() {
            setLayout(new BorderLayout());

            JButton button1 = new JButton("Button 1");
            add(button1, BorderLayout.CENTER);
            JButton button2 = new JButton("Button 2");
            add(button2, BorderLayout.NORTH);
            JButton button3 = new JButton("Button 3");
            add(button3, BorderLayout.SOUTH);
            JButton button4 = new JButton("Button 4");
            add(button4, BorderLayout.EAST);
            JButton button5 = new JButton("Button 5");
            add(button5, BorderLayout.WEST);
        }
    }

    private class PanelWithLayout2 extends JPanel {
        public PanelWithLayout2() {
            setLayout(new FlowLayout());

            JButton button1 = new JButton("Button1");
            add(button1);
            JButton button2 = new JButton("Button2 is very long");
            add(button2);
            JButton button3 = new JButton("Button3");
            add(button3);
            JButton button4 = new JButton("Button4 is very long");
            add(button4);
            JButton button5 = new JButton("Button5");
            add(button5);
        }
    }

    private class PanelWithLayout3 extends JPanel {
        public PanelWithLayout3() {
            setLayout(new GridLayout(0, 2));

            JButton button1 = new JButton("Button1");
            add(button1);
            JButton button2 = new JButton("Button2 is very long?");
            add(button2);
            JButton button3 = new JButton("Button3");
            add(button3);
            JButton button4 = new JButton("Button4");
            add(button4);
            JButton button5 = new JButton("Button5");
            add(button5);
        }
    }

    private class InputDataForm extends JPanel {
        public InputDataForm() {
            setLayout(new GridLayout(0, 2));

            JLabel labela1 = new JLabel("Name:", SwingConstants.RIGHT);
            add(labela1);
            JTextField input1 = new JTextField();
            add(input1);
            JPanel panel = new JPanel();
            add(panel);
            JCheckBox button = new JCheckBox();
            add(button);
            JLabel labela2 = new JLabel("Adress:", SwingConstants.RIGHT);
            add(labela2);
            JTextField input2 = new JTextField();
            add(input2);
        }
    }
}
