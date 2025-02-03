import java.awt.Point;
import java.util.*;
import java.io.*;

public class Swea_4193_수영대회_결승전 {
    static int result;
    static int MAX_VALUE = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] times = new int[N][N];

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    times[i][j] = MAX_VALUE;
                }
            }

            int[][] spots = new int[2][2];
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                spots[i][0] = Integer.parseInt(input[0]);
                spots[i][1] = Integer.parseInt(input[1]);
            }

            //소용돌이 지나쳐서 오거나, 아니거나
            boolean[][] visited = new boolean[N][N];

            Deque<Point> dq = new ArrayDeque<>();
            dq.add(new Point(spots[0][0], spots[0][1]));
            visited[spots[0][0]][spots[0][1]] = true;
            times[spots[0][0]][spots[0][1]] = 0;
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};

            int period = 0;   //소용돌이 주기 체크용
            while (!dq.isEmpty()) {
                Point p = dq.pollFirst();
                if (p.x == spots[1][0] && p.y == spots[1][1]) {
                    result = times[p.x][p.y];
                    break;
                }

                visited[p.x][p.y] = true;
                for (int k = 0; k < 4; k++) {
                    int nr = p.x + dr[k];
                    int nc = p.y + dc[k];

                    if (inRange(nr,nc,N)) {
                        // 0 : 장애물 x
                        if (map[nr][nc] != 1 && times[p.x][p.y] != MAX_VALUE) {
                            if (map[nr][nc] == 0 || period % 3 == 0) {
                                visited[nr][nc] = true;
                                times[nr][nc] = times[p.x][p.y] + 1;
                            }
                            else {
                                //0초일때 3초 1초일때 2 2초일때 1, 3초일때 2
                                times[nr][nc] = times[p.x][p.y] + (3-(period%3));
                            }
                            dq.add(new Point(nr,nc));
                        }

                        // 1 : 장애물 -> 이동불가
                        // 2 : 소용돌이 -> 기다리거나 안가거나
                    }
                }
                period++;
            }

            if (result == MAX_VALUE) {
                result = 1;
            }
            System.out.printf("#%d %d\n",t,result);
        }
    }

    static boolean inRange(int r, int c, int N) {
        return 0<= r && r < N && 0 <= c && c < N;
    }

    //bfs

}
