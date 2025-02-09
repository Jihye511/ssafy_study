package SSAFY_0209;
import java.io.*;
import java.util.*;
public class BOJ_2468_안전영역 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max_area=1;
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int max= 0; //최대 높이
        StringTokenizer st;
        for(int i =0 ;i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for(int h=0; h<max; h++){//강수 높이
            int area= 0;
            visited = new boolean[N][N];
            for(int i =0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]>h && !visited[i][j]){
                        bfs(i,j,h);
                        area++;
                    }
                }
            }
            max_area= Math.max(area,max_area);
        }
        System.out.println(max_area);
    }
    public static void bfs(int x,int y,int h){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y]=true;
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i =0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] > h){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }

        }
    }
}
