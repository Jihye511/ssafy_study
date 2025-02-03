import java.awt.Point;
import java.util.*;
import java.io.*;

//리트라이...

public class Swea_4193_수영대회_결승전 {
    static int result ;
    static int MAX_VALUE = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] start = new int[2];
            String[] input = br.readLine().split(" ");
            start[0] = Integer.parseInt(input[0]);
            start[1] = Integer.parseInt(input[1]);

            int[] end = new int[2];
            input = br.readLine().split(" ");
            end[0] = Integer.parseInt(input[0]);
            end[1] = Integer.parseInt(input[1]);

            //dfs...
            result = MAX_VALUE;
            dfs(start[0],start[1],0,end);
            if (result == MAX_VALUE) {
                result = -1;
            }
            System.out.printf("#%d %d\n",t,result);
        }
    }

    static void dfs(int r, int c, int time, int[] end) {
        if (r == end[0] && c == end[1]) {
            result = Math.min(result, time);
            return;
        }

        if (result <= time) {
            return; //프루닝
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        visited[r][c] = true; //방문체크
        for (int i = 0; i < 4; i++) {
            int plus = 1;

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc,N) && !visited[nr][nc] && map[nr][nc] != 1) {
                if (map[nr][nc] == 2) {
                    //소용돌이
                    //0초 -> 3, 1초 -> 2 2초 ->3
                    plus = 3 - time % 3;
                }
                dfs(nr,nc,time + plus, end);

            }
        }
        visited[r][c] = false;

        //백트래킹
    }

    static boolean inRange(int r, int c, int N) {
        return 0<= r && r < N && 0 <= c && c < N;
    }
}
