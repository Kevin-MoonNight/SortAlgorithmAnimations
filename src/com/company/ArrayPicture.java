package com.company;

import java.awt.*;

public class ArrayPicture {
    private int[] values;
    private Color[] colors;
    private int length;

    public ArrayPicture(int length, int[] values) {
        setLength(length);
        setValues(values);
        colors = new Color[length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.white;
        }
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public Color[] getColors() {
        return colors;
    }

    public void setColor(int index, Color color) {
        colors[index] = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
