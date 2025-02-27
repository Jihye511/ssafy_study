package algo_Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 뱀 {
	
	static int[][] map;
	static class Bam{
		int r;
		int c;
		int d;
		
		public Bam(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static class Tail{
		int r;
		int c;
		
		public Tail(int r, int c) {
			this.r = r;
			this.c = c;
			
		}
	}
	static int N, K, L;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] arr1;
	static char[] arr2;

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][N + 1];
		
		for(int k = 0; k < K; k++) {			
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 2; // 1은 자기 몸, 2는 사과
		}
		L = sc.nextInt();
		sc.nextLine(); // 개행문자 제거
		
		String[] temp;
		arr1 = new int[L];
		arr2 = new char[L];

		for(int l = 0; l < L; l++) {
			temp = sc.nextLine().split(" ");
			arr1[l] = Integer.parseInt(temp[0]);
			arr2[l] = temp[1].charAt(0);
		}
		
		int o = 0;
		
		Bam bam = new Bam(1, 1, 1); // r, c, len, d;
		Queue<Tail> q = new ArrayDeque<>();
		q.add(new Tail(1, 1));
		int time = 1;
		
		while(true) {			//게임 시작
			
			map[bam.r][bam.c] = 1;
			int nr = bam.r + dr[bam.d];
			int nc = bam.c + dc[bam.d];

			
			if(nr > N || nc > N || nr <= 0 || nc <= 0 || map[nr][nc] == 1) {
				break;
			}
			
			//일단 꼬리를 늘리고 사과가 없다면 줄인다
			q.add(new Tail(nr, nc));
			
			if(map[nr][nc] == 0) {
				Tail tail = q.poll();
				map[tail.r][tail.c] = 0; 
			}
			
			if(o < L && time == arr1[o]) {
				if(arr2[o] == 'D') {
					bam.d = (bam.d + 1)%4;
				}
				else {
					bam.d = bam.d - 1;
					if(bam.d < 0) {
						bam.d = 3;
					}
				}
				o++;
			}
			
			
			// 이동 후 새로운 위치로 업데이트 필요
			bam.r = nr;
			bam.c = nc;

			time++;
		}
		
		System.out.println(time);
		
	}

}
