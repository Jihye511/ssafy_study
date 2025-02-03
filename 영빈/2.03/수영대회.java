package com.ssafy.ws.step2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;


public class Solution {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static int lx;
	static int ly;
	
	private static class swim{
		int x;
		int y;
		int second;
		
		public swim(int x, int y, int second) {
			this.x = x;
			this.y = y;
			this.second = second;
		}
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++)
		{
			
			
			N = sc.nextInt();
			int[][] map = new int[N][N];
			boolean[][] visitied = new boolean[N][N];
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					map[i][j] = sc.nextInt();
				}
			}
			int x = sc.nextInt();
			int y = sc.nextInt();
			lx = sc.nextInt();
			ly = sc.nextInt();
			System.out.printf("#%d %d\n", t + 1, bfs(x, y, map, visitied));	
		}
		
	}
	
	public static int bfs(int x, int y, int[][] map, boolean[][] visitied) {

		Queue<swim> q = new LinkedList<swim>();
        q.add(new swim(x, y, 0));
		visitied[x][y] = true;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()){
			swim now = q.poll();
			
	        if (now.x == lx && now.y == ly)
	        {
	        	return now.second;
	        }
			
			for(int i = 0; i < 4; i++)
			{
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N)
				{
					if(!visitied[nx][ny]&&map[nx][ny] != 1) {
						visitied[nx][ny] = true;
						q.add(new swim(nx, ny, now.second + 1 + map[nx][ny]));
						
					}
				}
			}
		}
		return min;
	}
}
