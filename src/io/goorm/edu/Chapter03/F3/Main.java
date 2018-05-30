package io.goorm.edu.Chapter03.F3;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] data = new int[N + 1];
        Term[] terms = new Term[M];

        for (int i = 1; i <= N; i++) {
            data[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int l = scanner.nextInt();
            int m = scanner.nextInt();

            terms[i] = new Term(i + 1, l, m);
        }

        getAnswer(data, terms, N, M);
    }

    private static void getAnswer(int[] data, Term[] terms, int N, int M) {
        Term answer = terms[0];

        long[] table = new long[N + 1];
        table[0] = 0;
        for (int i = 1; i <= N; i++) {
            table[i] = table[i - 1] + data[i];
        }

        for (int i = 0; i < M; i++) {
            terms[i].sum = table[terms[i].R] - table[terms[i].L - 1];

            if (answer.sum < terms[i].sum) {
                answer = terms[i];
            }
        }

        System.out.printf("%d %d", answer.index, answer.sum);
    }
}

class Term {
    int L;
    int R;
    int index;
    long sum;

    Term(int index, int l, int r) {
        this.index = index;
        this.L = l;
        this.R = r;
        sum = 0;
    }
}