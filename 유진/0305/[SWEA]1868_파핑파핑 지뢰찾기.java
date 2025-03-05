import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int N, ans;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) == '.' ? 0 : -1;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == -1) continue;
					int bombCnt = 0;
					for(int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(inMap(ny, nx) && map[ny][nx] == -1) {
							bombCnt++;
						}
					}
					map[i][j] = bombCnt;
				}
			}
			
			ans = 0;
			v = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 0 && !v[i][j]) {
						ans++;
						
						Queue<Point> q = new ArrayDeque<>();
						q.offer(new Point(j, i));
						v[i][j] = true;
						while(!q.isEmpty()) {
							Point p = q.poll();
							for(int d = 0; d < 8; d++) {
								int ny = p.y + dy[d];
								int nx = p.x + dx[d];
								if(inMap(ny, nx) && !v[ny][nx]) {
									v[ny][nx] = true;
									if(map[ny][nx] == 0) {
										q.offer(new Point(nx, ny));
									}
								}
							}
						}
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > 0 && !v[i][j]) {
						ans++;
					}
				}
			}
			
			System.out.println("#"+test_case + " " + ans );
		}

	}
	static boolean inMap(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
