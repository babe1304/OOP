package hr.fer.oop.ispit.ispit2019.cetvrti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RollingDie extends JFrame implements ActionListener {
    private JLabel textLbl = new JLabel("Broj bacanja kocke:");
    private JTextField numberOfRollsTf = new JTextField(10);
    private JLabel [] dieValues = new JLabel[6];
    private JLabel [] occurrences = new JLabel[6];
    private JButton startBtn = new JButton("Start");
    private JPanel inputPnl = new JPanel();
    private JPanel centralPnl = new JPanel();
    private JPanel buttonPnl = new JPanel();
    
    public RollingDie() {
        
        inputPnl.add(textLbl);
        inputPnl.add(numberOfRollsTf);
        centralPnl.setLayout(new GridLayout(6,2));

        for (int i = 0; i < 6; i++) {
            centralPnl.add(dieValues[i] = new JLabel("[" + (i+1) + "]"));
            centralPnl.add(occurrences[i] = new JLabel());
        }

        buttonPnl.add(startBtn);

        this.add(inputPnl, BorderLayout.NORTH);
        this.add(centralPnl, BorderLayout.CENTER);
        this.add(buttonPnl, BorderLayout.SOUTH);
        startBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int numberOfRolls = Integer.parseInt(numberOfRollsTf.getText());

            for (int i = 0; i < 6; i++)
                occurrences[i].setText("");
            startBtn.setEnabled(false);

            new SimulationTask(Integer.parseInt(numberOfRollsTf.getText())).execute();
        } catch (NumberFormatException ex) {

        }
    }

    private class SimulationTask extends SwingWorker<Double, Map<Integer, Integer>> {
        int numberOfRolls;
        Map<Integer, Integer> map = new HashMap<>();

        public SimulationTask(int numberOfRolls){
            this.numberOfRolls = numberOfRolls;
            for (int i = 0; i<6; i++)
                map.put(i, Integer.valueOf(0));
        }

        @Override
        protected void process(List<Map<Integer, Integer>> chunks) {
            Map<Integer, Integer> numbers = chunks.get(chunks.size() - 1);

            for (Map.Entry<Integer, Integer> pair : numbers.entrySet()) {
                occurrences[pair.getKey()].setText(String.format("%d", pair.getValue()));
            }
        }

        @Override
        protected Double doInBackground() throws Exception {
            for (int i = 0; i < numberOfRolls; i++) {
                Random random = new Random();
                int bacanje = random.nextInt(6);
                map.put(bacanje, map.get(bacanje) + 1);
                publish(map);
            }
            return numberOfRolls/6.;
        }

        @Override
        protected void done() {
            startBtn.setEnabled(true);
        }
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                RollingDie simulator = new RollingDie();

                simulator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                simulator.pack();
                simulator.setVisible(true);
            }
        });
    }


}
