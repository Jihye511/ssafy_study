import java.util.Scanner;

public class Swea_6958_동철이의_프로그래밍_대회 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] problem = new int[n][m];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    problem[i][j] = sc.nextInt();
                }
            }

            int firstCount = 0;
            int solvedProblem = 0;

            for(int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    count += problem[i][j];
                }

                if (count > solvedProblem) {
                    firstCount = 1;
                    solvedProblem = count;
                }
                else if (count == solvedProblem) {
                    firstCount += 1;
                }
            }

            System.out.printf("#%d %d %d\n", t+1, firstCount, solvedProblem);
        }


        sc.close();
    }
}
