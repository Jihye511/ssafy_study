package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 로마숫자만들기 {
	static int num;
	static int[] arr = {1, 5, 10, 50};
	static Set<Integer> S = new HashSet<>(); 
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		dfs(0, 0, 0);
		System.out.println(S.size()); 
		sc.close();
		
		
	}
	
	static void dfs(int sum, int depth, int start) {
		if(depth == num) {
			S.add(sum);
			return;
		}
		
		
		
		
		for(int i = start; i < 4; i++) {
			dfs(sum + arr[i], depth + 1, i);
		}
		
	}

}
