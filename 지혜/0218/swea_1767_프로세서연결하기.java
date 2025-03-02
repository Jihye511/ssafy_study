package A형기출_0210;
import java.io.*;
import java.util.*;

public class swea_1767_프로세서연결하기 {
    static int N, maxConnected, minWire;
    static int[][] map;
    static List<int[]> processors;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            processors = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && !(i == 0 || j == 0 || i == N - 1 || j == N - 1)) {
                        processors.add(new int[]{i, j});
                    }
                }
            }

            maxConnected = 0;
            minWire = Integer.MAX_VALUE;


            dfs(0, 0, 0);
            System.out.println("#" + t + " " + minWire);
        }
    }

    static void dfs(int index, int connected, int wireLength) {

        if (index == processors.size()) {
            if (connected > maxConnected) {
                maxConnected = connected;
                minWire = wireLength;
            } else if (connected == maxConnected) {
                minWire = Math.min(minWire, wireLength);
            }
            return;
        }

        int[] proc = processors.get(index);
        int x = proc[0], y = proc[1];
        for (int d = 0; d < 4; d++) {
            int nx = x, ny = y;
            List<int[]> path = new ArrayList<>();

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    for (int[] p : path) {
                        map[p[0]][p[1]] = 2; // 전선 깔기
                    }
                    dfs(index + 1, connected + 1, wireLength + path.size());
                    for (int[] p : path) {
                        map[p[0]][p[1]] = 0; // 전선 제거
                    }
                    break;
                }

                if (map[nx][ny] != 0) break;
                path.add(new int[]{nx, ny});
            }
        }

        // 전선 연결하지 않고 다음 진행
        dfs(index + 1, connected, wireLength);
    }
}
