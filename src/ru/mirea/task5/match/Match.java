package ru.mirea.task5.match;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Match extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private String lastScorer = "N/A";
    private JLabel resultLabel, lastScorerLabel, winnerLabel;
    private Random rand = new Random();
    private int randPenalty;


    public void Match() {
        setTitle("Milan vs Madrid Match");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLayout(new GridLayout(2, 3, 10, 10));
        setLocationRelativeTo(null);


        // Кнопка "AC Milan"
        JButton milanButton = new JButton("AC Milan");
        milanButton.addActionListener(e -> {
            milanScore++;
            updateResults("AC Milan");
        });

        // Кнопка штрафа
        JButton randomButton = new JButton("Random penalty");
        randomButton.addActionListener(e -> {
            if ((milanScore+madridScore)>0){
                randPenalty = rand.nextInt(1,milanScore+madridScore+1);
                int randScorer = rand.nextInt(2);
                System.out.println("штраф "+randPenalty);
                System.out.println("кто "+randScorer);
                switch (randScorer){
                    case (0):
                        if (randPenalty>=milanScore){
                            randPenalty -= milanScore;
                            milanScore = 0;
                            madridScore -= randPenalty;
                        } else {
                            milanScore -= randPenalty;
                        }
                        updateResultsV2();
                        break;
                    case (1):
                        if (randPenalty>=madridScore){
                            randPenalty -= madridScore;
                            madridScore = 0;
                            milanScore -= randPenalty;
                        } else {
                            madridScore -= randPenalty;
                        }
                        updateResultsV2();
                        break;
                }

            }

        });

        // Кнопка "Real Madrid"
        JButton madridButton = new JButton("Real Madrid");
        madridButton.addActionListener(e -> {
            madridScore++;
            updateResults("Real Madrid");
        });

        resultLabel = new JLabel("Result: 0 X 0", JLabel.CENTER);

        lastScorerLabel = new JLabel("Last Scorer: N/A",JLabel.CENTER);

        winnerLabel = new JLabel("Winner: DRAW",JLabel.CENTER);

        add(milanButton);
        add(randomButton);
        add(madridButton);
        add(resultLabel);
        add(lastScorerLabel);
        add(winnerLabel);
    }

    private void updateResults(String scorer) {
        lastScorer = scorer;
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }
    private void updateResultsV2() {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Match frame = new Match();
            frame.Match();
            frame.setVisible(true);
        });
    }
}