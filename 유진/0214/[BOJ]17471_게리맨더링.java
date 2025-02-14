import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, ans = Integer.MAX_VALUE;
	static int[] pop;
	static ArrayList<Integer>[] adjList;
	static boolean[] area;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		pop = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0; j < k; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		
		area = new boolean[N];
		powerSet(0);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	
	static void powerSet(int idx) {
		if(idx == N) {
			if(isTwoArea()) {
				ans = Math.min(ans, diff());
			}
			return;
		}
		area[idx] = true;
		powerSet(idx+1);
		area[idx] = false;
		powerSet(idx+1);
	}
	
	static boolean isTwoArea() {
		int cnt = 0;
		boolean[] v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			if(!v[i]) {
				cnt++;
				v[i] = true;
				Queue<Integer> q = new ArrayDeque<>();
				q.offer(i);
				while(!q.isEmpty()) {
					int p = q.poll();
					for(int next: adjList[p]) {
						if(!v[next] && area[next] == area[i]) {
							v[next] = true;
							q.offer(next);
						}
					}
				}
			}
		}
		if(cnt == 2) {
			return true;
		}
		return false;
	}
	
	static int diff() {
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0; i < N; i++) {
			if(area[i]) {
				cnt1 += pop[i];
			} else {
				cnt2 += pop[i];
			}
		}
		return Math.abs(cnt1-cnt2);
	}
}