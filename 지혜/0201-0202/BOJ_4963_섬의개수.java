import java.io.*;
import java.util.*;
public class BOJ_4963_섬의개수 {
    static int w,h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0,-1,1,1,-1};
    static int[] dy ={0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) return;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt=0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] ==1 && !visited[i][j]){
                        visited[i][j] =true;
                        bfs(i,j);
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
    public static void bfs(int x, int y){
        Queue<int[]> q=  new ArrayDeque<>();
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i =0; i<8 ;i ++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }



        }

    }

}
