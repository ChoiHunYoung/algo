package io.goorm.edu.Chapter02.J2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        if (isWinnable(data, n, k)) System.out.print("YES");
        else System.out.print("NO");
    }

    private static boolean isWinnable(int[] data, int n, int k) {
        long sum = 0;
        boolean isEven = false;

        for (int i = 0; i < k; i++) {
            sum += data[i];
        }

        if (sum % 2 == 0) isEven = true;
//        System.out.println(isEven);
//        System.out.println(sum);

        for (int i = 1; i < n - k + 1; i++) {
            if ((data[i + k - 1] - data[i - 1]) % 2 == 0) {
//                System.out.println("1::" + i + " " + k + " " + data[i+k-1] + " " + data[i - 1] + " " + isEven);
                if (isEven) return true;
            } else {
//                System.out.println("2::" + i + " " + k + " " + data[i+k-1] + " " + data[i - 1] + " " + isEven);
                if (!isEven) return true;
            }

            isEven = false;
        }

//        for (int i = 0; i < n - k + 1; i++) {
//            int sum = 0;
//            for (int j = 0; j < k; j++) {
//                sum += data[i + j];
//            }
//            if (sum % 2 == 0) return true;
//        }

        return false;
    }
}
