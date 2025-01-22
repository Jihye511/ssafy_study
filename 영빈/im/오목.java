import java.util.Scanner;

public class boj2615 {
    static int[][] map = new int[19][19];
    static boolean visited[][] = new boolean[19][19];
    static int[] nr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] nc = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int res = 0;
    static int last_x = 0;
    static int last_y = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();

        // n * n 크기 배열 선언 ( 지도 )

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if (map[i][j] == 1) {
                    search(1, i, j, 1);
                }
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if (map[i][j] == 2) {
                    search(2, i, j, 1);
                }
            }
        }

        // 최대값 저장

        if (res != 0) {
            System.out.printf("%d\n%d %d", res, last_x, last_y);
        } else {
            System.out.println(res);
        }

    }

    public static void search(int go, int x, int y, int o) {
        if (res == go) {
            if (o == 1) {
                last_x = x;
                last_y = y;
            }
            return;
        }

        for (int d = 0; d < 8; d++) // 8방 탐색
        {
            int next_x = x + nr[d];
            int next_y = y + nc[d];
            if (next_x >= 0 && next_x < 19 && next_y >= 0 && next_y < 19 &&
                    map[next_x][next_y] == go && !visited[next_x][next_y]) {
                visited[x][y] = true;
                dfso(go, next_x, next_y, d, o + 1);
                visited[x][y] = false;
            } else {
                return;
            }
        }
    }

    public static void dfso(int go, int x, int y, int d, int o) {
        int next_x = x + nr[d];
        int next_y = y + nc[d];
        if (o == 5) {
            if (next_x >= 0 && next_x < 19 && next_y >= 0 && next_y < 19 &&
                    map[next_x][next_y] == go) // 6개 연속이라면
            {
                return;
            } else {
                res = go;
            }
        }

        if (next_x >= 0 && next_x < 19 && next_y >= 0 && next_y < 19 &&
                map[next_x][next_y] == go) {
            visited[x][y] = true;
            dfso(go, next_x, next_y, d, o + 1);
            visited[x][y] = false;
        }

        return;

    }
}
