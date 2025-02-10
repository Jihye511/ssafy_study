import java.util.*;
import java.io.*;

public class Boj_17070_파이프_옮기기1 {
    static int N;
    static int[][] map;
    static int result;  //방법의 수
    static class Point {
        int r;
        int c;
        char dir;  //S : 가로, V : 세로, D : 대각선

        public Point (int r, int c, char dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws Exception {
        //경로 -> dfs
        //빈칸 : 0 벽 :1
        //가로 세로 대각선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        dfs(new Point(0,1,'S'));
        System.out.println(result);

    }

    static void dfs(Point t) {
        //탐색 끝 백트래킹
        //도착점 도착
        if (t.r == N-1 && t.c == N-1) {
            result += 1;
            return;
        }

        if (t.dir == 'S') {
            //가로 -> 가로, 대각선
            int nr = t.r;
            int nc = t.c + 1;
            if (isSValid(nr,nc)) {
                dfs(new Point(nr,nc,'S'));
            }

            //대각선
            nr = t.r + 1;
            nc = t.c + 1;
            if (isDValid(nr,nc)) {
                dfs(new Point(nr,nc,'D'));
            }
        }

        if (t.dir == 'V') {
            //세로 -> 세로, 대각선
            int nr = t.r + 1;
            int nc = t.c;

            if (isVValid(nr,nc)) {
                dfs(new Point(nr,nc,'V'));
            }

            nr = t.r + 1;
            nc = t.c + 1;
            if (isDValid(nr,nc)) {
                dfs(new Point(nr,nc,'D'));
            }
        }

        if (t.dir == 'D') {
            //대각선 -> 가로, 세로, 대각선
            int nr = t.r;
            int nc = t.c + 1;
            if (isSValid(nr,nc)) {
                dfs(new Point(nr,nc,'S'));
            }
            nr = t.r + 1;
            nc = t.c;

            if (isVValid(nr,nc)) {
                dfs(new Point(nr,nc,'V'));
            }

            nr = t.r + 1;
            nc = t.c + 1;
            if (isDValid(nr,nc)) {
                dfs(new Point(nr, nc, 'D'));
            }
        }
    }

    static boolean isSValid(int r, int c) {
        return c < N && map[r][c] == 0;
    }

    static boolean isVValid(int r, int c) {
        return r < N && map[r][c] == 0;
    }

    static boolean isDValid(int r, int c) {
        return r < N && c < N && map[r][c] == 0 && map[r][c] == 0 && map[r-1][c] == 0 && map[r][c-1] == 0;
    }
}
