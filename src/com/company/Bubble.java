package com.company;

import java.awt.*;

public class Bubble extends Sort {
    public Bubble(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, values.length));

        bubbleSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, 0));
    }

    private void bubbleSort() {
        int end = values.length;

        while (end > 1) {
            for (int i = 1; i < end; i++) {
                if (values[i - 1] > values[i]) {
                    switchPosition(i - 1, i);
                }

                picture.drawArray(newArrayPicture(i, end));
            }

            end--;
        }
    }

    private ArrayPicture newArrayPicture(Integer temp, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //sorted
        for (int k = sorted; k < values.length; k++) {
            arrayPicture.setColor(k, Color.green);
        }

        //temp
        if (temp != null) {
            arrayPicture.setColor(temp, Color.red);
        }

        return arrayPicture;
    }

}
