import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer> code;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());	
			code = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int c = Integer.parseInt(st.nextToken());
				code.add(c);
			}
			
			int M = Integer.parseInt(br.readLine());	
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				char c = st.nextToken().charAt(0);
				command(c);
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#"+test_case);
			for(int i = 0; i < 10; i++	) {
				sb.append(" " + code.get(i));
			}
			System.out.println(sb);
		}
	}
	static void command(char c) {
		int x, y;
		switch(c) {
		case 'I':
			x = Integer.parseInt(st.nextToken());
			ArrayList<Integer> tmp = new ArrayList<>();
			y = Integer.parseInt(st.nextToken());
			for(int i = 0; i < y; i++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			code.addAll(x, tmp);
			break;
		case 'D':
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for(int i = 0; i < y; i++) {
				code.remove(x+1);
			}
			break;
		default:
			y = Integer.parseInt(st.nextToken());
			ArrayList<Integer> tmp2 = new ArrayList<>();
			for(int i = 0; i < y; i++) {
				tmp2.add(Integer.parseInt(st.nextToken()));
			}
			code.addAll(tmp2);
			break;
		}
	}
}
