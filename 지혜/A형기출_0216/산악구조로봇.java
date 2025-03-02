package A형기출_0210;

import java.io.*;
import java.util.*;

public class 산악구조로봇 {
    static class Vertex implements Comparable<Vertex>{
        int x;
        int y;
        int w;
        public Vertex(int x,int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int N;
    static int[][] map;
    static ArrayList<Node>[] list;
    static int[][] dis;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());

            map = new int[N+1][N+1];
            dis = new int[N+1][N+1];
            visited = new boolean[N+1][N+1];

            for(int i =1; i<=N; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j =1; j<=N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(1,1); //출발

            System.out.println("#" + t +" " +dis[N][N]);
        }



    }
    public static void bfs(int x, int y){
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        dis[x][y] = 0;
        pq.offer(new Vertex(x,y,0));

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();
            if(visited[cur.x][cur.y]) continue;

            visited[cur.x][cur.y] = true;
            //상하좌우의 좌표에 방문 x , dis 값 작으면 업데이트
            for(int i =0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx<=0 || nx> N || ny<=0 || ny>N) continue;
                int diff = map[cur.x][cur.y]  - map[nx][ny];
                int fuel;
                if(diff ==0){ //높이 같다
                    fuel =1;
                }else if(diff <0){
                    fuel = Math.abs(diff) * 2;
                }else{
                    fuel =0;
                }
                if(!visited[nx][ny]  && dis[cur.x][cur.y] +fuel <dis[nx][ny]){
                    dis[nx][ny] = dis[cur.x][cur.y] +fuel;
                    pq.offer(new Vertex(nx,ny,dis[nx][ny]));
                }

            }
        }
    }
}