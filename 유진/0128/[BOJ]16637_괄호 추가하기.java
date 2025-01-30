import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, ans = Integer.MIN_VALUE;
	static boolean[] prior, v;
	static int[] nums;
	static char[] op;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		nums = new int[n/2+1];
		op = new char[n/2];
		for(int i = 0; i < n; i+=2) {
			nums[i/2] = s.charAt(i)-'0';
		}
		for(int i = 1; i < n; i+=2) {
			op[i/2] = s.charAt(i);
		}
		
		prior = new boolean[n/2];
		priorOp(0);
		System.out.println(ans);
	}
	
	static void priorOp(int k) {
		if(k == n/2) {
			ans = Math.max(ans, solve());
			return;
		}
		
		priorOp(k+1); // op[k]의 우선 여부: false
		if(k > 0 && prior[k-1] == false) {
			prior[k] = true;
			priorOp(k+1);  // op[k]의 우선 여부: true
			prior[k] = false;
		}
	}
	
	static int solve() {
		int[] arr = Arrays.copyOf(nums, n/2+1);
		// 우선순위 연산부터
		for(int i = 1; i < n/2; i++) {
			if(prior[i]) {
				int res = calc(arr[i], arr[i+1], op[i]);
				arr[i] = res;
				arr[i+1] = res;
			}
		}
		
		// 나머지 연산 순서대로 
		for(int i = 0; i < n/2; i++) {
			if(!prior[i]) {
				int res = calc(arr[i], arr[i+1], op[i]);
				arr[i] = res;
				arr[i+1] = res;
				if(i < n/2-1 && prior[i+1]) {
					arr[i+2] = res;
				}
			}
		}
		return arr[n/2];
	}
	
	static int calc(int a, int b, char o) {
		switch(o) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		}
		return -1;
	}
}
