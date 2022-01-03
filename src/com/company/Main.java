package com.company;

import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        int[] values = newValues(20);

        Sort[] sorts = newSort(values, 100);

        initFrame(newPanel(sorts), newButton(sorts));
    }

    public static int[] newValues(int n) {
        int[] values = new int[n];

        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (Math.random() * 101 + 1);
        }

        return values;
    }

    public static Sort[] newSort(int[] values, int speed) {
        Sort[] sorts = new Sort[9];

        sorts[0] = new Selection(values.clone(), "SelectionSort", speed);
        sorts[1] = new Insertion(values.clone(), "InsertionSort", speed);
        sorts[2] = new Bubble(values.clone(), "BubbleSort", speed);
        sorts[3] = new Shell(values.clone(), "ShellSort", speed);
        sorts[4] = new Cocktail(values.clone(), "CocktailSort", speed);
        sorts[5] = new Comb(values.clone(), "CombSort", speed);
        sorts[6] = new Merge(values.clone(), "MergeSort", speed);
        sorts[7] = new Quick(values.clone(), "QuickSort", speed);
        sorts[8] = new Heap(values.clone(), "HeapSort", speed);

        return sorts;
    }

    public static void initFrame(Panel panel, Button button) {
        Frame frame = new Frame("SortAlgorithm");
        frame.addWindowListener(new AdapterDemo());
        frame.setLayout(new FlowLayout());

        frame.add(panel);
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
    }

    public static Button newButton(Sort[] sorts) {
        Button button = new Button("start");
        button.addActionListener(e -> {
            for (int i = 0; i < sorts.length; i++) {
                if (sorts[i] != null) {
                    sorts[i].start();
                }
            }
        });

        return button;
    }

    public static Panel newPanel(Sort[] sorts) {
        Panel panel = new Panel();
        panel.setLocation(10, 10);
        GridLayout gridLayout = new GridLayout(3, 3);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);

        for (int i = 0; i < sorts.length; i++) {
            if (sorts[i] != null) {
                panel.add(sorts[i].getPicture());
            }
        }

        return panel;
    }
}

class AdapterDemo extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}