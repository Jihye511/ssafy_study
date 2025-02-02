import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		
		Queue<Point> q = new LinkedList<>();
		int[][] t = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				t[i][j] = Integer.parseInt(st.nextToken());
				if(t[i][j] == 1) {
					q.offer(new Point(j, i));
				}
			}
		}

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		while(!q.isEmpty()) {
			Point l = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = l.y + dy[i];
				int nx = l.x + dx[i];
				
				Point curr = new Point(nx, ny);
				if(inMap(ny, nx) && t[ny][nx] != -1) {
					if(t[ny][nx] == 0 || t[l.y][l.x]+1 < t[ny][nx]) {
						q.offer(curr);
						t[ny][nx] = t[l.y][l.x]+1;
					}
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(t[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, t[i][j]);
			}
		}
		System.out.println(ans-1);
		
	}
	static boolean inMap(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}
