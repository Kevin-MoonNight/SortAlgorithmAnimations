package com.company;

import java.awt.*;

public class Merge extends Sort {

    public Merge(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, null, 1, 0));

        int[] result = new int[values.length];
        mergeSort(result, 0, values.length - 1);

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, null, 0, values.length - 1));
    }

    private void mergeSort(int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len / 2) + start;
        int start1 = start, start2 = mid + 1;

        mergeSort(result, start1, mid);
        mergeSort(result, start2, end);

        merge(result, start1, start2, mid, start, end);
    }

    private void merge(int[] result, int start1, int start2, int mid, int start, int end) {
        //merge
        int k = start;
        while (start1 <= mid && start2 <= end) {
            picture.drawArray(newArrayPicture(start1, start2, 1, 0));
            result[k++] = values[start1] < values[start2] ? values[start1++] : values[start2++];
        }
        while (start1 <= mid) {
            picture.drawArray(newArrayPicture(start1, start2, 1, 0));
            result[k++] = values[start1++];
        }
        while (start2 <= end) {
            picture.drawArray(newArrayPicture(start1, start2, 1, 0));
            result[k++] = values[start2++];
        }

        //copy answer
        for (int i = start; i <= end; i++) {
            picture.drawArray(newArrayPicture(null, null, start, i));
            values[i] = result[i];
        }
    }

    private ArrayPicture newArrayPicture(Integer position1, Integer position2, Integer sortedStart, Integer sortedEnd) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //min
        if (position1 != null && position1 < values.length) {
            arrayPicture.setColor(position1, Color.red);
        }

        //temp
        if (position2 != null && position2 < values.length) {
            arrayPicture.setColor(position2, Color.blue);
        }

        //sorted
        for (int i = sortedStart; i <= sortedEnd; i++) {
            arrayPicture.setColor(i, Color.green);
        }

        return arrayPicture;
    }

}
