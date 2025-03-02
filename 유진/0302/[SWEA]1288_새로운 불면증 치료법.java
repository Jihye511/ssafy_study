import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());			
			int num = N;
			int check = 0;
			int cnt = 0;
			
			while(check != (1<<10)-1) {
				cnt++;
				num = cnt * N;
				
				while(num > 0) {
					check = check | (1 << (num%10));
					num = num/10;
				}
			}
			System.out.println("#"+test_case + " " + N*cnt);
		}
	}
}