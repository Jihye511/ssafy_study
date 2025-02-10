import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		System.out.println(ans);
	}
	static void dfs(int y, int x, int state) {
		if(y == N-1 && x == N-1) {
			ans++;
			return;
		}
		if(state == 0) {
			if(canGo(y, x+1)) dfs(y, x+1, 0);
			if(canGo(y+1, x+1) && canGo(y, x+1) && canGo(y+1, x)) dfs(y+1, x+1, 2);
		} else if(state == 1) {
			if(canGo(y+1, x)) dfs(y+1, x, 1);
			if(canGo(y+1, x+1) && canGo(y, x+1) && canGo(y+1, x)) dfs(y+1, x+1, 2);
		} else if(state == 2) {
			if(canGo(y, x+1)) dfs(y, x+1, 0);
			if(canGo(y+1, x)) dfs(y+1, x, 1);
			if(canGo(y+1, x+1) && canGo(y, x+1) && canGo(y+1, x)) dfs(y+1, x+1, 2);
		}
	}
	static boolean canGo(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N && map[y][x] == 0;
	}
}