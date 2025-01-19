
import java.util.Scanner;

public class boj17136 {
    static int[] paper = { 0, 5, 5, 5, 5, 5 };
    static int count = Integer.MAX_VALUE;
    static int[][] map = new int[10][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0);

        if (count == Integer.MAX_VALUE) {
            count = -1;
        }

        System.out.println(count);
        sc.close();

    }

    public static void dfs(int x, int y, int cnt) {

        if (x >= 9 && y > 9) // 다 돌면 끝
        {
            count = Math.min(count, cnt);
            return;
        }

        if (count <= cnt) { // backtraking 조건
            return;
        }

        if (y > 9) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    attach(x, y, i, 0); // 붙임
                    paper[i]--;
                    dfs(x, y + 1, cnt + 1);
                    attach(x, y, i, 1); // 땜
                    paper[i]++;
                }
            }
        } else {
            dfs(x, y + 1, cnt);
        }

    }

    public static void attach(int x, int y, int s, int state) { // 0 = 땜, 1 = 붙임
        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                map[i][j] = state;
            }
        }
    }

    public static boolean isAttach(int x, int y, int s) {
        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
