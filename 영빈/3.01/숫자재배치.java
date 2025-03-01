package boj;

import java.util.Scanner;

public class 숫자재배치 {
	static int[] arr;
	static boolean[] v;
	static int B, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int N = str.length();
		
		arr = new int[N];
		v = new boolean[N];
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		B = sc.nextInt();
		C = -1;
		
		perm(0, N, 0);
		System.out.println(C);
		
	}
	
	
	
	static void perm(int dep, int N, int sum) {
		
		if(dep == N) {
			if(sum < B && sum > Math.pow(10, N - 1)) {
				C = Math.max(C, sum);
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			int temp = (int) (arr[i] * Math.pow(10, dep));

			perm(dep + 1, N, sum + temp);
			v[i] = false;
		}
		
	}

}
