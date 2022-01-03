package com.company;

import java.awt.*;

public class Quick extends Sort {
    public Quick(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, null, null, 0));

        quickSort(0, values.length - 1);

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, null, null, values.length));
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            int index = partition(left, right);
            quickSort(left, index - 1);
            quickSort(index + 1, right);
        }
    }

    private int partition(int left, int right) {
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (values[j] <= values[right]) {
                i++;
                switchPosition(i, j);
            }
            picture.drawArray(newArrayPicture(i, j, right, 0));
        }

        switchPosition(i + 1, right);

        return i + 1;
    }


    private ArrayPicture newArrayPicture(Integer i, Integer j, Integer index, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //i
        if (i != null && i > 0) {
            arrayPicture.setColor(i, Color.red);
        }

        //j
        if (j != null) {
            arrayPicture.setColor(j, Color.blue);
        }

        if (index != null) {
            arrayPicture.setColor(index, Color.CYAN);
        }

        //sorted
        for (int k = 0; k < sorted; k++) {
            arrayPicture.setColor(k, Color.green);
        }

        return arrayPicture;
    }
}
