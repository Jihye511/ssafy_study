import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N;
		N = sc.nextInt();

		int[] time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}

		Arrays.sort(time);
				
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			ans += (N-i) * time[i];
		}
		
		System.out.println(ans);
		
	}

}
