package ru.mirea.task12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combine {
    JFrame frame = new JFrame("Combine");


    public Combine(){
        JTextField jta = new JTextField(10);
        Font fnt = new Font("Times new roman",Font.BOLD,20);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel[] pnl = new JPanel[4];
        frame.setLayout(new GridLayout(2,2));
        for(int i = 0 ; i < pnl.length ; i++){
            int r = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            pnl[i] = new JPanel();
            pnl[i].setBackground(new Color(r,g,b));
            frame.add(pnl[i]);
        }
        pnl[3].setLayout(new GridLayout(1,2));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem restartItem = new JMenuItem("Перезапуск программы");
        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Combine();
            }
        });
        menu.add(exitItem);
        menu.add(restartItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        JButton jbutton = new JButton("Clear");
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
            }
        });
        JButton exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Combine();
            }
        });
        pnl[0].add(new Animation());
        pnl[1].add(new Match());
        pnl[2].add(jta);
        pnl[2].add(jbutton);
        pnl[3].add(exitButton);
        pnl[3].add(restartButton);
        jta.setForeground(Color.GREEN);
        jta.setFont(fnt);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
    }
}
