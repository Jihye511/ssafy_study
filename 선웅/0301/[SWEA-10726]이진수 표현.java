import java.util.*;

public class Solution {
    private static int N;
    private static int L;
    private static int max = 0;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N, M;
            N = sc.nextInt();
            M = sc.nextInt();
            int copied = M;
            String onoff = "ON";
            for (int i = 0; i < N; i++) {
                if (((copied >> i) & 1) == 0) {
                    onoff = "OFF";
                    break;
                }
            }

            System.out.printf("#%d %s\n", testCase, onoff);
        }

        sc.close();
    }
}