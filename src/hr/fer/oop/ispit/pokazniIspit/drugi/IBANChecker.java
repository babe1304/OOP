package hr.fer.oop.ispit.pokazniIspit.drugi;

import javax.swing.*;
import java.awt.*;

public class IBANChecker extends JFrame {
    private JLabel IBANlabel = new JLabel("IBAN", SwingConstants.LEFT);
    private JLabel validanLabel = new JLabel("Validan:", SwingConstants.LEFT);
    private JTextField IBANtf = new JTextField("HR", 21);
    private JTextField validanTF = new JTextField();
    private JButton validanBTN = new JButton("Validiraj");

    public IBANChecker() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(0, 2));
        //validanTF.setEnabled(false);
        validanTF.setEditable(false);

        add(IBANlabel);
        add(IBANtf);
        add(validanLabel);
        add(validanTF);
        add(new JPanel());
        add(validanBTN);

        validanBTN.addActionListener((e) -> {
            IBANCheckDigit validator = new IBANCheckDigit();
            String iban = IBANtf.getText();

            Runnable HeavyTask = () -> {
                String validText;
                if (validator.isValid(iban)) validText ="DA";
                else validText = "NE";

                SwingUtilities.invokeLater(() -> validanTF.setText(validText));
            };

            new Thread(HeavyTask).start();
        });

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IBANChecker iban = new IBANChecker();
            iban.setLocation(200, 200);
        });
    }
}
