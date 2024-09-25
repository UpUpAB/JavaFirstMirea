package ru.mirea.task5.teortest;
import java.awt.*;
import javax.swing.*;
public class SecondGui {
    public static void main(String args[]){
        JFrame frame = new JFrame("My Second second GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
//создали панель
        JPanel panel= new JPanel();
//задали свойство панели – цвет фона
        panel.setBackground(Color.GRAY);
// задали свойство панели размеры
        panel.setPreferredSize( new Dimension(200,300));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        panel.add(button1);
        panel.add(button2);
//добавили панель к фрейму
        JLabel resultLabel = new JLabel("Result: 0 X 0", JLabel.CENTER);

        // Метка "Last Scorer"
        JLabel lastScorerLabel = new JLabel("Last Scorer: N/A",JLabel.CENTER);

        // Метка "Winner"
        JLabel winnerLabel = new JLabel("Winner: DRAW",JLabel.CENTER);
//упакуем во фрейм


        frame.getContentPane().add(panel);
        frame.add(resultLabel);
        frame.add(lastScorerLabel);
        frame.add(winnerLabel);

        frame.pack();
        frame.setVisible(true);
    }
}
