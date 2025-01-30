import java.util.*;
import java.io.*;

class swea6730 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr;

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            arr = new int[n];
            int down = 0;
            int up = 0;
            arr[0] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] >= arr[i - 1]) {
                    up = Math.max(arr[i] - arr[i - 1], up);
                } else {
                    down = Math.max(arr[i - 1] - arr[i], down);
                }
            }
            System.out.println("#" + tc + " " + up + " " + down);
        }
    }
}