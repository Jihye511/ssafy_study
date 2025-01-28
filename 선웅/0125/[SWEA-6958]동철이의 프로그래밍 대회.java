import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 수 T 입력
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            // 각 테스트 케이스의 N, M 입력
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] scores = new int[N][M];
            int[] totalSolved = new int[N];

            // 각 사람의 문제 풀이 여부 입력 및 푼 문제 수 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    scores[i][j] = sc.nextInt();
                    totalSolved[i] += scores[i][j];
                }
            }

            // 1등이 푼 문제의 수 구하기
            int maxSolved = 0;
            for (int solved : totalSolved) {
                if (solved > maxSolved) {
                    maxSolved = solved;
                }
            }

            // 1등한 사람의 수 구하기
            int firstPlaceCount = 0;
            for (int solved : totalSolved) {
                if (solved == maxSolved) {
                    firstPlaceCount++;
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + firstPlaceCount + " " + maxSolved);
        }

        sc.close();
    }
}
