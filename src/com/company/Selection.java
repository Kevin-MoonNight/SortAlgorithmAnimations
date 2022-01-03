package com.company;

import java.awt.*;

public class Selection extends Sort {
    public Selection(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, null, 0));

        selectionSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, null, values.length));
    }

    private void selectionSort() {
        int min;
        for (int i = 0; i < values.length; i++) {
            min = i;
            for (int j = i; j < values.length; j++) {
                //find min
                if (values[j] < values[min]) {
                    min = j;
                }

                picture.drawArray(newArrayPicture(min, j, i));
            }

            switchPosition(i, min);
        }
    }

    private ArrayPicture newArrayPicture(Integer min, Integer temp, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //min
        if (min != null) {
            arrayPicture.setColor(min, Color.red);
        }

        //temp
        if (temp != null) {
            arrayPicture.setColor(temp, Color.blue);
        }

        //sorted
        for (int k = 0; k < sorted; k++) {
            arrayPicture.setColor(k, Color.green);
        }

        return arrayPicture;
    }
}
