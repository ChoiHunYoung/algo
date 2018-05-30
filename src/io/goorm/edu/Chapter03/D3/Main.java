package io.goorm.edu.Chapter03.D3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] FIBONACCI_TABLE;

    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = scanner.nextInt();
        fillFibonacciTable();

        for (int i = 0; i < t; i++) {
            int answer = scanner.nextInt() - 1;
            writer.write(String.valueOf(FIBONACCI_TABLE[answer]) + "\n");
        }

        FIBONACCI_TABLE = null;

        writer.flush();
        writer.close();
    }

    private static void fillFibonacciTable() {
        FIBONACCI_TABLE = new int[1000001];

        FIBONACCI_TABLE[0] = 0;
        FIBONACCI_TABLE[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            FIBONACCI_TABLE[i] = (FIBONACCI_TABLE[i - 1] + FIBONACCI_TABLE[i - 2]) % 100000000;
        }
    }
}
