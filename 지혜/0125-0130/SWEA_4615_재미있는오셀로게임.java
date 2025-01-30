package 설연휴;
import java.io.*;
import java.util.*;

public class SWEA_4615_재미있는오셀로게임 {
    static int N,M;
    static int[][] map;
    static int[] dx={-1,1,0,0,-1,-1,1,1};
    static int[] dy={0,0,-1,1,-1,1,-1,1};
    static boolean flag=false;
    static int black;
    static int white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <=T ; tc++) {
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            map=new int[N+1][N+1];
            map[N/2][N/2]=2;
            map[N/2][N/2+1]=1;
            map[N/2+1][N/2]=1;
            map[N/2+1][N/2+1]=2;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                map[R][C] = Integer.parseInt(st.nextToken());

                for (int j = 0; j < 8; j++) {
                    flag=false;
                    int xx=R+dx[j];
                    int yy=C+dy[j];
                    if(0<xx&&xx<N+1&&0<yy&&yy<N+1&&map[xx][yy]>0)
                        dfs(j, xx, yy, map[R][C]);
                }
            }
            black =0;
            white=0;
            for (int[] a:map){
                for(int b:a){
                    if(b==1){
                        black++;
                    }
                    else if(b==2){
                        white++;
                    }

                }
            }
            System.out.printf("#%d %d %d\n",tc,black, white);
        }
    }
    private static void dfs(int j,int r, int c,int stone) {
        if(map[r][c]==stone){
            flag=true;
            map[r][c]=stone;
            return;
        }
        int xx=r+dx[j];
        int yy=c+dy[j];
        if(0<xx&&xx<N+1&&0<yy&&yy<N+1&&map[xx][yy]>0){
            dfs(j,xx,yy,stone);
        }
        if(flag==true){
            map[r][c]=stone;
        }
    }
}