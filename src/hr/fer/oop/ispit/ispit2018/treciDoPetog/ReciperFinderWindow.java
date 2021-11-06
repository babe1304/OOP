package hr.fer.oop.ispit.ispit2018.treciDoPetog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

class RecipesFinderWindow extends JFrame {

    public RecipesFinderWindow() {
        JTextField tfIngredient = new JTextField();
        JButton btnStart = new JButton("Start");
        JLabel lblIngredient = new JLabel("Enter ingredient:");
        JLabel lblResults = new JLabel("Results");
        JTextArea resultsArea = new JTextArea();
        JProgressBar progressBar = new JProgressBar();
        progressBar.setOrientation(SwingConstants.VERTICAL);
        JButton btnCopy = new JButton("Copyright");
        JButton btnAbout = new JButton("About");
        String avgRatingFormat = "Average recipe rating: %s";
        JLabel lblAvgRating = new JLabel(String.format(avgRatingFormat, ""));

        setLayout(new BorderLayout());
        add(progressBar, BorderLayout.EAST);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 3, 20, 20));
        northPanel.add(lblIngredient);
        northPanel.add(tfIngredient);
        northPanel.add(btnStart);

        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(lblResults, BorderLayout.NORTH);
        centerPanel.add(resultsArea, BorderLayout.CENTER);
        JLabel avgLabel = new JLabel(avgRatingFormat, SwingConstants.LEFT);
        centerPanel.add(avgLabel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(btnAbout);
        southPanel.add(btnCopy);

        add(southPanel, BorderLayout.SOUTH);
        pack();

        //end of layout

        ActionListener listener = e -> {
            String ingredient = tfIngredient.getText();
            if (ingredient.length() > 0) {
                btnStart.setEnabled(false);

                Consumer<Integer> onDone = i -> {
                    lblAvgRating.setText(String.format("Average recipe rating: %s", i));
                    btnStart.setEnabled(true);
                };

                //TO DO: define formatter
                Function<Triple<String, String, Integer>, String> formatter = (triple) ->
                        String.format("%s: %s, rating: %d\n", triple.getFirst(), triple.getSecond(), triple.getThird());

                //TO DO: define consumer (uses resultsArea.append(some text))
                Consumer<String> consumer = (string) ->
                    resultsArea.append(string);
                //

                RecipeWorker worker = new RecipeWorker(ingredient, consumer, onDone, formatter);

                //TO DO: define display of progress
                worker.addPropertyChangeListener(pc -> {
                    if (pc.getPropertyName().equals("progress"))
                        progressBar.setValue((int) pc.getNewValue());
                });
                worker.execute();
            }
        };
        btnStart.addActionListener(listener);
        //
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recipes finder");
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() ->
        {
            JFrame window = new RecipesFinderWindow();
            window.setLocation(100, 100);
            window.setVisible(true);
        });
    }
}