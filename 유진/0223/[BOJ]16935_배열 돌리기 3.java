import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map, newMap;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			int type = Integer.parseInt(st.nextToken());
			switch(type) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			default:
				rotate6();
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < newMap.length; i++) {
			for(int j = 0; j < newMap[0].length; j++) {
				sb.append(newMap[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void rotate1() {
		newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[N-i-1][j];
			}
		}
		map = newMap;
	}
	static void rotate2() {
		newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[i][M-j-1];
			}
		}
		map = newMap;
	}
	static void rotate3() {
		N = map[0].length;
		M = map.length;
		newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[M-j-1][i];
			}
		}
		map = newMap;
	}
	static void rotate4() {
		N = map[0].length;
		M = map.length;
		newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[j][N-i-1];
			}
		}
		map = newMap;
	}
	static void rotate5() {
		newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N/2 && j < M/2) {
					newMap[i][j] = map[i+N/2][j];
				} else if(i < N/2 && j >= M/2) {
					newMap[i][j] = map[i][j-M/2];
				} else if(i >= N/2 && j >= M/2) {
					newMap[i][j] = map[i-N/2][j];
				} else {
					newMap[i][j] = map[i][j+M/2];
				}
			}
		}
		map = newMap;
	}
	static void rotate6() {
		newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N/2 && j < M/2) {
					newMap[i][j] = map[i][j+M/2];
				} else if(i < N/2 && j >= M/2) {
					newMap[i][j] = map[i+N/2][j];
				} else if(i >= N/2 && j >= M/2) {
					newMap[i][j] = map[i][j-M/2];
				} else {
					newMap[i][j] = map[i-N/2][j];
				}
			}
		}
		map = newMap;
	}
}
