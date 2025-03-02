import java.util.*;

public class Main {
    static int T, M, N, K;
    static boolean[][] field, visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            // 가로
            M = sc.nextInt();
            // 세로
            N = sc.nextInt();
            // 배추
            K = sc.nextInt();
            // 밭
            field = new boolean[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                field[X][Y] = true;
            }
            int warm = 0;
            for(int x=0;x<M;x++){
                for(int y = 0; y<N;y++){
                    if(field[x][y] && !visited[x][y]){
                        visited[x][y] = true;
                        bfs(x,y);
                        warm += 1;
                    }
                }
            }
            System.out.println(warm);
        }
        sc.close();
    }

    public static void bfs(int x, int y) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int cx = coordinate[0];
            int cy = coordinate[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (field[nx][ny] && !visited[nx][ny]) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }
    }
}