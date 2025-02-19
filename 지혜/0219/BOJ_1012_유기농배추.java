package algorithm_study;
import java.io.*;
import java.util.*;

public class BOJ_1012_유기농배추 {
	static int M,N,K;
	static int[][] map;
	static int cnt;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
 	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt=0;
			map = new int[N][M];
			for(int i =0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			for(int i =0;i<N; i++) {
				for(int j =0; j<M; j++) {
					if(map[i][j]==1) {
						map[i][j]=0;
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static  void bfs(int x, int y) {
		Queue<int[]> q= new LinkedList<>();
		
		q.offer(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] cur= q.poll();
			for(int i =0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				
				if(map[nx][ny] ==1) {
					map[nx][ny] =0;
					q.offer(new int[] {nx,ny});
				}
			}
			
			
		}
	}

}
