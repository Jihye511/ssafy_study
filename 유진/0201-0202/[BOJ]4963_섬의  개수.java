import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
			int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
			
			boolean[][] v = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						ans++;
						
						Queue<Point> q = new ArrayDeque<>();
						
						q.offer(new Point(j, i));
						v[i][j] = true;
						
						while(!q.isEmpty()) {
							Point p = q.poll();
							for(int d = 0; d < 8; d++) {
								int ny = p.y + dy[d];
								int nx = p.x + dx[d];
								if(inMap(ny, nx) && map[ny][nx] == 1 && !v[ny][nx]) {
									q.offer(new Point(nx, ny));
									v[ny][nx] = true;
								}
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	static boolean inMap(int y, int x) {
		return 0 <= y && y < h && 0 <= x && x < w;
	}
}
