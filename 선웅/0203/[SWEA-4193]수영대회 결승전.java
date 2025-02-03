import java.util.*;

public class Solution {
    static int N;
    static int startR;
    static int startC;
    static int finishR;
    static int finishC;
    static boolean[][][] visited;
    private static int min;
    private static int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        // test case만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();min = Integer.MAX_VALUE;
            int[][] sea = new int[N][N];
            visited = new boolean[N][N][2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sea[i][j] = sc.nextInt();
                }
            }
            startR = sc.nextInt();
            startC = sc.nextInt();
            finishR = sc.nextInt();
            finishC = sc.nextInt();
            bfs(sea);
            if(min == Integer.MAX_VALUE){
                System.out.println("#" + test_case + " -1");
                return;
            }
            System.out.println("#" + test_case + " " + min);
        }
        sc.close();
    }

    public static void bfs(int[][] sea) {
        visited[startR][startC][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startR, startC, 0 });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == finishR && cur[1] == finishC) {
                min = Math.min(min, cur[2]);
            }
            for (int[] dir : directions) {
                int newR = cur[0] + dir[0];
                int newC = cur[1] + dir[1];
                if (newR < 0 || newR >= N || newC < 0 || newC >= N) {
                    continue;
                }
                if (sea[newR][newC] == 0 && !visited[newR][newC][0]) {
                    int[] temp = new int[] { newR, newC, cur[2] + 1 };
                    visited[newR][newC][0] = true;
                    queue.offer(temp);
                    continue;
                }
                if (sea[newR][newC] == 1) {
                    continue;
                }
                if (sea[newR][newC] == 2 && !visited[newR][newC][1]) {
                    if (cur[2] % 3 == 2) {
                        int[] temp = new int[] { newR, newC, cur[2] + 1 };
                        visited[newR][newC][1] = true;
                        queue.offer(temp);
                        continue;
                    } else {
                        int[] temp = new int[] { cur[0], cur[1], cur[2] + 1 };
                        queue.offer(temp);
                        continue;
                    }
                }

            }
        }
    }

}