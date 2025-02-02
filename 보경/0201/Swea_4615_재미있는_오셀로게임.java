import java.util.*;
import java.io.*;

//1. 1과 0만 있는 것이 아님
//2. 흰백 번갈아서 나오는게 아니라 놓을게 없으면 연속으로 같은 돌을 놓을 수 있음 color[i%2] 이렇게 해서 틀렸음
public class Swea_4615_재미있는_오셀로게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[][] board = new int[N+1][N+1];
            //초기화 (1,1)부터 시작
            board[N/2][N/2] = 2;
            board[N/2][N/2+1] = 1;
            board[N/2+1][N/2] = 1;
            board[N/2+1][N/2+1] = 2;

            //흑부터 시작
            //1은 흑 2는 백
            for (int i = 0; i < M; i++) {
                input = br.readLine().split(" ");
                int c = Integer.parseInt(input[0]);
                int r = Integer.parseInt(input[1]);
                int color = Integer.parseInt(input[2]);

                //돌을 놓고
                board[r][c] = color;
                change(board,r,c,color,N);
            }

            int white = 0;
            int black = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (board[i][j] == 1) {
                        black += 1;
                    }
//                    else {
//                        white += 1;
//                    }  //오답이유
                    else if (board[i][j] == 2) {
                        white += 1;
                    }
                }
            }

            System.out.printf("#%d %d %d",t,black,white);
        }
    }

    static void change(int[][] board, int r, int c, int color, int N) {
        int[] dir_r = new int[]{0,0,-1,1,-1,-1,1,1};
        int[] dir_c = new int[]{1,-1,0,0,1,-1,1,-1};

        //팔방탐색하며 색깔 변화
        //리스트에 만나는 다른색깔 다 넣고 같은 색깔 만날 때까지 탐색
        //못 만나고 끝나면 다른 방향 탐색
        //같은 색깔 만나면 스택 다 꺼내면서 색깔 변화 -> 모든 방향 다 봐야됨!
        for (int i = 0; i < 8; i++) {
            ArrayList<int[]> points = new ArrayList<>();

            int nr = r;
            int nc = c;
            while (true) {
                nr += dir_r[i];
                nc += dir_c[i];
                if (!inBoard(nr,nc,N) || board[nr][nc] == 0) {
                    //무효
                    points.clear();
                    break;
                }

                if (board[nr][nc] == color) {
                    break;
                }

                else {  //다른색
                    points.add(new int[]{nr,nc});
                }

            }

            for (int[] p : points) {
                board[p[0]][p[1]] = color;
            }
        }
    }

    static boolean inBoard(int r, int c, int N) {
        if (1<=r && r <= N && 1 <= c && c <= N){
            return true;
        }
        else return false;
    }
}
