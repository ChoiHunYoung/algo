package io.goorm.edu.Chapter03.A3;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] data = new int[n];
        int[] table = new int[10000];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        fillTable(table);

        System.out.printf("%04d", getFrequentNumber(data, table, n));
    }

    private static int getFrequentNumber(int[] data, int[] table, int n) {
        int maxNumber = 0;

        for (int i = 0; i < n; i++) {
            table[data[i]] += 1;
        }

        for (int i = 0; i < table.length; i++) {
            if (table[i] > table[maxNumber]) {
                maxNumber = i;
            }
        }

        return maxNumber;
    }

    private static void fillTable(int[] table) {
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }
    }
}
