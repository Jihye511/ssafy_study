import java.util.*;

public class Main {
    static int[][] map;
    static int[][][] mem;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        mem = new int[N + 1][N + 1][4];
        mem[1][2][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dp();
        System.out.println(mem[N][N][1] + mem[N][N][2] + mem[N][N][3]);
        sc.close();
    }

    public static void dp() {
        mem[1][2][1] = 1;
        for (int x = 1; x <= N; x++) {
            for (int y = 2; y <= N; y++) {
                // 가로
                int x1 = x;
                int y1 = y + 1;
                // 세로
                int x2 = x + 1;
                int y2 = y;
                // 대각선
                int x3 = x + 1;
                int y3 = y + 1;
                // 가로로 간 후
                if (x1 >= 1 && x1 <= N && y1 >= 1 && y1 <= N && map[x1][y1] == 0) {
                    mem[x1][y1][1] += mem[x][y][1] + mem[x][y][3];
                }
                // 세로로 간 후
                if (x2 >= 1 && x2 <= N && y2 >= 1 && y2 <= N && map[x2][y2] == 0) {
                    mem[x2][y2][2] += mem[x][y][2] + mem[x][y][3];
                }
                // 대각선으로 간 후
                if (x3 >= 1 && x3 <= N && y3 >= 1 && y3 <= N && map[x1][y1] + map[x2][y2] + map[x3][y3] == 0) {
                    mem[x3][y3][3] += mem[x][y][1] + mem[x][y][2] + mem[x][y][3];
                }
            }
        }
    }
}