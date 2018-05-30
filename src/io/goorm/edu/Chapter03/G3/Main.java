package io.goorm.edu.Chapter03.G3;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] birthDate = new int[N];

        for (int i = 0; i < N; i++) {
            birthDate[i] = scanner.nextInt();
        }

        int answer = getAnswer(birthDate, N, K);

        System.out.printf("%d", answer);
    }

    private static int getAnswer(int[] birthDate, int n, int k) {
        int result = 0;
        FrequencyTable frequencyTable = new FrequencyTable();

        for (int i = 0; i < k - 1; i++) {
            frequencyTable.addBirthDate(birthDate[i]);
        }

        for (int i = 0; i + k - 1 < n; i++) {
            frequencyTable.addBirthDate(birthDate[i + k - 1]);

            if (i > 0) frequencyTable.removeBirthDate(birthDate[i - 1]);

            if (frequencyTable.uniqueCount == k) result += 1;
        }

        return result;
    }
}

class FrequencyTable {
    private static final int MAX_SIZE = 1000000;

    int uniqueCount;
    int[] frequency;

    FrequencyTable() {
        uniqueCount = 0;
        frequency = new int[MAX_SIZE];
    }

    void addBirthDate(int birthDate) {
        int count = frequency[birthDate];
        if (count == 0) {
            this.uniqueCount += 1;
        } else if (count == 1) {
            this.uniqueCount -= 1;
        }

        this.frequency[birthDate] += 1;
    }

    void removeBirthDate(int birthDate) {
        int count = frequency[birthDate];
        if (count == 1) {
            this.uniqueCount -= 1;
        } else if (count == 2) {
            this.uniqueCount += 1;
        }

        this.frequency[birthDate] -= 1;
    }
}