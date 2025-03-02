package swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 산악구조로봇 {
    static class Robot implements Comparable<Robot>{
        int x;
        int y;
        int hi;
        
        Robot(int x, int y, int hi){
            this.x = x;
            this.y = y;
            this.hi = hi;
        }

        @Override
        public int compareTo(Robot o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.hi, o.hi);
        }
        
        
        
        
    }
    
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, cost;
    static boolean[][] v;
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int t = 1; t < T + 1; t++) {
            
            N = sc.nextInt();
            v = new boolean[N+1][N+1];
            cost = new int[N + 1][N + 1];
            map = new int[N + 1][N + 1];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j < N + 1; j++) {
                    map[i][j] = sc.nextInt();
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs(1, 1);
            System.out.printf("#%d %d\n", t, cost[N][N]);
            
            
        }
        
        
    }
    
    
    
    static void bfs (int x, int y) {
        PriorityQueue<Robot> q = new PriorityQueue<>();
        Robot R = new Robot(x, y, map[x][y]);
        
        q.add(R);
        cost[x][y] = 0;

        while(!q.isEmpty()) {
            Robot now = q.poll();
            
            
            if(v[now.x][now.y]) continue;
            v[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx <= 0 | nx > N | ny <= 0 | ny > N) continue;
                
                int diff = map[now.x][now.y]  - map[nx][ny];
                int fuel;
                
                if(diff == 0){ //높이가 같다면
                    fuel = 1;
                }else if(diff < 0){ //높이가 높다면
                    fuel = Math.abs(diff) * 2;
                }else{
                    fuel =0 ;
                }
                
                if(!v[nx][ny] && cost[now.x][now.y] + fuel < cost[nx][ny]) {
                    cost[nx][ny] = cost[now.x][now.y]+ fuel; 
                    q.offer(new Robot(nx, ny, cost[nx][ny]));
                }
                
                
                
            }
        }
        
        
    }
}
