package io.goorm.edu.Chapter02.F2;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        Planet[] planets = new Planet[n];

        for (int i = 0; i < n; i++) {
            int dx = scanner.nextInt();
            int dy = scanner.nextInt();
            Planet planet = new Planet(dx, dy);

            planets[i] = planet;
        }

        int minDist = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dist = planets[i].getDistance(planets[j]);
                if (dist < minDist) {
                    minDist = dist;
                    count = 1;
                } else if (dist == minDist) count++;
            }
        }

        double finalDist = Math.sqrt(minDist);
        System.out.printf("%.1f\n", finalDist);
        System.out.printf("%d", count);
    }
}

class Planet {
    int x;
    int y;

    public Planet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Planet planet) {
        int dx = Math.abs(planet.x - this.x);
        int dy = Math.abs(planet.y - this.y);

        return dx * dx + dy * dy;
    }
}