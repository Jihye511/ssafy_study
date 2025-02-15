import java.util.*;
import java.io.*;

public class q1_산악구조로봇 {
    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int result;
    public static void main(String[] args) throws Exception {
        //출발 위치 : (1,1) 조난자 (N,N)
        //조난자위치까지 최소 연료
        //상하좌우
        //같은 높이 +1;
        //낮은 곳 x
        //높은 곳 높이 차 두배
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; //높이저장
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //(0,0)에서 출발
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i],Integer.MAX_VALUE);
            }

            dist[0][0] = 0;
            dij();
            System.out.printf("#%d %d\n",t,dist[N-1][N-1]);
        }
    }

    static void dij() {
        //좌표, 현재까지 연료 저장하기
        PriorityQueue<int[]> dq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};
        dq.add(new int[]{0,0,0});
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if (cost > dist[r][c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!inRange(nr,nc)) continue;
                int plus = 0;
                if (map[nr][nc] < map[r][c]) {
                    plus = 0;
                }
                else if (map[nr][nc] > map[r][c]) {
                    plus = (map[nr][nc] - map[r][c]) *2;
                }
                else if (map[nr][nc] == map[r][c]) {
                    plus = 1;
                }
                if (dist[r][c] + plus < dist[nr][nc]) {
                    dq.add(new int[]{nr,nc,dist[r][c] + plus});
                    dist[nr][nc] = dist[r][c] + plus;
                }
            }
        }
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0<=c && c<N;
    }
}
