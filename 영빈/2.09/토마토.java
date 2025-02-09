
package boj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

    static class Tomato {
        int x, y, z, day;

        Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    static int[][][] map;
    static int M, N, H;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로
        H = sc.nextInt(); // 높이

        map = new int[H][N][M];
        boolean allRipe = true;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    map[z][y][x] = sc.nextInt();
                    if (map[z][y][x] == 1) {
                        queue.add(new Tomato(x, y, z, 0));
                    }
                    if (map[z][y][x] == 0) {
                        allRipe = false;
                    }
                }
            }
        }

        if (allRipe) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
        sc.close();
    }

    private static int bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            day = current.day;

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (map[nz][ny][nx] == 0) {
                        map[nz][ny][nx] = 1;
                        queue.add(new Tomato(nx, ny, nz, current.day + 1));
                    }
                }
            }
        }

        return check() ? day : -1;
    }

    private static boolean check() {
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[z][y][x] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
