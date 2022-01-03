package com.company;

import java.awt.*;

public class Picture extends Canvas {
    private int speed;

    public Picture(int speed) {
        setBackground(Color.black);
        setSize(200, 200);
        setSpeed(speed);
    }

    public void drawArray(ArrayPicture arrayPicture) {

        Graphics graphics = getGraphics();
        clear();
        int[] values = arrayPicture.getValues();
        int n = getWidth() / values.length;

        for (int i = 0; i < arrayPicture.getLength(); i++) {
            graphics.setColor(arrayPicture.getColors()[i]);
            graphics.fillRect(i * n, 200 - values[i] * 2, n - 1, values[i] * 2);
        }

        try {
            Thread.sleep(getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        graphics.dispose();
    }

    public void clear() {
        Graphics graphics = getGraphics();
        graphics.clearRect(0, 0, getWidth(), getHeight());
        graphics.dispose();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
