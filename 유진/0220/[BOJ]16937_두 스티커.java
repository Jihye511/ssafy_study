import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, H, W, ans;
	static int[] selected, paper = new int[2];
	static int[][] size;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		paper[0] = Integer.parseInt(st.nextToken()); // 높이
		paper[1] = Integer.parseInt(st.nextToken()); // 너비
		
		N = Integer.parseInt(br.readLine());
		size = new int[2][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			size[1][i] = Integer.parseInt(st.nextToken()); 
			size[0][i] = Integer.parseInt(st.nextToken()); 
		}

		ans = 0;
		selected = new int[2];
		selectTwo(0, 0);
		System.out.println(ans);
	}
	
	static void selectTwo(int idx, int start) {
		if(idx == 2) {
			if(check(0, 0, 0) || check(0, 0, 1)
				|| check(0, 1, 0) || check(0, 1, 1)
				|| check(1, 0, 0) || check(1, 0, 1)
				|| check(1, 1, 0) || check(1, 1, 1))
			{
				int totalSize = size[0][selected[0]]*size[1][selected[0]] + size[0][selected[1]]*size[1][selected[1]];
				ans = Math.max(ans, totalSize);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[idx] = i;
			selectTwo(idx+1, i+1);
		}
	}
	
	static boolean check(int a, int b, int c) {
		return size[a][selected[0]]+size[b][selected[1]] <= paper[c] && 
				Math.max(size[(a+1)%2][selected[0]], size[(b+1)%2][selected[1]]) <= paper[(c+1)%2];
	}
}
