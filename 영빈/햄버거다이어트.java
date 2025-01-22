import java.util.Scanner;

public class swea5215 {

    static int N;
    static int L;
    static int max = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            N = sc.nextInt(); // 재료수
            L = sc.nextInt(); // 제한칼로리
            int[][] fcal = new int[N][2];

            for (int i = 0; i < N; i++) {
                fcal[i][0] = sc.nextInt(); // 맛
                fcal[i][1] = sc.nextInt(); // 칼로리
            }

            recursive(fcal, 0, 0, 0);
        }

        System.out.println(max);
        sc.close();
    }

    public static void recursive(int[][] fcal, int idx, int csum, int ssum) {
        if (idx >= N) {
            return;
        }
        if (csum > L) {
            return;
        }
        if (ssum > max) {
            max = Math.max(max, ssum);
        }

        recursive(fcal, idx + 1, csum + fcal[idx][1], ssum + fcal[idx][0]);
        recursive(fcal, idx + 1, csum, ssum);
    }
}