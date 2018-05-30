package io.goorm.edu.Chapter02.I2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        if (isSequence(data, n)) System.out.print("YES");
        else System.out.println("NO");
    }

    private static boolean isSequence(int[] data, int n) {

//        Arrays.sort(data);
//
//        for (int i = 0; i < n - 1; i++) {
//            if (data[i] + 1 != data[i+1]) return false;
//        }

        int minData = data[0];
        int maxData = data[0];

        for (int i = 0; i < n; i++) {
            if (maxData < data[i]) maxData = data[i];
            if (minData > data[i]) minData = data[i];
        }

        return (maxData - minData + 1 == n);
    }
}
