package boj;

import java.util.Scanner;

public class 두스티커 {
	static int[] R, C;
	static boolean[] v;
	static int[] sticker;
	static int H, W, N, max;;
	static int[][] map;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		N = sc.nextInt();
		
		R = new int[N];
		C = new int[N];
		v = new boolean[N];
		sticker = new int[2];
		map = new int [H][W];
		max = 0;
		
		for(int i = 0; i < N; i++) {
			R[i] = sc.nextInt();
			C[i] = sc.nextInt();
		}
		
		
		perm(0, 0);
		System.out.println(max);
		

	}

	private static void perm(int dep, int start) {
		if(dep == 2) {
			
			attach(sticker[0], sticker[1]);
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(v[i])continue;
			v[i] = true;
			sticker[dep] = i;
			perm(dep+1, i + 1);
			v[i] = false;
		}
		
		
		
	}

	private static void attach(int x1, int x2) {
		int subx1 = R[x1];
		int suby1 = C[x1];
		int subx2 = R[x2];
		int suby2 = C[x2];
		
		if(subx1 + subx2 <= H && suby1 <= W && suby2 <= W) {//위아래로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		if(suby1 + suby2 <= W && subx1 <= H && subx2 <= H) {//좌우로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		
		subx1 = C[x1]; //1번 스티커만 90도회전
		suby1 = R[x1];
		
		if(subx1 + subx2 <= H && suby1 <= W && suby2 <= W) {//위아래로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		if(suby1 + suby2 <= W && subx1 <= H && subx2 <= H) {//좌우로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		
		subx1 = R[x1]; //2번 스티커만 90도 회전
		suby1 = C[x1];
		subx2 = C[x2];
		suby2 = R[x2];
		
		if(subx1 + subx2 <= H && suby1 <= W && suby2 <= W) {//위아래로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		if(suby1 + suby2 <= W && subx1 <= H && subx2 <= H) {//좌우로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		
		subx1 = C[x1]; //싹 다 90도 회전~
		suby1 = R[x1];
		subx2 = C[x2];
		suby2 = R[x2];
		if(subx1 + subx2 <= H && suby1 <= W && suby2 <= W) {//위아래로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
		if(suby1 + suby2 <= W && subx1 <= H && subx2 <= H) {//좌우로 붙일 수 있다면
			max = Integer.max(max, (subx1 * suby1) + (subx2 * suby2)); 
		}
	}
	
}
