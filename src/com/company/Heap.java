package com.company;

import java.awt.*;

public class Heap extends Sort {
    public Heap(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, null, null));

        buildMaxHeap();
        heapSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, null, 0));
    }

    private void heapSort() {
        for (int i = values.length - 1; i > 0; i--) {
            switchPosition(0, i);
            maxHeapify(0, i);
            picture.drawArray(newArrayPicture(null, i - 1, i));
        }
    }

    private void buildMaxHeap() {
        for (int i = values.length / 2 - 1; i >= 0; i--) {
            maxHeapify(i, values.length);
        }
    }

    private void maxHeapify(int temp, int end) {
        int largest = temp;
        int left = (temp + 1) * 2 - 1, right = (temp + 1) * 2;

        if (left < end && values[largest] < values[left]) {
            largest = left;
        }

        if (right < end && values[largest] < values[right]) {
            largest = right;
        }

        if (largest != temp) {
            picture.drawArray(newArrayPicture(temp, right, null));

            switchPosition(largest, temp);

            maxHeapify(largest, end);
        }
    }

    private ArrayPicture newArrayPicture(Integer root, Integer maxHeap, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        if (maxHeap != null) {
            for (int k = 0; k <= maxHeap; k++) {
                if (k == values.length) {
                    break;
                }
                arrayPicture.setColor(k, Color.CYAN);
            }
        }

        if (root != null) {
            arrayPicture.setColor(root, Color.red);
        }

        //sorted
        if (sorted != null) {
            for (int k = sorted; k < values.length; k++) {
                arrayPicture.setColor(k, Color.green);
            }
        }

        return arrayPicture;
    }
}