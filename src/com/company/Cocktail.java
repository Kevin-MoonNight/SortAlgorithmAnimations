package com.company;

import java.awt.*;

public class Cocktail extends Sort {
    public Cocktail(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, 0, values.length));

        cocktailSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, values.length, values.length));
    }

    private void cocktailSort() {
        int start = 0, end = values.length;

        while (end - start > 1) {
            //find max
            for (int i = start; i < end - 1; i++) {
                if (values[i] > values[i + 1]) {
                    switchPosition(i, i + 1);
                }

                picture.drawArray(newArrayPicture(i + 1, start, end));
            }
            end--;

            //find min
            for (int i = end - 1; i > start; i--) {

                if (values[i] < values[i - 1]) {
                    switchPosition(i, i - 1);
                }

                picture.drawArray(newArrayPicture(i - 1, start, end));
            }

            start++;
        }
    }

    private ArrayPicture newArrayPicture(Integer temp, Integer start, Integer end) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //sorted
        for (int i = 0; i < start; i++) {
            arrayPicture.setColor(i, Color.green);
        }
        for (int i = end; i < values.length; i++) {
            arrayPicture.setColor(i, Color.green);
        }

        //temp
        if (temp != null) {
            arrayPicture.setColor(temp, Color.red);
        }

        return arrayPicture;
    }
}
