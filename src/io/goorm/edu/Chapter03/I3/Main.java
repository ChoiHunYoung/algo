package io.goorm.edu.Chapter03.I3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

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

        ArrayList<Integer> answer = getPossibleNumberList(N, M, cards, lotNumber);

        if (answer == null || answer.size() < 1) System.out.println("NO");
        else {
            for (int i = 0; i < answer.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.printf("%d", answer.get(i));
            }
        }
    }

    private static ArrayList<Integer> getPossibleNumberList(int n, int m, int[] cards, int[] lotNumber) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(cards);

        for (int l : lotNumber) {
            boolean possible = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    int a = l - (cards[i] + cards[j]);
                    if (Arrays.binarySearch(cards, a) >= 0) {
                        possible = true;
                        break;
                    }
                }
                if (possible) break;
            }
            if (possible) answer.add(l);
        }

        Collections.sort(answer);
        return answer;
    }
}
