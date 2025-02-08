import java.io.*;
import java.util.*;
public class BOJ_16973_직사각형탈출 {
    static int N,M;
    static int[][] map;
    static int H,W,SR,SC,FR,FC;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i =1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<M+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        SR = Integer.parseInt(st.nextToken());
        SC = Integer.parseInt(st.nextToken());
        FR = Integer.parseInt(st.nextToken());
        FC = Integer.parseInt(st.nextToken());
        System.out.println(bfs(SR,SC));


    }
    public static int bfs(int SR, int SC){
        int cnt=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {SR,SC});
        visited[SR][SC] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s =0; s<size; s++){
                int[] cur = q.poll();
                //도착하면 break;
                if(cur[0]==FR && cur[1] == FC) return cnt;
                for(int i =0; i<4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] +dy[i];
                    //nx,ny는 직사각형 왼쪽 상단이고 모든 면 비교해서 1과 만나는지 확인해야함
                    if (nx < 1 || ny < 1 || nx + H - 1 > N || ny + W - 1 > M) continue;

                    if(!visited[nx][ny] &&checkWall(nx,ny) ) {
                        //문제없으면
                        q.offer(new int[] { nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static  boolean checkWall(int nx, int ny){
        for (int i = nx; i < nx + H; i++){
            for (int j = ny; j < ny + W; j++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }
}
