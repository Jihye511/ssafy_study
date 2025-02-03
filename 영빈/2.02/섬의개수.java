import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4963 {
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static Queue<int[]> q = new LinkedList<>();
    static int w;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0)
                break;
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            int sum = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j, map, visited);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }

    }

    static void bfs(int x, int y, int[][] map, boolean[][] visited) {
        q.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }

        }
    }
}
