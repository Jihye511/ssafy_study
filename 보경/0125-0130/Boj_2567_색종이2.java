import java.util.Scanner;

public class Boj_2567_색종이2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] paper = new int[101][101];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();  //x좌표
            int y = sc.nextInt();  //y좌표

            for (int j = x; j < x + 10; j++) {   //행
                for (int k = y; k < y + 10; k++) {  //열
                    paper[j][k] = 1;
                }
            }
        }
        int res = 0;
        int[] dr = new int[]{0,0,-1,1};
        int[] dc = new int[]{-1,1,0,0};

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (paper[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < 101 && nc >= 0 && nc < 101) {
                            if (paper[nr][nc] == 0) {
                                res += 1;
                            }
                        }

                        //가장 끝에 위치
                        if (nr < 0 || nr > 100 || nc < 0 || nc > 100) {
                            res += 1;
                        }

                    }
                }
            }
        }
        System.out.println(res);
    }
}
