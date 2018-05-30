package io.goorm.edu.Chapter02.E2;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Case #%d\n", i + 1);
            if (isPrimeNumber(scanner.nextInt())) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) return false;
        else if (number == 2) return true;
        else if (number % 2 == 0) return false;

        for (int i = 3; i*i <= number; i+=2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
