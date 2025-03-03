import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int[] check;
	static StringTokenizer st;
	static int t1, t2, ans1, ans2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());
			
			graph = new int[V+1][2];
			check = new int[V+1];
			Arrays.fill(check, -1);
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(graph[p][0] != 0) {
					graph[p][1] = c;
				} else {
					graph[p][0] = c;
				}
			}
			
			ans1 = 0;
			ans2 = 0;
			findTarget(1);
			countSubtree(ans1);
			System.out.println("#"+test_case+" "+ans1+" "+ans2);
		}
	}
	static void findTarget(int p) {
		if(ans1 != 0 || check[p] != -1) return;
		
		if(p == t1 || p == t2) {
			check[p] = 1;
		} else if(graph[p][0] == 0) {
			check[p] = 0;
		} else if(graph[p][1] == 0) {
			if(check[graph[p][0]] == -1) findTarget(graph[p][0]);
			check[p] = check[graph[p][0]];
		} else {
			if(check[graph[p][0]] == -1) findTarget(graph[p][0]);
			if(check[graph[p][1]] == -1) findTarget(graph[p][1]);
			check[p] = check[graph[p][0]] + check[graph[p][1]];
			if(check[p] == 2 && ans1 == 0) {
				ans1 = p;
			}
		}
	}
	
	static void countSubtree(int e) {
		ans2++;
		if(graph[e][0] != 0) {
			countSubtree(graph[e][0]);
		}
		if(graph[e][1] != 0) {
			countSubtree(graph[e][1]);
		}
	}
}
