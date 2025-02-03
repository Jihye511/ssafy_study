import java.util.Scanner;

class Solution {
	static int n, ans, ey, ex;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			n = sc.nextInt();
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int sy = sc.nextInt();
			int sx = sc.nextInt();
			ey = sc.nextInt();
			ex = sc.nextInt();
			
			ans = Integer.MAX_VALUE;
			v = new boolean[n][n];
			dfs(sy, sx, 0);
			
			if(ans == Integer.MAX_VALUE) {
				System.out.println("#" + test_case+ " " + -1);
			} else {
				System.out.println("#" + test_case+ " " + ans);
			}
		}
		sc.close();
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
	
	static void dfs(int y, int x, int time) {
		if(time >= ans) {
			return;
		}
		if(y == ey && x == ex) {
			ans = Math.min(ans, time);
			return;
		}
		
		v[y][x] = true;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(inMap(ny, nx) && !v[ny][nx] && map[ny][nx] != 1) {
				if(map[ny][nx] == 2) {
					int extra = 2 - time%3;
					dfs(ny, nx, time+1 + extra);
				} else {
					dfs(ny, nx, time+1);
				}
			}
		}
		v[y][x] = false;
	}
}
