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
			
			boolean on = true;
			int num = M;
			for(int i = 0; i < N; i++){
				if(num % 2 == 0) {
					on = false;
					break;
				}
				num /= 2;
			}
			
			String ans = on ? "ON" : "OFF";
			System.out.println("#"+test_case + " " + ans);
		}
	}
}