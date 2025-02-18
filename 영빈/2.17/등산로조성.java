package swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 등산로조성 {

	static class Mount implements Comparable<Mount>{
		int x;
		int y;
		int len;
		int k;
		
		Mount(int x, int y, int len, int k)
		{
			this.x = x;
			this.y = y;
			this.len = len;
			this.k = k;
			
			
		}

		@Override
		public int compareTo(Mount o) {
			return Integer.compare(this.len, o.len);
		}
	}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, K;
	static int[][] map;
	static boolean[][] v;
	static int max_num;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];
			max_num = 0; 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max_num = Math.max(max_num, map[i][j]);
				}
			}

			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max_num) {
						v[i][j] = true;
						DFS(i, j, 1, map[i][j], K);
						v[i][j] = false;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, res);
			
			
			
			
		}
		
	}
	
	
	static void DFS(int x, int y, int len, int height, int k) {
		
		res = Math.max(len, res);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N || v[nx][ny])continue;
			
			if(k == 0) {
				if(map[nx][ny] < height) {
					v[nx][ny] = true;
					DFS(nx, ny, len + 1, map[nx][ny], k);
					v[nx][ny] = false;
				}
			}else {
				if(map[nx][ny] < height) {
					v[nx][ny] = true;
					DFS(nx, ny, len + 1, map[nx][ny], k);
					v[nx][ny] = false;
				}
				else if((map[nx][ny] - k) < height) {
					v[nx][ny] = true;
					DFS(nx, ny, len + 1, map[nx][ny] - 1, 0);
					v[nx][ny] = false;
				}
			}
			
			
			
			
			
			
			
			
			
		}
		
		
			
			
			
			
			
			
			
			
			
		
		
	}

}
