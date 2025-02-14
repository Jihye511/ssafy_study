package boj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게리맨더링 {
	
	
	static int[][] map;
	static int[] pop;
	static int N;
	static int diff = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		pop = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			pop[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			int temp = sc.nextInt();
			
			for(int j = 1; j <= temp; j++) {
				int y = sc.nextInt();
				map[i][y] = 1;
				map[y][i] = 1;
			}
		}
		
		pS(1, new boolean[N+1]);
		System.out.println(diff == Integer.MAX_VALUE ? -1 : diff);
						
	}
	
	private static void pS(int idx, boolean[] sel) {
		if(idx==N+1) {
			
			if(check(sel)) {
				// 각구역이 연결되어 있다면
				int sumA =0, sumB = 0;
				for (int i = 1; i < N+1; i++) {
					if(sel[i]) sumA += pop[i];
					else sumB += pop[i];
				}
				diff = Math.min(diff, Math.abs(sumA-sumB));
			}
			return;
		}
		
		sel[idx] = true;
		pS(idx+1,sel);
		sel[idx] = false;
		pS(idx+1,sel);
	}
	
	private static boolean check(boolean[] sel) {
		// 두 선거구가 연결되었는지 확인
		ArrayList<Integer> areaA = new ArrayList<>();
		ArrayList<Integer> areaB = new ArrayList<>();
		for (int i = 1; i < sel.length; i++) {
			if(sel[i]) areaA.add(i);
			else areaB.add(i);
		}
		// 두선거구의 구역의 숫자가 o 이면 안되요
		if(areaA.size() ==0 || areaB.size()==0) return false;
		
		// 연결확인
		boolean[] v = new boolean[N+1];
		dfs(areaA, areaA.get(0),v);
		dfs(areaB, areaB.get(0),v);
		
		for (int i = 1; i < v.length; i++) {
			if(!v[i]) return false;
		}	
		return true;
	}
	
	private static void dfs(ArrayList<Integer> area, Integer idx, boolean[] v) {
		v[idx] = true;
		for (int i = 0; i < area.size(); i++) {
			if(map[idx][area.get(i)]==1&&!v[area.get(i)]) {
				dfs(area,area.get(i),v);
			}
		}
	}
	
	

	
}
