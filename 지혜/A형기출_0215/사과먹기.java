package A형기출_0210;

import java.io.*;
import java.util.*;

public class 사과먹기 {
    static int[] dx = {0, 1, 0, -1}; // 오 아래 왼 위
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int[][] map;
    static int maxApple;

    static class State {
        int x, y, dir, apple, turnCnt;

        public State(int x, int y, int dir, int apple, int turnCnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.apple = apple;
            this.turnCnt = turnCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            maxApple = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxApple = Math.max(map[i][j], maxApple);
                }
            }

            int result = bfs();
            System.out.println("#" + t + " " + result);
        }
    }

    public static int bfs() {
        Queue<State> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][N][4][maxApple + 2];
        queue.add(new State(0, 0, 0, 1, 0));
        visited[0][0][0][1] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int x = cur.x, y = cur.y, dir = cur.dir, apple = cur.apple, turnCnt = cur.turnCnt;

            if (apple > maxApple) return turnCnt;

            if (map[x][y] == apple) apple++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny][dir][apple]) {
                visited[nx][ny][dir][apple] = true;
                queue.add(new State(nx, ny, dir, apple, turnCnt));
            }


            int ndir = (dir + 1) % 4;
            int tx = x + dx[ndir];
            int ty = y + dy[ndir];

            if (tx >= 0 && tx < N && ty >= 0 && ty < N && !visited[x][y][ndir][apple]) {
                visited[x][y][ndir][apple] = true;
                queue.add(new State(x, y, ndir, apple, turnCnt + 1)); // 회전 추가
            }
        }

        return -1;
    }
}
