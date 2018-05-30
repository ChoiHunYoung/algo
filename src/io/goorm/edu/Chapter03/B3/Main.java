package io.goorm.edu.Chapter03.B3;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Paint[] paints = new Paint[m];

        for (int i = 0; i < m; i++) {
            int minNum = scanner.nextInt() - 1;
            int maxNum = scanner.nextInt() - 1;
            int colNum = scanner.nextInt();
            paints[i] = new Paint(minNum, maxNum, colNum);
        }

        findPaint(paints, n, m);
    }

    private static void findPaint(Paint[] paints, int n, int m) {
        int[] seats = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = paints[i].minNum; j <= paints[i].maxNum; j++) {
                seats[j] = paints[i].colNum;
            }
        }

        int[] table = new int[100];
        fillColorTable(seats, table, n);

        int minCol = seats[0];
        int maxCol = seats[0];

        for (int i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                if (table[minCol] > table[i]) minCol = i;
                if (table[maxCol] < table[i]) maxCol = i;
            }
        }

        System.out.println(maxCol);
        System.out.println(minCol);
    }

    private static void fillColorTable(int[] data, int[] table, int n) {
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            table[data[i]] += 1;
        }
    }
}

class Paint {
    int minNum;
    int maxNum;
    int colNum;

    public Paint(int minNum, int maxNum, int colNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.colNum = colNum;
    }
}
