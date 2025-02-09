package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	
	static class node{
		int x;
		int y;
		
		node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;
	static Queue<node> q = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int max = 0;
		for(int hi = 0; hi <= 100; hi++) {
			int a = 0;
			boolean[][] v = new boolean[N][N];

			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(!v[i][j] && map[i][j] > hi) {
						bfs(i, j, hi, v);
						a++;
					}
				}
			}
			max = Math.max(max, a);
		}
		
		System.out.println(max);
		
		
		sc.close();
	}
	
	static void bfs(int x, int y, int hi, boolean[][] v) {
		node n = new node(x, y);
		v[x][y] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			node now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(map[nx][ny] > hi && !v[nx][ny]) {
						q.add(new node(nx, ny));
						v[nx][ny] = true;
					}
				}
				
			}
			
		}
		
		
	}

}
