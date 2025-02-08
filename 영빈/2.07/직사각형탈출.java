package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 직사각형탈출 {
	static Queue<sq> q = new LinkedList<>();
	static class sq{
		int x;
		int y;
		int dis;
		sq(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] v;
	static int H, W, N, M, Si, Sj, Fi, Fj;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		v = new boolean[N+1][M+1];
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= M; j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		H = sc.nextInt();
		W = sc.nextInt();
		Si = sc.nextInt();
		Sj = sc.nextInt();
		Fi = sc.nextInt();
		Fj = sc.nextInt();
		
		System.out.println(bfs());
		
	}
	
	public static int bfs() {
		sq now = new sq(Si, Sj, 0);
		q.add(now);
		v[Si][Sj] = true;
		
		while(!q.isEmpty()) {
			sq tmp = q.poll();
			
			if(tmp.x == Fi && tmp.y == Fj) {
				return tmp.dis;
			}
			
			for(int i =0; i < 4; i++)
			{
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx > 0 && nx + H - 1<= N && ny > 0 && ny + W - 1<= M)
				{
					if(!v[nx][ny] && Igo(nx, ny))
					{
						v[nx][ny] = true;
						q.add(new sq(nx, ny, tmp.dis + 1));
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean Igo(int nx, int ny) {
		for(int i = nx; i < nx + H; i++)
		{
			for(int j = ny; j < ny + W; j++)
			{
				if(map[i][j] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}

		
}
