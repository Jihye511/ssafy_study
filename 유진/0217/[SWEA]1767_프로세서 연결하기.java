import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, connected, min_len;
	static int[][] map;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};	
	static ArrayList<Point> cores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			connected = 0;
			min_len = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cores = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i == 0 || i == N-1 || j == 0 || j == N-1) {
							connected++;
						} else {
							cores.add(new Point(j, i));
						}
					}
				}
			}
			
			dfs(0, connected, 0);
			
			System.out.println("#"+test_case+" "+min_len);
			
		}
	}
	
	static void dfs(int coreIdx, int coreCnt, int lineLen) {
		if(coreCnt + cores.size()-coreIdx < connected) {
			return;
		}
		if(coreIdx == cores.size()) {
			if(connected < coreCnt) {
				connected = coreCnt;
				min_len = lineLen;
			} else if(connected == coreCnt && min_len > lineLen) {
				min_len = lineLen;
			}
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			Point curr = cores.get(coreIdx);
			int currLen = mark(curr.y, curr.x, d);
			if(currLen == -1) continue;
			dfs(coreIdx+1, coreCnt+1, lineLen+currLen);
			unmark(curr.y, curr.x, d);
		}
		dfs(coreIdx+1, coreCnt, lineLen);
		
	}
	
	static int mark(int y, int x, int d) {
		int len = 0;
		int ny = y + dy[d];
		int nx = x + dx[d];
		while(inMap(ny, nx)) {
			if(map[ny][nx] == 1 || map[ny][nx] == -1) {
				for(int i = 1; i <= len; i++) {
					map[y+dy[d]*i][x+dx[d]*i] = 0;
				}
				return -1;
			}
			map[ny][nx] = -1;
			ny = ny + dy[d];
			nx = nx + dx[d];
			len++;
		}
		return len;
	}
	
	static void unmark(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		while(inMap(ny, nx)) {
			map[ny][nx] = 0;
			ny = ny + dy[d];
			nx = nx + dx[d];
		}
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
