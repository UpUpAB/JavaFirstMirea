package ru.mirea.task5.teortest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationExample extends JPanel implements ActionListener {

    private final int FRAME_COUNT = 10; // Количество кадров в анимации
    private Image[] frames; // Массив для хранения кадров анимации
    private int currentFrame = 0; // Текущий кадр
    private Timer timer; // Таймер для обновления кадров

    public AnimationExample() {
        loadFrames(); // Загружаем кадры анимации
        timer = new Timer(100, this); // Создаем таймер, который запускается каждые 100 миллисекунд
        timer.start(); // Запускаем таймер
    }

    private void loadFrames() {
        frames = new Image[FRAME_COUNT];
        for (int i = 0; i < FRAME_COUNT; i++) {
            frames[i] = new ImageIcon(getClass().getResource("/path/to/frames/frame" + i + ".png")).getImage();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frames[currentFrame], 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % FRAME_COUNT; // Обновляем текущий кадр
        repaint(); // Перерисовываем панель
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Example");
        AnimationExample animationExample = new AnimationExample();
        frame.add(animationExample);
        frame.setSize(800, 600); // Устанавливаем размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Устанавливаем окно по центру экрана
        frame.setVisible(true); // Делаем окно видимым
    }
}