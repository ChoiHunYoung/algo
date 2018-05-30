package io.goorm.edu.Chapter03.C3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        int[] table = new int[1000000];

        fillTable(table, data, n);

        for (int i = 0; i < table.length; i++) {
            if (table[i] == 1) {
                if (i > 0) writer.write(" ");
                writer.write(String.valueOf(i));
            }
        }

        writer.flush();
        writer.close();
    }

    private static void fillTable (int[] table, int[] data, int n) {
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            table[data[i]] += 1;
        }
    }
}
