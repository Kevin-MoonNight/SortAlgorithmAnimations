package com.company;

import javax.swing.*;
import java.awt.*;

public class Picture extends JPanel {
    private final Dimension preferredSize;
    private ArrayPicture arrayPicture;
    private int speed;

    public Picture(int speed) {
        //setting the size of picture
        preferredSize = new Dimension(201, 200);
        setBackground(Color.black);
        setSpeed(speed);
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (arrayPicture != null) {
            int[] values = arrayPicture.getValues();
            int n = getWidth() / values.length;

            for (int i = 0; i < arrayPicture.getLength(); i++) {
                g.setColor(arrayPicture.getColors()[i]);
                g.fillRect(i * n + 1, 200 - values[i] * 2, n - 1, values[i] * 2);
            }
        }
    }

    public void drawArray(ArrayPicture arrayPicture) {
        //setting the contents of array
        setArrayPicture(arrayPicture);

        //drawing
        repaint();

        try {
            Thread.sleep(getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setArrayPicture(ArrayPicture arrayPicture) {
        this.arrayPicture = arrayPicture;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}