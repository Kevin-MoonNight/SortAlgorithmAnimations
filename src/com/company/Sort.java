package com.company;

import javax.swing.*;
import java.awt.*;

public abstract class Sort extends Thread {
    protected int[] values;
    protected final Picture picture;
    private String title;

    public Sort(int[] values, String title, int speed) {
        picture = new Picture(speed);
        this.values = values;
        setTitle(title);
    }

    public abstract void sort();

    public JPanel getPicture() {
        JPanel panel = new JPanel();
        panel.add(picture);
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createTitledBorder(getTitle()));

        return panel;
    }

    protected void switchPosition(int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }

    @Override
    public void run() {
        sort();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
