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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][][] dist = new int[n][m][2];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
				dist[i][j][0] = Integer.MAX_VALUE;
				dist[i][j][1] = Integer.MAX_VALUE;
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		Queue<Point> q = new LinkedList<>();
		boolean[][][] v = new boolean[n][m][2];
		
		q.offer(new Point(0,0));
		v[0][0][0] = true;
		dist[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(inMap(ny, nx)) {
					// 벽이 아닌 경우 
					if(map[ny][nx] == 0) {
						// 벽을 부수지 않고 올 수 있는 경우 
						if(!v[ny][nx][0] && dist[p.y][p.x][0] != Integer.MAX_VALUE) {
							dist[ny][nx][0] = dist[p.y][p.x][0] + 1;
							v[ny][nx][0] = true;
							q.add(new Point(nx, ny));
						}
						// 벽을 한 번 부수고 온 경우 
						if(!v[ny][nx][1] && dist[p.y][p.x][1] != Integer.MAX_VALUE) {
							dist[ny][nx][1] = dist[p.y][p.x][1] + 1;
							v[ny][nx][1] = true;
							q.add(new Point(nx, ny));
						}
						
					// 벽인 경우
					} else if(map[ny][nx] == 1) {
						// 벽을 부수지 않고 올 수 있는 경우 
						if(!v[ny][nx][1] && dist[p.y][p.x][0] != Integer.MAX_VALUE) {
							dist[ny][nx][1] = dist[p.y][p.x][0] + 1;
							v[ny][nx][1] = true;
							q.add(new Point(nx, ny));
						}
					}
				}
			}
		}
		
		int ans = Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
		
	}
	static boolean inMap(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}
