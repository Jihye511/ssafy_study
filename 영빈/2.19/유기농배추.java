package algo_Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {
	
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] v;
	static class Mu{
		int x;
		int y;
		
		Mu(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int M, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			v = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[y][x] = 1;
				
			}
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
						ans++;
					}
				}
			}
			System.out.printf("%d\n", ans);
			
		}

	}
	
	
	static void bfs(int x, int y) {
		Mu mu = new Mu(x, y);
		Queue<Mu> q = new LinkedList<>();
		
		q.offer(mu);
		while(!q.isEmpty()) {
			Mu now = q.poll();
			v[now.x][now.y] = true;

			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny]) continue;
				if(map[nx][ny] == 0)continue;
				q.add(new Mu(nx, ny));
			}
			
		}
		
	}

}
