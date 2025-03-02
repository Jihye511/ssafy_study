import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());	
			graph = new int[N+1][3];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int curr = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				graph[curr][0] = c;
				if(st.hasMoreTokens()) {
					graph[curr][1] = Integer.parseInt(st.nextToken());
				}
				if(st.hasMoreTokens()) {
					graph[curr][2] = Integer.parseInt(st.nextToken());
				}
			}
			sb = new StringBuilder("#" + test_case + " ");
			print(1);
			System.out.println(sb);
		}
	}
	static void print(int curr) {
		if(graph[curr][1] != 0) {
			print(graph[curr][1]);
		}
		sb.append((char)graph[curr][0]);
		if(graph[curr][2] != 0) {
			print(graph[curr][2]);
		}
	}
}
