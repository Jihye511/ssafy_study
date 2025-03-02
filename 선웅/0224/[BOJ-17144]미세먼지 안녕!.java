import java.util.*;

// 졸려...

public class Main {
    static int R, C, T;
    static int[][][] room;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] airCleaner = new int[2][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        room = new int[R][C][2];
        int order = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int num = sc.nextInt();
                if (num == -1) {
                    airCleaner[order] = new int[] { i, j };
                    order++;
                }
                room[i][j][0] = num;
            }
        }
        for (int turn = 0; turn < T; turn++) {
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    int num = room[x][y][0];
                    int plus = num / 5;
                    if(room[x][y][0] == 0){
                        continue;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C || room[nx][ny][0] == -1) {
                            continue;
                        }
                        room[nx][ny][1] += plus;
                        num -= plus;
                    }
                    room[x][y][0] = num;
                }
            }
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    room[x][y][0] += room[x][y][1];
                }
            }

            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    room[x][y][1] = 0;
                }
            }

            for (int x = airCleaner[0][0] - 2; x >= 0; x--) {
                room[x + 1][0][0] = room[x][0][0];
            }
            for (int y = 1; y < C; y++) {
                room[0][y - 1][0] = room[0][y][0];
            }
            for (int x = 1; x <= airCleaner[0][0]; x++) {
                room[x - 1][C - 1][0] = room[x][C - 1][0];
            }
            for (int y = C - 2; y >= 1; y--) {
                room[airCleaner[0][0]][y + 1][0] = room[airCleaner[0][0]][y][0];
            }
            room[airCleaner[0][0]][1][0] = 0;

            for (int x = airCleaner[1][0] + 2; x <= R - 1; x++) {
                room[x - 1][0][0] = room[x][0][0];
            }
            for (int y = 1; y <= C - 1; y++) {
                room[R - 1][y - 1][0] = room[R - 1][y][0];
            }
            for (int x = R - 2; x >= airCleaner[1][0]; x--) {
                room[x + 1][C - 1][0] = room[x][C - 1][0];
            }
            for (int y = C - 2; y >= 1; y--) {
                room[airCleaner[1][0]][y + 1][0] = room[airCleaner[1][0]][y][0];
            }
            room[airCleaner[1][0]][1][0] = 0;

        }
        int sum =0;
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                sum += room[x][y][0];
            }
        }
        sum += 2;
        System.out.println(sum);
        sc.close();
    }
}