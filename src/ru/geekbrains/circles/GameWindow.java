package ru.geekbrains.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWindow extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int START_BALLS_COUNT = 10;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

    SpritesCollection sprites = new SpritesCollection(50);

    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        GameCanvas gameCanvas = new GameCanvas(this);

        // добавляем listener для обработки кликов мышки
        gameCanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //по клику добавляем в массив новый шар с координатами центра, равными точке клика
                sprites.add(new Ball(e.getX(), e.getY()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(gameCanvas);
        //добавляем Background на первое место массива
        setBackground();
        createBalls();
        setVisible(true);
    }

    //метод для добавления Background. Вызывается перед добавлением остальных элементов.
    private void setBackground (){
        sprites.add(new Background());
    }

    private void createBalls() {
        //задаем стартовое количество шаров
        for (int i = 1; i < START_BALLS_COUNT; i++) {
            sprites.add(new Ball());
        }
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        draw(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.getLength(); i++) {
            sprites.getElement(i).update(gameCanvas, deltaTime);
        }
    }

    private void draw(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < sprites.getLength(); i++) {
            sprites.getElement(i).render(gameCanvas, g);
        }
    }

}
