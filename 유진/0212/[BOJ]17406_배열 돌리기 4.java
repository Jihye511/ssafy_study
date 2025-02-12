import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, info;
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0; i < N; i++)	{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		info = new int[K][3];
		for(int i = 0; i < K; i++)	{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = new int[K]; 
		boolean[] used = new boolean[K];
		makeOrder(order, 0, used);
		
		System.out.println(ans);
	}
	
	static void makeOrder(int[] order, int idx, boolean[] used) {
		if(idx == K) {
			solve(order);
			return;
		}
		for(int i = 0; i < K; i++) {
			if(!used[i]) {
				used[i] = true;
				order[idx] = i;
				makeOrder(order, idx+1, used);
				used[i] = false;
			}
		}
	}
	
	static void solve(int[] order) {
		int[][] newArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			newArr[i] = arr[i].clone();
		}
		
		for(int i = 0; i < K; i++) {
			newArr = rotate(newArr, info[order[i]][0]-1, info[order[i]][1]-1, info[order[i]][2]);
		}
		
		for(int i = 0; i < N; i++)	{
			int tmp = 0;
			for(int j = 0; j < M; j++) {
				tmp += newArr[i][j];
			}
			ans = Math.min(ans, tmp);
		}
	}
	
	static int[][] rotate(int[][] arr, int r, int c, int s) {
		int y = r-s;
		int x = c-s;
		while(s > 0) {
			int start = arr[y][x];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 2*s; j++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					arr[y][x] = arr[ny][nx];
					y = ny;
					x = nx;
				}
			}
			arr[y][x+1] = start;
			y = y+1;
			x = x+1;
			s--;
		}
		return arr;
	}
}
