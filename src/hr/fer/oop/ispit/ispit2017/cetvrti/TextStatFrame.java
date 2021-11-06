package hr.fer.oop.ispit.ispit2017.cetvrti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class TextStatFrame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JButton statsBtn = new JButton("Statistics");
    private JButton freqBtn = new JButton("Show frequencies");
    private JTextArea resultArea = new JTextArea();

    public TextStatFrame(String title) {
        setTitle(title);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JSplitPane centralPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        centralPanel.setResizeWeight(0.55);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(textArea, BorderLayout.CENTER);
        JScrollPane scroller1 = new JScrollPane(textArea);
        centralPanel.setLeftComponent(scroller1);

        JPanel rightPanel = new JPanel();
        resultArea.setEnabled(false);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(resultArea, BorderLayout.CENTER);
        JScrollPane scroller2 = new JScrollPane(resultArea);
        centralPanel.setRightComponent(scroller2);

        centralPanel.setPreferredSize(new Dimension(400, 200));

        add(centralPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.add(statsBtn);
        southPanel.add(freqBtn);

        add(southPanel, BorderLayout.SOUTH);

        statsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                resultArea.setText("");
                String[] count = getWords(textArea.getText());
                resultArea.setText(String.format("No of words: %d\n", count.length));
                resultArea.append("\n");

                for (String string : getFilteredWords(count, 6))
                    resultArea.append(String.format("%s\n", string));
            }
        });

        freqBtn.addActionListener((e) -> {
            resultArea.setText("");
            String[] count = getWords(textArea.getText());

            new Thread(() -> {
                Map<String, Integer> rez = new TreeMap<>();
                rez = getFrequencies(count);

                for (Map.Entry<String, Integer> entry : rez.entrySet()) {
                    SwingUtilities.invokeLater(() ->
                            resultArea.append(String.format("%s %d\n", entry.getKey(), entry.getValue())));
                }
            }).start();
        });
    }

    private List<String> getFilteredWords(String[] words, int noOfCharacters) {
        return Stream.of(words).filter(s -> s.length() >= noOfCharacters)
                .sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
    }

    private String [] getWords(String text){
        return text.split("[^a-zA-Z]+");
    }

    public Map<String, Integer> getFrequencies(String[] words){
        Map<String, Integer> frequencies = new TreeMap<>();
        for (String w : words) {
            w = w.toLowerCase();
            Integer n = frequencies.get(w);
            n = (n == null) ? 1 : ++n;
            frequencies.put(w, n);
        }
        return frequencies;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new TextStatFrame("Text Stat");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
