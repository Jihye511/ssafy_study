import java.awt.Point;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int ans;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		for(int rain = 0; rain < 99; rain++) {
			int cnt = 0;
			boolean[][] v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] > rain && !v[i][j]) {
						cnt++;
						//BFS 탐색 
						Queue<Point> q = new ArrayDeque<>();
						q.offer(new Point(j, i));
						v[i][j] = true;
						while(!q.isEmpty()) {
							Point p = q.poll();
							for(int d = 0; d < 4; d++) {
								int ny = p.y + dy[d];
								int nx = p.x + dx[d];
								if(0 > ny || ny >= n || 0 > nx || nx >= n) continue;
								if(map[ny][nx] > rain && !v[ny][nx]) {
									q.offer(new Point(nx, ny));
									v[ny][nx] = true;
								}
							}
						}
					}
				}
				ans = Math.max(ans, cnt);
			}
		}
		System.out.println(ans);
	}
}
