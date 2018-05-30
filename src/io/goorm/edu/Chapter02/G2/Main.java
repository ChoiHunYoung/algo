package io.goorm.edu.Chapter02.G2;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        bubbleSorting(data, n);

        for (int i = 0; i < n; i++) {
            System.out.print(data[i]);
            if (i != n-1) System.out.print(" ");
        }
    }

    private static void bubbleSorting(int[] data, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j+1]) {
                    int tempNum = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tempNum;
                    count++;
                }
            }
            if (count == 0) break;
        }
    }
}
