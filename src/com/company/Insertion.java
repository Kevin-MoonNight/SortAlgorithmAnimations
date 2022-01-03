package com.company;

import java.awt.*;

public class Insertion extends Sort {
    public Insertion(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, 0));

        insertionSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, values.length));
    }

    private void insertionSort() {
        for (int i = 0; i < values.length; i++) {
            int tempIndex = i;
            for (int j = (i - 1); j >= 0; j--) {
                if (values[j] < values[tempIndex]) {
                    break;
                } else {
                    switchPosition(tempIndex, j);
                    tempIndex = j;
                }

                picture.drawArray(newArrayPicture(tempIndex, i));
            }
        }
    }

    private ArrayPicture newArrayPicture(Integer temp, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //sorted
        for (int k = 0; k < sorted; k++) {
            arrayPicture.setColor(k, Color.green);
        }

        //temp
        if (temp != null) {
            arrayPicture.setColor(temp, Color.red);
        }

        return arrayPicture;
    }
}
