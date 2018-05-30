package io.goorm.edu.Chapter02.H2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("#%d\n", i + 1);
            System.out.printf("%d\n", getCount(scanner.nextLong()) * 4);
        }
    }

    private static long getCount(long r) {
        long result = 0;
        long j = r;

        for (long i = 0; i < r; i++) {
            long height = 0;
            for ( ; j >= 0; j--) {
                if (isInner(r, i, j)) {
                    height = (j + 1);
                    break;
                }
            }
            result += height;
        }

        return result;
    }

    private static boolean isInner(long r, long i, long j) {

        return (r * r > (i * i + j * j));
    }
}
