import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int ans;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		check = new boolean[n*50+1];
		solve(n, 0, new int[4]);
		System.out.println(ans);
	}
	static void solve(int n, int idx, int[] arr) {
		if(idx == 3) {
			arr[3] = n;
			int num = arr[0] + arr[1]*5 + arr[2]*10 + arr[3]*50;
			if(!check[num]) {
				ans +=1;
				check[num] = true;
			}
			return;
		}
		for(int i = 0; i <= n; i++){
			arr[idx] = i;
			solve(n-i, idx+1, arr);
		}
	}
}