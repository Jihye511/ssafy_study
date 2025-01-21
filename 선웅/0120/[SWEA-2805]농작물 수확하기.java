import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            int N = sc.nextInt(); 
            int[][] farm = new int[N][N];

            // 농장 만들기
            for(int i = 0; i < N; i++){
                String line = sc.next();
                for(int j = 0; j < N; j++){
                    farm[i][j] = line.charAt(j) - '0';
                }
            }

            int mid = N / 2;   // 가운데 행
            int total = 0;

            // 수확(모두 더하기)
            for(int i = 0; i < N; i++){
                // 가운데 행과의 거리
                int distance = Math.abs(mid - i);
                // 가운데 열과의 거리
                int colDistance = mid - distance;
                // 이 행에서 더해야 할 열 범위
                int startCol = mid - colDistance;
                int endCol   = mid + colDistance;

                for(int j = startCol; j <= endCol; j++){
                    total += farm[i][j];
                }
            }

            // 결과 출력
            System.out.printf("#%d %d\n", t, total);
        }

        sc.close();
    }
}
