import java.util.*;
import java.io.*;

public class Boj_4963_섬의개수 {
    public static void main(String[] args) throws Exception {
        //bfs
        //팔방탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dr = {-1,1,0,0,1,1,-1,-1};
        int[] dc = {0,0,-1,1,1,-1,1,-1};

        while (true) {
            int result = 0;

            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if (w == 0 && h == 0) {
                break;
            }
            Deque<int[][]> dq = new ArrayDeque<>();
            int[][] island = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int s = Integer.parseInt(st.nextToken());
                    island[i][j] = s;
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && island[i][j] == 1) {
                        dq.add(new int[][]{{i,j}});

                        while (!dq.isEmpty()) {
                            int[][] curr = dq.pollFirst();
                            int r = curr[0][0];
                            int c = curr[0][1];
                            for (int k = 0; k < 8; k++) {
                                int nr = r + dr[k];
                                int nc = c + dc[k];
                                if (inRange(nr,nc,h,w) && !visited[nr][nc] && island[nr][nc] == 1) {
                                    visited[nr][nc] = true;
                                    dq.add(new int[][]{{nr,nc}});
                                }
                            }
                        }
                        result += 1;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static boolean inRange(int r, int c, int h, int w) {
        return 0 <= r && r < h && 0 <= c && c < w;
    }
}
