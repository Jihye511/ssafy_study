import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static int[][] map;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						ans++;
						
						Queue<Point> q = new ArrayDeque<>();
						q.offer(new Point(j, i));
						
						while(!q.isEmpty()) {
							Point p = q.poll();
							if(map[p.y][p.x] == 0) continue;
							map[p.y][p.x] = 0; 
							
							for(int d = 0; d < 4; d++) {
								int ny = p.y + dy[d];
								int nx = p.x + dx[d];
								if(0 > ny || ny >= N || 0 > nx || nx >= M) continue;
								if(map[ny][nx] == 1) {
									q.offer(new Point(nx, ny));
								}
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
