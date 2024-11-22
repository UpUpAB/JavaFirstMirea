package ru.mirea.task16.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LayoutGreetings extends JFrame {
    public LayoutGreetings(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


        JButton Center = new JButton("CENTER");

        Center.setBackground(Color.CYAN);
        Center.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Center.setBackground(Color.GRAY);
                Center.setText("Добро пожаловать в ЦАО");
            }
            public void mouseExited(MouseEvent evt) {
                Center.setBackground(Color.CYAN);
                Center.setText("CENTER");
            }});

        JButton West = new JButton("WEST");
        West.setBackground(Color.YELLOW);
        West.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                West.setBackground(Color.ORANGE);
                West.setText("Добро пожаловать в ЗАО");
            }
            public void mouseExited(MouseEvent evt) {
                West.setBackground(Color.YELLOW);
                West.setText("WEST");
            }});

        JButton East = new JButton("EAST");
        East.setBackground(Color.MAGENTA);
        East.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                East.setBackground(Color.BLUE);
                East.setForeground(Color.WHITE);
                East.setText("Добро пожаловать в ВАО");
            }
            public void mouseExited(MouseEvent evt) {
                East.setBackground(Color.MAGENTA);
                East.setForeground(Color.BLACK);
                East.setText("EAST");
            }});

        JButton South = new JButton("SOUTH");
        South.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                South.setBackground(Color.GRAY);
                South.setText("Добро пожаловать в ЮАО");
            }
            public void mouseExited(MouseEvent evt) {
                South.setBackground(Color.LIGHT_GRAY);
                South.setText("SOUTH");
            }});

        JButton North = new JButton("NORTH");
        North.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                North.setBackground(Color.GRAY);
                North.setText("Добро пожаловать в САО");
            }
            public void mouseExited(MouseEvent evt) {
                North.setBackground(Color.LIGHT_GRAY);
                North.setText("NORTH");
            }});
        add(Center, BorderLayout.CENTER);
        add(West, BorderLayout.WEST);
        add(East, BorderLayout.EAST);
        add(South, BorderLayout.SOUTH);
        add(North, BorderLayout.NORTH);



        setVisible(true);
    }


    public static void main(String[] args) {
        new LayoutGreetings();
    }
}
