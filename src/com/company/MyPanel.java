package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    BufferedImage grass;
    Hero hero;

    boolean click = false;
    int mx, my;


    class MyKL implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT: stepLeft(); break;
                case KeyEvent.VK_RIGHT: stepRight(); break;
                case KeyEvent.VK_UP: stepUp(); break;
                case KeyEvent.VK_DOWN: stepDown(); break;
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    class MyML implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            mx = e.getX();
            my = e.getY();
            click = true;
            repaint();
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
    }
    public MyPanel() {
        setLayout(null);
        addKeyListener(new MyKL());
        addMouseListener(new MyML());
        setFocusable(true);
        hero = new Hero(0, 0);
        try {
            grass = ImageIO.read(new File("Images\\grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void stepLeft(){
        hero.stepX(-Const.STEP);
    }
    void stepRight(){
        hero.stepX(Const.STEP);
    }
    void stepUp(){
        hero.stepY(-Const.STEP);
    }
    void stepDown(){
        hero.stepY(Const.STEP);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        for (int yg = 0; yg < Const.H; yg += Const.STEP) {
            for (int xg = 0; xg < Const.W; xg += Const.STEP) {
                g.drawImage(grass, xg, yg, null);
            }
        }
        hero.draw(g);
        if (click) {
            g.setColor(Color.RED);
            g.fillOval(mx, my, Const.STEP, Const.STEP);
            click = false;
        }
    }
    }
