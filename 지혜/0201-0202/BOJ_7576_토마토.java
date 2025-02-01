import java.util.*;
import java.io.*;
public class BOJ_7576_토마토 {
    static int M,N;
    static int[][] map;
    static Queue<int[]>q =new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cnt=-1;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map= new int[N][M];
        for(int i =0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }
        bfs();
        for(int[] temp : map){
            for(int v : temp){
                if(v==0){
                    cnt=-1;
                }
            }
        }
        System.out.println(cnt);

    }
    public static void bfs(){
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }


            }
            cnt += 1;
        }
    }
}
