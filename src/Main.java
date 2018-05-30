import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final int MAX_N = 1000;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        printIndexes(new String[]{"10", "abc", "def", "AJOU", "sdlf", "jskdh", "AJOU"}, 7);
//        get_gcd(10, 15);
//
//        int n;
//        int[] data = new int[MAX_N];
//        //
//        for (int i = data.length - 1; i > 0; i--) {
//            n = scanner.nextInt();
//            data[i] = n;
//        }
//
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i]);
//            if (i != data.length - 1) System.out.print(" ");
//        }

//        getMaxRev(new int[]{10300, 9600, 9800, 8200, 7800, 8300, 9500, 9800, 10200, 9500}, 10);
//        getMaxRev(new int[]{10, 15, 30, 40, 5}, 5);

//        MyString m1 = new MyString("algorithm");
//        MyString m1 = new MyString("allergy");
////        MyString m2 = new MyString("allergy");
//        MyString m2 = new MyString("algorithm");
//
//        int result = m1.compareTo(m2);
//
//        if (result < 0) System.out.println("-1");
//        else if (result > 0) System.out.println("1");
//        else System.out.println("0");

        Arrays.sort(new int[10]);

        String[] a = {"a", "z", "d", "j", "k", "q", "w", "c", "p", "u", "v", "s", "b", "y", "h", "i", "x", "m", "f", "n"};

        Arrays.sort(a);
    }

    public static void getMaxRev(int[] data, int n) {
        int rev = 0;
        int min = data[0];

        for (int i = 1; i < n; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (data[i] - min > rev) {
                rev = data[i] - min;
            }
        }

        System.out.println(rev);
    }

    /**
     * Problem 01B. 배열의 최대값
     * @param data
     * @param n
     * @return
     */
    public static int getMax(int[] data, int n) {
        int a = data[0];

        for (int i = 1; i < n; i++) {
            if (a < data[i]) a = data[i];
        }

        return a;
    }

    public static void printIndexes(String[] school, int n)
    {
        int first = -1; //존재하지 않으면 -1
        int last = -1;  //존재하지 않으면 -1

        for (int i = 0; i < n; i++) {
            if (school[i].equals("AJOU")) {
                if (first == -1) first = i;

                last = i;
            }
        }

        System.out.printf("%d %d\n", first, last );
    }

    public static void get_gcd(int a, int b) {
        int p = a;
        int q = b;
        int r = p % q;
        System.out.println(r);

        while (r != 0) {
            p = q;
            q = r;
            r = p % q;
            System.out.println("while :: " + p + " " + q + " " + r);
        }

        System.out.println(q);
    }
}

class MyString implements Comparable<MyString> {
    private char[] characters;

    public MyString(String original) {
        characters = original.toCharArray();
    }

    public MyString(char[] original) {
        characters = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            characters[i] = original[i];
        }
    }

    @Override
    public int compareTo(MyString o) {
        int n = Math.min(this.characters.length, o.characters.length);

        for (int i = 0; i < n; i++) {
            if (this.characters[i] > o.characters[i]) return 1;
            else if (this.characters[i] < o.characters[i]) return -1;
        }

        return this.characters.length - o.characters.length;
    }
}