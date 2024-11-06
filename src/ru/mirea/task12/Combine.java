package ru.mirea.task12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combine extends JFrame {
    JFrame frame = new JFrame("Combine");


    public Combine(){
        JTextField jta = new JTextField(10);
        Font fnt = new Font("Times new roman",Font.BOLD,20);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel[] pnl = new JPanel[3];
        frame.setLayout(new GridLayout(2,2));
        for(int i = 0 ; i < pnl.length ; i++){
            int r = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            pnl[i] = new JPanel();
            pnl[i].setBackground(new Color(r,g,b));
            frame.add(pnl[i]);
        }

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        JButton jbutton = new JButton("Clear");
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
            }
        });
        pnl[0].add(new Animation());
        pnl[1].add(new Match());
        pnl[2].add(jta);
        pnl[2].add(jbutton);
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
