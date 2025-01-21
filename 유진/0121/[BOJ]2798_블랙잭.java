import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();

		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		/*
		 * N장에서 3장 선택하여 합이 M에 최대한 가깝게
		 */
		int ans = 0;
		
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					int currSum = cards[i] + cards[j] + cards[k];
					if(currSum <= M && M-ans > M-currSum) {
						ans = currSum;
					}
				}
			}
		}

		System.out.println(ans);
		
	}

}
