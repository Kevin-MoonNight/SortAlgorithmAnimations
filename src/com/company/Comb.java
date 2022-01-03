package com.company;

import java.awt.*;

public class Comb extends Sort {
    public Comb(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, null, 0));

        combSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, null, values.length));
    }

    public void combSort() {
        int gap = values.length;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap /= 1.3;
            }

            swapped = false;
            for (int i = 0; i < values.length - gap; i++) {
                int end = i + gap;

                if (values[i] > values[end]) {
                    switchPosition(i, end);
                    swapped = true;
                }

                if (gap == 1) {
                    picture.drawArray(newArrayPicture(i, end, i));
                } else {
                    picture.drawArray(newArrayPicture(i, end, 0));
                }
            }
        }
    }

    private ArrayPicture newArrayPicture(Integer start, Integer end, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //sorted
        for (int i = 0; i < sorted; i++) {
            arrayPicture.setColor(i, Color.green);
        }

        //start
        if (end != null) {
            arrayPicture.setColor(start, Color.blue);
        }

        //end
        if (end != null) {
            arrayPicture.setColor(end, Color.red);
        }

        return arrayPicture;
    }
}