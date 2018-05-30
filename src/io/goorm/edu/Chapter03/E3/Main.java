package io.goorm.edu.Chapter03.E3;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int c = scanner.nextInt();

        for (int j = 0; j < c; j++) {
            int n = scanner.nextInt();
            Paper[] papers = new Paper[n];
            int xPos;
            int yPos;

            for (int i = 0; i < n; i++) {
                xPos = scanner.nextInt();
                yPos = scanner.nextInt();
                papers[i] = new Paper(xPos, yPos);
            }

            int result = getArea(papers);

            System.out.println(result);
        }
    }

    private static int getArea(Paper[] papers) {
        int result = 0;
        int[][] table = new int[100][100];

        for (Paper p : papers) {
            for (int i = p.left; i <= p.right; i++) {
                for (int j = p.bottom; j <= p.top; j++) {
                    table[i][j] += 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (table[i][j] > 0) result++;
            }
        }

        return result;
    }
}

class Paper {
    int left;
    int right;
    int top;
    int bottom;

    Paper (int xPos, int yPox) {
        this.left = xPos;
        this.right = xPos + 9;
        this.bottom = yPox;
        this.top = yPox + 9;
    }
}