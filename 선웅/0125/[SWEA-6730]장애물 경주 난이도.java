import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // Number of test cases

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // Number of blocks
            int[] heights = new int[N];

            for (int i = 0; i < N; i++) {
                heights[i] = sc.nextInt();
            }

            int maxUp = 0;
            int maxDown = 0;

            for (int i = 0; i < N - 1; i++) {
                int diff = heights[i + 1] - heights[i];
                if (diff > 0) {
                    maxUp = Math.max(maxUp, diff);
                } else {
                    maxDown = Math.max(maxDown, -diff);
                }
            }

            System.out.printf("#%d %d %d\n", t, maxUp, maxDown);
        }

        sc.close();
    }
}
