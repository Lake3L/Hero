package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    BufferedImage grass;

    public MyPanel(){
setLayout(null);
        try {
            grass = ImageIO.read(new File("Images\\grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        for(int yg = 0; yg < 600; yg +=50)
            for(int xg = 0; xg < 800; xg+=50)
        g.drawImage(grass,xg,yg,null);
    }
}
