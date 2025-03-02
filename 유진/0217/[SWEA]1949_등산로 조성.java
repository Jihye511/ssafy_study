import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, K, ans;
	static boolean fixed;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ArrayList<Point> peaks = new ArrayList<>();
			int max_height = 0;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(max_height < map[i][j]) {
						peaks = new ArrayList<Point>();
						peaks.add(new Point(j, i));
						max_height = map[i][j];
					} else if (max_height == map[i][j]) {
						peaks.add(new Point(j, i));
					}
				}
			}
			
			v = new boolean[N][N];
			ans = 0;
			for(Point p: peaks) {
				v[p.y][p.x]= true; 
				dfs(p.y, p.x, 1);
				v[p.y][p.x]= false; 
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void dfs(int y, int x, int len) {
		if(len > ans) ans = len;
		
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(inMap(ny, nx) && !v[ny][nx]) {
				if(map[ny][nx] < map[y][x]) {
					v[ny][nx] = true;
					dfs(ny, nx, len+1);
					v[ny][nx] = false;
				} else if(!fixed && K >= map[ny][nx]-map[y][x] +1) {
					int origin = map[ny][nx];
					map[ny][nx] = map[y][x]-1;
					fixed = true;
					v[ny][nx] = true;
					dfs(ny, nx, len+1);
					v[ny][nx] = false;
					fixed = false;
					map[ny][nx] = origin;
				}
			}
		}
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
