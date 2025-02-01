import java.util.*;

public class Solution {
    private static boolean[][] visited;
    private static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private static int N;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        // test case만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            int[][] cheese = new int[N][N];
            boolean[][] checkEaten = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }
            int chunk = 1;
            for (int day = 1; day <= 100; day++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheese[i][j] == day) {
                            checkEaten[i][j] = true;
                        }
                    }
                }
                chunk = Math.max(chunk, countChunk(checkEaten));

            }
            System.out.printf("#%d %d\n", test_case, chunk);

        }
        sc.close();
    }
    public static int countChunk(boolean[][] field) {
        visited = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!field[i][j] && !visited[i][j]) {
                    bfs(field, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(boolean[][] field, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N && !field[newX][newY] && !visited[newX][newY]) {
                    queue.offer(new int[] { newX, newY });
                    visited[newX][newY] = true;
                }
            }

        }
    }
}