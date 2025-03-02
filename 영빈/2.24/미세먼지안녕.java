package boj;

import java.util.Scanner;

public class 미세먼지안녕 {
	static int R, C, T;
	static int[][] map, copy;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		int airP = 0;
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					airP = i;
				}
			}
		}
		
		
		
		
		for(int t = 0; t < T; t++) {
			
			copy = new int[R][C];
			copy[airP-1][0] = -1;
			copy[airP][0] = -1;
			
			for(int i = 0; i < R; i++) {				//확산
				for(int j = 0; j < C; j++) {
					if(map[i][j] > 0 ) {
						int mop = map[i][j]/5;
						copy[i][j] += map[i][j];

						for(int n = 0; n < 4; n++) {
							int nr = i + dr[n];
							int nc = j + dc[n];
							
							
							if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
								copy[nr][nc] += mop;
								copy[i][j] -= mop;
							}
							
						}
					}
				}
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					map[i][j] = copy[i][j];
				}
			}
			

			
			

			copy[airP-1][1] = 0;							//위 순환
			for(int n = 1; n < C - 1; n++) {
				copy[airP-1][n + 1] = map[airP-1][n];
			}
			
			for(int n = airP-1; n > 0; n--) {
				copy[n - 1][C-1] = map[n][C-1];
			}
			
			for(int n = C - 1; n > 0; n--) {
				copy[0][n - 1] = map[0][n];
			}
			
			for(int n = 0; n < airP - 2; n++) {
				copy[n + 1][0] = map[n][0];
			}
															//아래 순환
			
			copy[airP][1] = 0;							
			for(int n = 1; n < C - 1; n++) {
				copy[airP][n + 1] = map[airP][n];
			}
			
			for(int n = airP; n < R - 1; n++) {
				copy[n + 1][C-1] = map[n][C-1];
			}
			
			for(int n = C - 1; n > 0; n--) {
				copy[R-1][n - 1] = map[R-1][n];
			}
			
			for(int n = R-1; n > airP+1; n--) {
				copy[n - 1][0] = map[n][0];
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					map[i][j] = copy[i][j];
				}
			}
			

			
			
			
			
			
		}
		int ans = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans+2);
		
		
		

	}

}
