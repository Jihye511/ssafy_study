package A형기출_0210;
import java.io.*;
import java.util.*;

public class swea_1949_등산로조성 {
    static int N, K, maxDepth, maxHeight;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            maxHeight = 0;
            maxDepth = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        visited = new boolean[N][N];
                        dfs(i, j, map[i][j], 1, false);
                    }
                }
            }

            System.out.println("#" + t + " " + maxDepth);
        }
    }

    public static void dfs(int x, int y, int height, int depth, boolean cutUsed) {
        maxDepth = Math.max(maxDepth, depth);
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

            if (map[nx][ny] < height) { // 그냥 이동 가능
                dfs(nx, ny, map[nx][ny], depth + 1, cutUsed);
            } else if (!cutUsed) {
                for (int k = 1; k <= K; k++) { // K의 깊이만큼 깎아보기
                    if (map[nx][ny] - k < height) {
                        map[nx][ny] -= k; // 깎기
                        dfs(nx, ny, map[nx][ny], depth + 1, true);
                        map[nx][ny] += k;
                    }
                }
            }
        }
        visited[x][y] = false;
    }
}
