import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < R; i++) {
			for(int r = 0, c = 0; r < N/2 && c < M/2; r++, c++) {
				rotate(r, c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void rotate(int y, int x) {
		int start = map[y][x];
		int[] range = {M-x*2, N-y*2};

		for(int d = 0; d < 4; d++) {
			for(int i = 0; i < range[d%2]-1; i++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				map[y][x] = map[ny][nx];
				y = ny;
				x = nx;
			}
		}
		map[y+1][x] = start;
	}
}
