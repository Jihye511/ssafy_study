package boj;

import java.util.*;

public class 배열돌리기3 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[] operations = new int[R];
        for (int i = 0; i < R; i++) {
            operations[i] = sc.nextInt();
        }
        
        for (int op : operations) {
            applyOperation(op);
        }
        
        printArray();
    }

    static void applyOperation(int op) {
        switch (op) {
            case 1: reverseUpDown(); break;
            case 2: reverseLeftRight(); break;
            case 3: rotateRight(); break;
            case 4: rotateLeft(); break;
            case 5: moveClockwise(); break;
            case 6: moveCounterClockwise(); break;
        }
    }

    static void reverseUpDown() {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = arr[i];
            arr[i] = arr[N - 1 - i];
            arr[N - 1 - i] = temp;
        }
    }

    static void reverseLeftRight() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M - 1 - j];
                arr[i][M - 1 - j] = temp;
            }
        }
    }

    static void rotateRight() {
        int[][] newArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[j][N - 1 - i] = arr[i][j];
            }
        }
        arr = newArr;
        int temp = N;
        N = M;
        M = temp;
    }

    static void rotateLeft() {
        int[][] newArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[M - 1 - j][i] = arr[i][j];
            }
        }
        arr = newArr;
        int temp = N;
        N = M;
        M = temp;
    }

    static void moveClockwise() {
        int[][] newArr = new int[N][M];
        int nHalf = N / 2, mHalf = M / 2;
        
        for (int i = 0; i < nHalf; i++) {
            for (int j = 0; j < mHalf; j++) {
                newArr[i][j + mHalf] = arr[i][j];
                newArr[i + nHalf][j + mHalf] = arr[i][j + mHalf];
                newArr[i + nHalf][j] = arr[i + nHalf][j + mHalf];
                newArr[i][j] = arr[i + nHalf][j];
            }
        }
        arr = newArr;
    }

    static void moveCounterClockwise() {
        int[][] newArr = new int[N][M];
        int nHalf = N / 2, mHalf = M / 2;
        
        for (int i = 0; i < nHalf; i++) {
            for (int j = 0; j < mHalf; j++) {
                newArr[i + nHalf][j] = arr[i][j];
                newArr[i][j] = arr[i][j + mHalf];
                newArr[i][j + mHalf] = arr[i + nHalf][j + mHalf];
                newArr[i + nHalf][j + mHalf] = arr[i + nHalf][j];
            }
        }
        arr = newArr;
    }

    static void printArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
