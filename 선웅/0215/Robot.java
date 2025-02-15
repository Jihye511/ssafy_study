import java.util.Scanner;

public class Robot {
    public static int[][] mountain;
    public static int N;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            mountain = new int[N][N];
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mountain[i][j] = sc.nextInt();
                    board[i][j] = Integer.MAX_VALUE;
                }
            }
            board[0][0] = 0;
            djkstra();
            System.out.println("#" + tc + " " + board[N - 1][N - 1]);
        }
    }

    public static void djkstra() {
        boolean stop = false;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int[][] tempBoard = new int[N][N];

        while (!stop) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tempBoard[i][j] = board[i][j];
                }
            }
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (board[x][y] == Integer.MAX_VALUE) {
                        continue;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = dx[i] + x;
                        int ny = dy[i] + y;
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }
                        int gap = mountain[nx][ny] - mountain[x][y];
                        if (gap > 0) {
                            int before = board[x][y] + 2 * gap;
                            if (before < board[nx][ny]) {
                                board[nx][ny] = before;
                            }
                        } else if (gap == 0) {
                            int before = board[x][y] + 1;
                            if (before < board[nx][ny]) {
                                board[nx][ny] = before;
                            }
                        } else if (gap < 0) {
                            int before = board[x][y];
                            if (before < board[nx][ny]) {
                                board[nx][ny] = before;
                            }
                        }
                    }
                }
            }
            stop = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tempBoard[i][j] != board[i][j]) {
                        stop = false;
                    }
                }
            }

        }
    }
}
