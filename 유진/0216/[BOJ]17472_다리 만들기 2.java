import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static class Bridge implements Comparable<Bridge>{
			int e, d;
			Bridge(int e, int d){
				this.e = e;
				this.d = d;
			}
			@Override
			public int compareTo(Bridge o) {
				return Integer.compare(this.d, o.d);
			}
			
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬 번호 붙이기 
		int islandCnt = 1;
		boolean[][] v = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					Queue<Point> q = new ArrayDeque<>();
					q.offer(new Point(j, i));
					v[i][j] = true;
					map[i][j] = islandCnt;
					while(!q.isEmpty()) {
						Point p = q.poll();
						for(int d = 0; d < 4; d++) {
							int ny = p.y + dy[d];
							int nx = p.x + dx[d];
							if(inMap(ny, nx) && map[ny][nx] == 1 && !v[ny][nx]) {
								q.offer(new Point(nx, ny));
								v[ny][nx] = true;
								map[ny][nx] = islandCnt;
							}
						}
					}
					islandCnt++;
				}
			}
		}
		
		// 가능한 모든 다리 리스트 
		ArrayList<Bridge>[] adjList = new ArrayList[islandCnt];
		for(int i = 0; i < islandCnt; i++) {
			adjList[i] = new ArrayList();
		}
		
		// 가로 다리 찾기 
		for(int i = 0; i < N; i++) {
			int prev = map[i][0];
			int bridgeLen = 0;
			int start = prev;
			for(int j = 0; j < M; j++) {
				if(prev != map[i][j]) { 
					if(prev != 0) { // 섬 -> 바다 
						start = prev;
						bridgeLen = 1;
					} else if(start != 0 && prev == 0 && bridgeLen >= 2){ // 바다 -> 섬 
						adjList[start].add(new Bridge(map[i][j], bridgeLen));
						adjList[map[i][j]].add(new Bridge(start, bridgeLen));
					}
					prev = map[i][j];
				}
				else if(map[i][j] == 0) {
					bridgeLen++;
				}
			}
		}
		
		// 세로 다리 찾기 
		for(int j = 0; j < M; j++) {
			int prev = map[0][j];
			int bridgeLen = 0;
			int start = prev;
			for(int i = 0; i < N; i++) {
				if(prev != map[i][j]) { 
					if(prev != 0) { // 섬 -> 바다 
						start = prev;
						bridgeLen = 1;
					} else if(start != 0 && prev == 0 && bridgeLen >= 2){ // 바다 -> 섬 
						adjList[start].add(new Bridge(map[i][j], bridgeLen));
						adjList[map[i][j]].add(new Bridge(start, bridgeLen));
					}
					prev = map[i][j];
				}
				else if(map[i][j] == 0) {
					bridgeLen++;
				}
			}
		}
		
		// 최소신장트리 
		// 1번 섬부터 시작 
		if(adjList[1].isEmpty()) {
			System.out.println(-1);
			return;
		}
		
		Queue<Bridge> pq = new PriorityQueue<>();
		pq.offer(new Bridge(1, 0));
		boolean[] mst_v = new boolean[islandCnt];
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Bridge b = pq.poll();
			if(mst_v[b.e]) continue;
			mst_v[b.e] = true;
			ans += b.d;
			
			for(Bridge next: adjList[b.e]) {
				if(!mst_v[next.e]) {
					pq.offer(next);
				}
			}
		}
		
		// 방문하지 않은 섬이 존재하면 -1 
		for(int i = 1; i < islandCnt; i++) {
			if(!mst_v[i]) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static boolean inMap(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
