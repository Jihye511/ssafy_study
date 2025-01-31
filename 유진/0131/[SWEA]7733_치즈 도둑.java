import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	static int n;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			n = sc.nextInt();
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[] dy = {0, 0, -1, 1};
			int[] dx = {1, -1, 0, 0};
			int ans = 1; 
			
			for(int day = 1; day <= 100; day++) {
				int cnt = 0;
				Queue<Point> q = new ArrayDeque<Point>();
				boolean[][] v = new boolean[n][n];
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(map[i][j] > day && !v[i][j]) {
							cnt++;
							q.offer(new Point(j, i));
							v[i][j] = true;
							while(!q.isEmpty()) {
								Point p = q.poll();
								for(int d = 0; d < 4; d++) {
									int ny = p.y + dy[d];
									int nx = p.x + dx[d];
									if(inMap(ny, nx) && !v[ny][nx] && map[ny][nx] > day) {
										q.offer(new Point(nx, ny));
										v[ny][nx] = true;
									}
								}
							}
						}
					}
				}
				ans = Math.max(ans, cnt);
			}
			System.out.println("#" + test_case+ " " + ans);
		}
		sc.close();
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}
