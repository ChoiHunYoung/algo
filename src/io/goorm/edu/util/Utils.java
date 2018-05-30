package io.goorm.edu.util;

public class Utils {

    /**
     * data[0] ~ data[n-1] 에서 value를 찾아서 그 인덱스를 반환하는 함수
     * 존재하지 않으면 - 음수
     *
     * @param data
     * @param n
     * @param value
     * @return
     */
    public static int binarySearch (int[] data, int n, int value) {
        int L = 0;
        int R = n - 1;
        // [L, R] 범위 사이에 정답이 존재한다
        // ( L == R )
        while (L < R) {
            int M = (L + R) / 2;
            int y = data[M];    // 중간 테스트 지점 M에 대한 함수값
            if (y == value) {
                //data[M] == value
                return M;
            } else if (y < value) {
                L = M + 1;
            } else if (y > value) {
                R = M - 1;
            }
        }

        // (L == R)
        if (data[L] == value) return L;

        return -1;
    }

    /**
     * data[0] ~ data[n-1] 에서 value를 찾아서 그 인덱스를 반환하는 함수
     * 존재하지 않으면 - 음수
     * 가장 왼쪽 인덱스 찾기
     *
     * @param data
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchFirstIndex (int[] data, int n, int value) {
        int L = 0;
        int R = n - 1;
        // [L, R] 범위 사이에 정답이 존재한다
        // ( L == R )
        while (L < R) {
            int M = (L + R) / 2;
            int y = data[M];    // 중간 테스트 지점 M에 대한 함수값
            if (y < value) {
                L = M + 1;
            } else if (y >= value) {
                R = M;
            }
        }

        // (L == R)
        if (data[L] == value) return L;

        return -1;
    }

    /**
     * data[0] ~ data[n-1] 에서 value를 찾아서 그 인덱스를 반환하는 함수
     * 존재하지 않으면 - 음수
     * 가장 오른쪽 인덱스 찾기
     *
     * @param data
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchListIndex (int[] data, int n, int value) {
        int L = 0;
        int R = n - 1;
        // [L, R] 범위 사이에 정답이 존재한다
        // ( L == R )
        while (L < R) {
            int M = (L + R + 1) / 2;
            int y = data[M];    // 중간 테스트 지점 M에 대한 함수값
            if (y <= value) {
                L = M;
            } else if (y > value) {
                R = M - 1;
            }
        }

        // (L == R)
        if (data[L] == value) return L;

        return -1;
    }
}
