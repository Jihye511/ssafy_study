import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, M, L;
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		int[] ball = new int[N];
		
		int currIdx = 0;
		int cnt = 0;
		
		while(true) {
			ball[currIdx] += 1;
			
			if(ball[currIdx] == M) {
				break;
			}
			
			if(ball[currIdx] % 2 == 0) {
				currIdx = (N+currIdx-L)%N;
			} else {
				currIdx = (L+currIdx+N)%N;
			}
			cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
