package SSAFY_0209;
import java.util.*;
import java.io.*;
public class BOJ_7569_토마토 {
    static int M,N,H;
    static int[][][] map;
    static int days=0;
    static int[]dx = {-1,1,0,0,0,0};
    static int[]dy = {0,0,-1,1,0,0};
    static int[]dz = {0,0,0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];

        for(int h =0; h<H; h++){
            for(int i =0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    if(map[i][j][h] ==1){
                        q.offer(new int[]{i,j,h});
                    }
                }
            }
        }

        if(checkTomatos()){
            //토마토 다 익어있음 0출력
            days=0;
        }else{
            days = bfs()-1;
        }
        if(!checkTomatos()){
            days=-1;
        }
        System.out.println(days);
    }
    public static int bfs(){
        int temp=0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int d = 0; d < 6; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    int nz = cur[2] + dz[d];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                    if (map[nx][ny][nz] == 0) {
                        map[nx][ny][nz] = 1;
                        q.offer(new int[]{nx, ny, nz});
                    }
                }
            }
            temp++;
        }
        return temp;
    }
    public static boolean checkTomatos(){
        for(int h =0; h<H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j][h]==0) return false;
                }
            }
        }
        return true;
    }
}
