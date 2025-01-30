import java.util.Scanner;

class swea4615 {// 오셀로
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        // 상,하,좌,우,좌상,좌하,우위,우하
        int[] dirX = { -1, 1, 0, 0, -1, 1, -1, 1 };
        int[] dirY = { 0, 0, -1, 1, -1, -1, 1, 1 };
        int[][] board;
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int black = 0;
            int white = 0;
            board = new int[n + 1][n + 1];
            board[n / 2][n / 2] = 2;
            board[n / 2 + 1][n / 2 + 1] = 2;
            board[n / 2 + 1][n / 2] = 1;
            board[n / 2][n / 2 + 1] = 1;

            while (m-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();
                board[x][y] = color;

                for (int d = 0; d < 8; d++) { // 8방탐색
                    int nx = x + dirX[d];
                    int ny = y + dirY[d];
                    while (nx >= 1 && nx <= n && ny >= 1 && ny <= n) { // 범위안에있는동안
                        if (board[nx][ny] == 0) {
                            break;
                        } else if (board[nx][ny] == color) {
                            int i = x;
                            int j = y;
                            while (!(i == nx && j == ny)) {
                                board[i][j] = color;
                                i += dirX[d];
                                j += dirY[d];
                            }
                            break;
                        }
                        nx += dirX[d];
                        ny += dirY[d];
                    }
                }
            }
            for (int[] line : board) {
                for (int color : line) {
                    if (color == 1)
                        black++;
                    else if (color == 2)
                        white++;
                }
            }
            System.out.println("#" + tc + " " + black + " " + white);
        }
    }
}