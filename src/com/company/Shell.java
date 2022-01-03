package com.company;

import java.awt.*;

public class Shell extends Sort {
    public Shell(int[] values, String title, int speed) {
        super(values, title, speed);
    }

    @Override
    public void sort() {
        //起始畫面
        picture.drawArray(newArrayPicture(null, null, 0));

        shellSort();

        //結束後全都是綠色
        picture.drawArray(newArrayPicture(null, null, values.length));
    }

    public void shellSort() {
        int k = values.length / 2;

        while (k > 0) {
            int start = 0, end = k;

            while (end < values.length) {

                if (values[end] < values[start]) {
                    switchPosition(end, start);

                    //callback sort
                    int tempStart = start - k, tempEnd = end - k;
                    while (tempStart >= 0) {
                        if (values[tempEnd] < values[tempStart]) {
                            switchPosition(tempEnd, tempStart);
                        } else {
                            break;
                        }

                        if (k == 1) {
                            picture.drawArray(newArrayPicture(tempStart, tempEnd, tempStart));
                        } else {
                            picture.drawArray(newArrayPicture(tempStart, tempEnd, 0));
                        }

                        tempStart -= k;
                        tempEnd -= k;
                    }
                }

                if (k == 1) {
                    picture.drawArray(newArrayPicture(start, end, start));
                } else {
                    picture.drawArray(newArrayPicture(start, end, 0));
                }

                start += k;
                end += k;
            }

            k /= 2;
        }
    }

    private ArrayPicture newArrayPicture(Integer start, Integer end, Integer sorted) {
        ArrayPicture arrayPicture = new ArrayPicture(values.length, values);

        //sorted
        for (int k = 0; k < sorted; k++) {
            arrayPicture.setColor(k, Color.green);
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
