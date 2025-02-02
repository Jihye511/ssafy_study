import java.util.Scanner;

class Solution {
	static int r, c, ans;
	static boolean[] v;
	static int[][] map;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			r = sc.nextInt();
			c = sc.nextInt();
			map = new int[r][c];
			for(int i = 0; i < r; i++) {
				String s = sc.next();
				for(int j = 0; j < c; j++) {
					map[i][j] = s.charAt(j)-'A';
				}
			}
			ans = 1;
			v = new boolean[26];
			dfs(0, 0, 1);
			System.out.println("#" + test_case+ " " + ans);
		}
		sc.close();
	}
	
	static void dfs(int y, int x, int cnt) {
		v[map[y][x]]=true;
		ans = Math.max(ans, cnt);
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(inMap(ny, nx) && !v[map[ny][nx]]) {
				dfs(ny, nx, cnt+1);
			}
		}
		v[map[y][x]]=false;
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < r && 0 <= x && x < c;
	}
}
