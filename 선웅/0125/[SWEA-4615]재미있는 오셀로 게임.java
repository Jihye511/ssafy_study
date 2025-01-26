import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        // test case만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] board = new int[N][N];

            // initialize board(0 means empty)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = 0;
                }
            }
            board[N/2-1][N/2-1] = 2;
            board[N/2][N/2-1] = 1;
            board[N/2-1][N/2] = 1;
            board[N/2][N/2] = 2;

            // move pieces on the board (m times)
            for (int i = 1; i <= M; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                int color = sc.nextInt();
                place(board, col - 1, row - 1, color, N);
            }
            int black = 0, white = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        black++;
                    } else if (board[i][j] == 2) {
                        white++;
                    }
                }
            }
            System.out.printf("#%d %d %d\n", test_case, black, white);
        }
        sc.close();
    }

    public static void place(int board[][], int y, int x, int col, int size) {
        board[y][x]=col;
        // north
        for (int r = y - 1, c = x; r >= 0; r--) {
            if (board[r][c] == col) {
                for (int i = y - 1, j = x; i > r; i--) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // north east
        for (int r = y - 1, c = x + 1; r >= 0 && c < size; r--, c++) {
            if (board[r][c] == col) {
                for (int i = y - 1, j = x + 1; i > r && j < c; i--, j++) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // east
        for (int r = y, c = x + 1; c < size; c++) {
            if (board[r][c] == col) {
                for (int i = y, j = x + 1; j < c; j++) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // south east
        for (int r = y + 1, c = x + 1; r < size && c < size; r++, c++) {
            if (board[r][c] == col) {
                for (int i = y + 1, j = x + 1; i < r && j < c; i++, j++) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // south
        for (int r = y + 1, c = x; r < size; r++) {
            if (board[r][c] == col) {
                for (int i = y + 1, j = x; i < r; i++) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // south west
        for (int r = y + 1, c = x - 1; r < size && c >= 0; r++, c--) {
            if (board[r][c] == col) {
                for (int i = y + 1, j = x - 1; i < r && j > c; i++, j--) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // west
        for (int r = y, c = x - 1; c >= 0; c--) {
            if (board[r][c] == col) {
                for (int i = y, j = x - 1; j > c; j--) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
        // north west
        for (int r = y - 1, c = x - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == col) {
                for (int i = y - 1, j = x - 1; i > r && j > c; i--, j--) {
                    board[i][j] = col;
                }
                break;
            } else if (board[r][c] == 0) {
                break;
            }
        }
    }
}