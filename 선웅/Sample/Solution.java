import java.util.*;

public class Solution {
    private static int N;
    private static int L;
    private static int max = 0;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        // test case만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            max = 0;
            N = sc.nextInt();
            L = sc.nextInt();
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            search(arr, 0, 0, 0);
            System.out.println("#" + test_case + " " + max);
        }
        sc.close();
    }

    private static void search(int[][] arr, int score, int calories, int idx) {
        if (calories > L)
            return;
        if (score > max)
            max = score;
        if (idx >= N)
            return;
        search(arr, score + arr[idx][0], calories + arr[idx][1], idx + 1);
        search(arr, score, calories, idx + 1);
    }
}