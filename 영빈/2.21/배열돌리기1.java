package boj;

import java.util.Scanner;

public class 배열돌리기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		int[][] map = new int[N+1][M+1];
		int[][] copy = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		} 
		int x, y;
		if(N%2 == 0) {
			x = N/2;
		}else x = (N-1)/2;
		
		if(M%2 == 0) {
			y = M/2;
		}else y = (M-1)/2;
		
		int cycle = Integer.min(x, y);
		
		for(int r = 0; r < R; r++) {
			int num = 0;

			 //&& j <= y
			while(num < cycle) {
				for(int i = 1 + num; i < N - num; i++) {
					copy[i + 1][1 + num] = map[i][1 + num];
				} 
				
				for(int j = 1 + num; j < M - num; j++) {
					copy[N - num][j + 1] = map[N - num][j];
				} 
				
				for(int i = N - num; i > 1 + num; i--) {
					copy[i - 1][M - num] = map[i][M - num];
				} 
				
				for(int j = M - num; j > 1 + num; j--) {
					copy[1 + num][j - 1] = map[1 + num][j];
				} 
				
				num++;
			}
			
			
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					map[i][j] = copy[i][j];
				}
			} 
			
			//System.out.println();
			
			
			
			
			
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		} 
		
		
		

	}

}
