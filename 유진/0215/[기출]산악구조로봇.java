import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point>{
		int y, x, w;
		Point(int y, int x, int w){
			this.y = y;
			this.x = x;
			this.w = w;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int[][][] map;
	static boolean[][] v;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N][2]; // 높이, 거리  
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j][0] = Integer.parseInt(st.nextToken());
					map[i][j][1] = Integer.MAX_VALUE; 
				}
			}
			
			v = new boolean[N][N];
			Queue<Point> q = new PriorityQueue<>();
			map[0][0][1] = 0; 
			q.offer(new Point(0, 0, 0));
			
			while(!q.isEmpty()) {
				Point curr = q.poll();
				if(v[curr.y][curr.x]) continue;
				v[curr.y][curr.x] = true;
				
				for(int d = 0; d < 4; d++) {
					int ny = curr.y + dy[d];
					int nx = curr.x + dx[d];
					
					if(inMap(ny, nx) && !v[ny][nx] && map[ny][nx][1] > map[curr.y][curr.x][1]+calcCost(curr.y, curr.x, ny, nx)) {
						map[ny][nx][1] = map[curr.y][curr.x][1] + calcCost(curr.y, curr.x, ny, nx);
						q.offer(new Point(ny, nx, map[ny][nx][1]));
					}
				}
			}
			System.out.println("#"+test_case+" "+map[N-1][N-1][1]);
		}
	}
	
	static int calcCost(int sy, int sx, int ey, int ex) {
		if(map[sy][sx][0] == map[ey][ex][0]) {
			return 1;
		} else if(map[sy][sx][0] > map[ey][ex][0]) {
			return 0;
		} else {
			return (map[ey][ex][0] - map[sy][sx][0]) * 2;
		}
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}

//#1 2
//#2 16
//#3 32