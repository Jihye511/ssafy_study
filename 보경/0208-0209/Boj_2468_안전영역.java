import java.util.*;
import java.io.*;

public class Boj_2468_안전영역 {
    static int N;
    static int[][] map;
    static int result = 1;  //비가 안 올 때
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        //높이 이하 잠김 (높이 포함)
        //치즈랑 비슷한듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        //모든 비의 양에 대해 따져봐야됨'
        int minH = Integer.MAX_VALUE;
        int maxH = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < minH) minH = map[i][j];
                if( map[i][j] > maxH) maxH = map[i][j];
            }
        }

        //비에 따라 bfs 반복
        for (int i =minH; i < maxH; i++) {
            int res = bfs(i);
            if (res == 0) {  //현재 비보다 높은 지역 존재 X
                break;
            }
            result = Math.max(result,res);
        }
        System.out.println(result);
    }

    static int bfs(int rain) {
        int temp = 0;
        for (int i =0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > rain) {
                    dq.add(new int[]{i,j});
                    temp += 1;
                    while (!dq.isEmpty()) {
                        int[] p = dq.pollFirst();
                        for (int k =0 ; k <4;k++) {
                            int nr = p[0] + dr[k];
                            int nc = p[1] + dc[k];
                            if (inRange(nr,nc) &&!visited[nr][nc] && map[nr][nc] > rain) {
                                visited[nr][nc] = true;
                                dq.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    static boolean inRange(int r, int c) {
        return 0<= r && r < N && 0 <= c && c < N;
    }
}
