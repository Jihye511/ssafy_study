import java.util.*;
import java.io.*;

public class Boj_1012_유기농배추 {
    static int N;
    static int M;
    static int result;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = true;
            }

            bfs();
            System.out.println(result);
        }
    }

    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[] dr = new int[] {-1,1,0,0};
        int[] dc = new int[] {0,0,-1,1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] && !visited[i][j]) {
                    visited[i][j] = true;
                    dq.add(new int[] {i,j});
                    result++;
                    while (!dq.isEmpty()) {
                        int[] curr = dq.pollFirst();
                        int r = curr[0];
                        int c = curr[1];
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (inRange(nr,nc) && map[nr][nc] && !visited[nr][nc]) {
                                dq.add(new int[]{nr,nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }

            }
        }
    }

    static boolean inRange(int r, int c) {
        return 0<=r && r < N && 0 <= c && c < M;
    }
}
