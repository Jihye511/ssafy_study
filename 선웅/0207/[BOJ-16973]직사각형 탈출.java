import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int H = sc.nextInt();
        int W = sc.nextInt();
        int Sr = sc.nextInt();
        int Sc = sc.nextInt();
        int Fr = sc.nextInt();
        int Fc = sc.nextInt();
        int newN = N - H + 1;
        int newM = M - W + 1;
        int[][] newBoard = new int[newN][newM];
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newM; j++) {
                int sum = 0;
                for (int r = i; r < i + H; r++) {
                    for (int c = j; c < j + W; c++) {
                        sum += board[r][c];
                    }
                }
                if(sum>0){
                    newBoard[i][j] = 1;
                }
            }
        }
        System.out.println(bfs(newBoard, newN, newM, Sr - 1, Sc - 1, Fr - 1, Fc - 1));
        sc.close();
    }

    public static int bfs(int[][] board, int R, int C, int Sr, int Sc, int Fr, int Fc) {
        if (board[Sr][Sc] == 1) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] visited = new boolean[R][C];
        visited[Sr][Sc] = true;
        queue.offer(new int[] { Sr, Sc, 0 });
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            for (int[] d : dir) {
                int newR = q[0] + d[0];
                int newC = q[1] + d[1];
                if (newR < 0 || newR >= R || newC < 0 || newC >= C || visited[newR][newC] || board[newR][newC] == 1) {
                    continue;
                } else {
                    queue.offer(new int[] { newR, newC, q[2] + 1 });
                    visited[newR][newC] = true;
                    if (newR == Fr && newC == Fc) {
                        return q[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}