import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] sum = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sum[i][j] = map[i][j];
					if(i > 0) sum[i][j] += sum[i-1][j];
					if(j > 0) sum[i][j] += sum[i][j-1];
					if(i > 0 && j > 0) sum[i][j] -= sum[i-1][j-1];
				}
			}
			
			int ans = 0;
			
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					int tmp = sum[i+M-1][j+M-1];
					if(i > 0) {
						tmp -= sum[i-1][j+M-1];
					}
					if(j > 0) {
						tmp -= sum[i+M-1][j-1];
					}
					if(j > 0 && i > 0) {
						tmp += sum[i-1][j-1];
					}
					ans = Math.max(ans, tmp);
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
}