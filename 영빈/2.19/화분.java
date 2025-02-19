package algo_Test;

import java.util.Scanner;

public class 화분 {
	static int N, P;
	static int[] bi1, bi2, plant;
	static int ans1 = 0;
	static int ans2 = 0;
	static int ans = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			P = sc.nextInt();
			bi1 = new int[N];
			bi2 = new int[N];
			for(int i = 0; i < N; i++) {
				bi1[i] = sc.nextInt();
			}
			for(int i = 0; i < N; i++) {
				bi2[i] = sc.nextInt();
			}
			ans=0;
			
			
			per(1, true, bi1[0]);
			per(1, false, bi2[0]);
			System.out.printf("#%d %d\n", t, ans);
			
			
			
			
		}
	}
	
	static void per(int dep, boolean v, int sum) {
		if(dep == N) {
			ans = Math.max(ans, sum);
			return;
		}
		
		
		if(v) {//전에 뿌린 비료가 1번 비료라면
			
			per(dep+1, true, sum + bi1[dep]-P);
			per(dep+1, false, sum + bi2[dep]);
		}
		else if(!v){//전에 뿌린 비료가 2번 비료라면
			per(dep+1, true, sum + bi1[dep]);
			per(dep+1, false, sum + bi2[dep]-P);
		}
		
		
	}
}
