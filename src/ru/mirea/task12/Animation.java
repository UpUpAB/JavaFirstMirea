package ru.mirea.task12;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;


public class Animation extends JPanel {
    JFrame frame;
    JLabel animation;
    File folder;
    File[] files;
    Image[] images;
    JPanel panel;
    public Animation(){
        try {
            folder = new File("/Users/egor/IdeaProjects/JavaFirstMirea/src/ru/mirea/task5/animation/img");
            files = folder.listFiles();
            Arrays.sort(files);
            images = new Image[files.length];
            for (int i = 0; i < files.length; i++) {
                images[i] = ImageIO.read(files[i]);
            }

            panel = new JPanel(new BorderLayout());

            animation = new JLabel(new ImageIcon(images[0]));
            add(animation, BorderLayout.CENTER);

            ActionListener animate = new ActionListener() {

                private int i = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(i<images.length-1){
                        i++;
                    } else {
                        i = 0;
                    }
                    animation.setIcon(new ImageIcon(images[i]));
                }
            };
            Timer timer = new Timer(50,animate);

            JToggleButton button = new JToggleButton("Start/stop");
            button.addActionListener(e ->{
                if (button.isSelected()){
                    timer.start();
                } else {
                    timer.stop();
                }
            });
            add(button,BorderLayout.PAGE_END);
        } catch (Exception e) {
            System.out.println("Something wrong with images");
        }

    }
}
