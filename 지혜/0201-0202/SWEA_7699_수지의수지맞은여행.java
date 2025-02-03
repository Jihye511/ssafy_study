import java.io.*;
import java.util.*;
public class SWEA_7699_수지의수지맞은여행 {
    static int R,C;
    static int[][]map;
    static boolean[] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cnt = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t =1; t<=T; t++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            cnt =0;
            map = new int[R][C];
            visited = new boolean[100];
            for(int i = 0; i<R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j)-'0';
                }
            }
            dfs(0,0,1);
            System.out.println("#" + t + " "+cnt);



        }

    }
    public static void dfs(int x, int y, int depth){
        visited[map[x][y]] = true;

        if(cnt<depth){
            cnt = depth;
        }
        for(int i =0; i<4; i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
            if(!visited[map[nx][ny]]){
                dfs(nx,ny,depth+1);
            }
        }
        visited[map[x][y]] = false;


    }
}
