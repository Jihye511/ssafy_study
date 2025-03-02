package algorithm_study;
import java.io.*;
import java.util.*;
public class BOJ_16926_배열돌리기1 {
	static int N,M,R;
	static int[][] map;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int size = Math.min(N, M)/2;
		while(R-->0) {
			for(int i =0; i<size; i++) {
				rotate(0+i,0+i ,N-1-i,0+i, N-1-i,M-1-i, 0+i, M-1-i);
			}
		}
		
		for(int[] r : map) {
			for(int v: r) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void rotate(int fr, int fc, int sr,int sc, int tr, int tc, int lr,int lc ) {

		int temp;
		int before = map[fr][fc];
		//위 -> 아래
		for(int i =fr+1; i<=sr; i++ ) {
			
			temp = map[i][fc];
			map[i][fc] = before;
			before = temp;
		}
		//왼 - > 오
		for(int i = sc+1; i<=tc; i++) {
			temp = map[sr][i];
			map[sr][i] = before;
			before = temp;
		}
		//아래 -> 위
		for(int i = tr-1; i>=lr; i--) {
			temp = map[i][tc];
			map[i][tc] = before;
			before = temp;
		}
		//오 - > 왼
		for(int i=lc-1; i>=fc; i--) {
			temp = map[lr][i];
			map[lr][i]=before;
			before = temp;
		}
		
	}

}
