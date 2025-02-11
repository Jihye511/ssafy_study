import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] results;
	static int N, ans, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		results = new int[N][9];
		for(int i = 0; i < N; i++)	{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				results[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = new int[9]; 
		boolean[] used = new boolean[9];
		used[0] = true;
		makeOrder(order, 0, used);
		
		System.out.println(ans);
	}

	static void makeOrder(int[] order, int idx, boolean[] used) {
		if(idx == 9) {
			play(order);
			return;
		}
		if(idx == 3) {
			makeOrder(order, idx+1, used);
		}
		else {
			for(int i = 0; i < 9; i++) {
				if(!used[i]) {
					order[idx] = i;
					used[i] = true;
					makeOrder(order, idx+1, used);
					used[i] = false;
				}
			}
		}
	}
	
	static void play(int[] players) {
		int playerIdx = 0;
		int inning = 0;
		int score = 0;
		while(inning < N) {
			int[] base = new int[4]; //0, 1, 2루, 3홈
			int out = 0;
			while(out < 3) {
				playerIdx = (playerIdx + 9) % 9;
				int res = results[inning][players[playerIdx]];
				if(res == 0) out++;
				else base = move(base, res);
				score += base[3];
				base[3] = 0;
				playerIdx++;
			}
			inning++;
		}
		ans = Math.max(score, ans);
	}
	
	static int[] move(int[] base, int hit) {
		if(hit == 1) {
			for(int i = 3; i > 0; i--) {
				base[i] = base[i-1];
			}
			base[0] = 1;
		} else if (hit == 2) {
			base[3] = base[2] + base[1];
			base[2] = base[0];
			base[1] = 1;
			base[0] = 0;
		} else if (hit == 3) {
			base[3] = base[2] + base[1] + base[0];
			base[2] = 1;
			base[1] = 0;
			base[0] = 0;
		} else {
			base[3] = base[2] + base[1] + base[0] + 1;
			base[2] = 0;
			base[1] = 0;
			base[0] = 0;
		}
		return base;
	}
}
