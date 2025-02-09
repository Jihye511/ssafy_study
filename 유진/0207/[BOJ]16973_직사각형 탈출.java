import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Point{
	int x, y, cnt;
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int ans, n, m, h, w, sy, sx, fy, fx;
	static boolean[][] v;
	static int[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0}; //RLDU
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken())-1;
		sx = Integer.parseInt(st.nextToken())-1;
		fy = Integer.parseInt(st.nextToken())-1;
		fx = Integer.parseInt(st.nextToken())-1;
		
		ans = Integer.MAX_VALUE;
		v = new boolean[n][m];
		
		System.out.println(bfs());		
	}
	
	public static int bfs() {
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.offer(new Point(sx, sy, 0));
		v[sy][sx] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == fx && p.y == fy) return p.cnt;
			
			for(int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				int ncnt = p.cnt + 1;
				
				// 사각형이 범위 내, 벽에 안 닿는지, 방문 체크
				if(inMap(ny, nx) && !v[ny][nx] && canGo(ny, nx, d)) {
					q.offer(new Point(nx, ny, ncnt));
					v[ny][nx] = true;
				}
			}
		}
		return -1;
	}
	
	public static boolean inMap(int y, int x) {
		int y2 = y+h-1;
		int x2 = x+w-1;
		return 0 <= y && y < n && 0 <= x && x < m && 0 <= y2 && y2 < n && 0 <= x2 && x2 < m;
	}
	
	public static boolean canGo(int y, int x, int d) {
		// d: RLDU
		switch(d) {
		case 0:
			for(int i = 0; i < h; i++) {
				if(map[y+i][x+w-1] == 1) return false;
			}
			break;
		case 1:
			for(int i = 0; i < h; i++) {
				if(map[y+i][x] == 1) return false;
			}
			break;
		case 2:
			for(int i = 0; i < w; i++) {
				if(map[y+h-1][x+i] == 1) return false;
			}
			break;
		case 3:
			for(int i = 0; i < w; i++) {
				if(map[y][x+i] == 1) return false;
			}
			break;
		}
		return true;
	}
}
