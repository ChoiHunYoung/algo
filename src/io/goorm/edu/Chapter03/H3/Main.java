package io.goorm.edu.Chapter03.H3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_CARDS = 100000;

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] cards = new int[N];
        int[] lotNumber = new int[M];

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            lotNumber[i] = scanner.nextInt();
        }

        int answer = getPossibleCount(N, M, cards, lotNumber);

        System.out.printf("%d", answer);
    }

    private static int getPossibleCount(int n, int m, int[] cards, int[] lotNumber) {
        int answer = 0;

        Arrays.sort(cards);

        for (int l : lotNumber) {
            boolean possible = false;

            for (int c : cards) {
                int a = l - c;

                if (Arrays.binarySearch(cards, a) >= 0) {
                    possible = true;
                    break;
                }
            }

            if (possible) answer++;
        }

        return answer;
    }
}
