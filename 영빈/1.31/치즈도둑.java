import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea7733 {
    static int[] rd = { -1, 0, 1, 0 };
    static int[] cd = { 0, 1, 0, -1 };
    static int[][] map;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            map = new int[N][N];
            int max_n = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 100; i++) {
                boolean[][] visited = new boolean[N][N];

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (map[x][y] == i) {
                            map[x][y] = 0;
                        }
                    }
                }
                max_n = piece(visited, max_n);
            }

            System.out.printf("#%d %d\n", t + 1, max_n);
        }
    }

    static int piece(boolean[][] visited, int max_n) {
        int num = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] != 0 && visited[x][y] != true) {
                    bfs(x, y, visited);
                    num++;
                }
            }
        }
        max_n = Math.max(max_n, num);
        return max_n;
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + rd[i];
                int ny = now[1] + cd[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }

}
