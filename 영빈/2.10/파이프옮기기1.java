package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	static int res = 0;
	
	
	static class pipe{
		int x;
		int y;
		int pose;
		
		pipe(int x, int y, int pose){
			this.x = x;
			this.y = y;
			this.pose = pose;
		}
	}
	static Queue<pipe> q = new LinkedList<>();

	
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 1);
		System.out.println(res);
		
		
	}
	
	static void dfs(int x, int y, int pose) {
		if(x == N-1 && y == N-1) {
			res++;
			return;
		}
		
		for(int i = 1; i <= 3; i++) {
			int nx = x + dx[i-1];
			int ny = y + dy[i-1];
			
			if(pose == 1) {
				if(step(nx, ny) && i == 1) {
					dfs(nx, ny, i);
				}
				else if(stepx(nx, ny) && i == 2) {
					dfs(nx, ny, i);
				}
			}
			if(pose == 2) {
				if(step(nx, ny) && i == 1) {
					dfs(nx, ny, i);
				}
				else if(stepx(nx, ny) && i == 2) {
					dfs(nx, ny, i);
				}
				else if(step(nx, ny) && i == 3) {
					dfs(nx, ny, i);
				}
			}
			if(pose == 3) 
				if(stepx(nx, ny) && i == 2) {
					dfs(nx, ny, i);
				}
				else if(step(nx, ny) && i == 3) {
					dfs(nx, ny, i);
				}
			}
		
	}
		
	
		
	static boolean step(int x, int y) { //이동가능
		if(y < N && x < N && map[x][y] == 0) {
			return true;
		}
		else {return false;}
	}
	static boolean stepx(int x, int y) { //대각선 이동가능
		if(y < N && x < N && map[x][y] == 0
				&& map[x - 1][y] == 0 && map[x][y - 1] == 0) {
			return true;
		}
		else {return false;}
	}
	
		
	
	
}
