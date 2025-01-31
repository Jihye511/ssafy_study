import java.util.*;
import java.io.*;

public class SWEA_7733_치즈도둑 {
    static int T, N;
    static int[][] map;
    static int cnt =0;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }
            for (int i = 0; i <= max; i++) {//날짜 별 탐색
                visited = new boolean[N][N];
                int temp =0; //치즈덩어리 개수 저장
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (!visited[j][k] && map[j][k] > i) {
                            visited[j][k] = true;
                            bfs(j, k, i);
                            temp++;
                        }
                    }
                }
                cnt = Math.max(cnt, temp);
            }

            System.out.println("#" + t + " " + cnt);
        }


    }

    public static void bfs(int x, int y, int day) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i =0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx <0 || nx>=N || ny<0 || ny>=N) continue;
                if (visited[nx][ny] || map[nx][ny] <= day) continue;

                visited[nx][ny] = true;
                q.offer(new int[] {nx,ny});

            }
        }
    }
}