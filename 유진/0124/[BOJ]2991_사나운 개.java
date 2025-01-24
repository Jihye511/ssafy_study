import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] time = new int[3];
		
		for(int i = 0; i < 3; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 3; i++) {
			int cnt = 0;
			
			if(time[i] % (A+B) > 0 && time[i] % (A+B) <= A) {
				cnt++;
			}
			if(time[i] % (C+D) > 0 && time[i] % (C+D) <= C) {
				cnt++;
			}
			
			System.out.println(cnt);
		}
	}
}
