import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class Apple {
    public static int N;
    public static int[][] map;
    public static int[][] apple;
    public static int count;

    public static class Data {
        int curDir;
        int rotations;

        Data(int curDir, int rotations) {
            this.curDir = curDir;
            this.rotations = rotations;
        }
    }

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int ans = 0;
            min = Integer.MAX_VALUE;
            N = sc.nextInt();
            map = new int[N][N];
            count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int input = sc.nextInt();
                    if (input > count) {
                        count = input;
                    }
                    map[r][c] = input;
                }
            }

            apple = new int[count + 1][];
            // 출발점
            apple[0] = new int[] { 0, 0 };
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] > 0) {
                        apple[map[r][c]] = new int[] { r, c };
                    }
                }
            }
            dfs(0, 0, 0);
            ans = min;
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }

    public static void dfs(int i, int curDir, int result) {
        if (i == count) {
            min = Math.min(min, result);
            return;
        }

        int r1 = apple[i][0];
        int c1 = apple[i][1];
        int r2 = apple[i + 1][0];
        int c2 = apple[i + 1][1];
        if (r1 == r2 || c1 == c2) {
            Data data = findRotation2(curDir, r1, c1, r2, c2);
            dfs(i + 1, data.curDir, result + data.rotations);
        } else {
            Data[] data = findRotation1(curDir, r1, c1, r2, c2);

            dfs(i + 1, data[0].curDir, result + data[0].rotations);
            dfs(i + 1, data[1].curDir, result + data[1].rotations);
        }
    }

    public static Data findRotation2(int curDir, int r1, int c1, int r2, int c2) {
        Data ret = null;
        int count, dir;
        if (c2 > c1) {
            count = countRotation(curDir, 0);
            dir = 0;
            ret = new Data(dir, count);
        } else if (r2 > r1) {
            count = countRotation(curDir, 1);
            dir = 1;
            ret = new Data(dir, count);
        } else if (c2 < c1) {
            count = countRotation(curDir, 2);
            dir = 2;
            ret = new Data(dir, count);
        } else if (r2 < r1) {
            count = countRotation(curDir, 3);
            dir = 3;
            ret = new Data(dir, count);
        }
        return ret;
    }

    public static Data[] findRotation1(int curDir, int r1, int c1, int r2, int c2) {
        Data[] ret = new Data[2];
        int count, dir;
        if (r2 > r1 && c2 > c1) {
            count = countRotation(curDir, 0) + countRotation(0, 1);
            dir = 1;
            ret[0] = new Data(dir, count);
            count = countRotation(curDir, 1) + countRotation(1, 0);
            dir = 0;
            ret[1] = new Data(dir, count);
        } else if (r2 > r1 && c2 < c1) {
            count = countRotation(curDir, 1) + countRotation(1, 2);
            dir = 2;
            ret[0] = new Data(dir, count);
            count = countRotation(curDir, 2) + countRotation(2, 1);
            dir = 1;
            ret[1] = new Data(dir, count);
        } else if (r2 < r1 && c2 < c1) {
            count = countRotation(curDir, 2) + countRotation(2, 3);
            dir = 3;
            ret[0] = new Data(dir, count);
            count = countRotation(curDir, 3) + countRotation(3, 2);
            dir = 2;
            ret[1] = new Data(dir, count);
        } else if (r2 < r1 && c2 > c1) {
            count = countRotation(curDir, 3) + countRotation(3, 0);
            dir = 0;
            ret[0] = new Data(dir, count);
            count = countRotation(curDir, 0) + countRotation(0, 3);
            dir = 3;
            ret[1] = new Data(dir, count);
        }
        return ret;
    }

    public static int countRotation(int curDir, int tarDir) {
        if (curDir < tarDir) {
            return tarDir - curDir;
        } else if (curDir > tarDir) {
            return 4 - (curDir - tarDir);
        } else {
            return 0;
        }
    }
}