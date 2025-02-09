import java.util.*;

public class Main {
    static int[][][] box;
    static boolean[][][] visited;
    static int M, N, H;

    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    static class Node {
        int x, y, z;
        int day;

        Node(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                }
            }
        }

        int day = bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(day);
        sc.close();
    }

    public static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        int day = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        queue.offer(new Node(i, j, k, 0));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            day = n.day;
            for (int i = 0; i < 6; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                int nz = n.z + dz[i];
                if (nx < 0 || nx >= H || ny < 0 || ny >= N || nz < 0 || nz >= M || box[nx][ny][nz] != 0
                        || visited[nx][ny][nz]) {
                    continue;

                }
                queue.offer(new Node(nx, ny, nz, n.day + 1));
                visited[nx][ny][nz] = true;
                box[nx][ny][nz] = 1;
            }
        }

        return day;
    }
}