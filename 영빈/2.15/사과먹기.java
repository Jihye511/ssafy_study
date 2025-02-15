package swea;

import java.util.Scanner;

public class 사과먹기 {
	static int[][] map;
	static int apples;
	static int now_x, now_y;
	static int dir; //0은 오른쪽, 1은 아래, 2는 왼쪽, 3은 위쪽
	static int turn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++ ) {
			apples = 0;
			now_x = 0;
			now_y = 0;
			dir = 0;
			turn = 0;
			
			int N = sc.nextInt();
			
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) apples++;
				}
			}
			for(int a = 1; a <= apples; a++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(map[i][j] == a) {
							eat(i, j);
						}
						
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, turn);
		}
		
		
	}
	
	
	static void eat(int x, int y) {
		
		
		if(x < now_x && y > now_y) {	//사과가 1사분면에 있을때
			if(dir == 0) {
				while(now_y < y + 1) now_y++;
				dir++;
				turn++;
				now_x++;
				dir++;
				turn++;
				dir++;
				turn++;
				while(now_x > x) now_x--;
			}
			else if(dir == 1) {
				now_x++;
				dir++;
				turn++;
				now_y--;
				dir++;
				turn++;
				while(now_x > x) now_x--;
				dir = 0;
				turn++;
				while(now_y < y) now_y++;

			}
			else if(dir == 2) {
				now_y--;
				turn++;
				dir++;
				while(now_x > x)now_x--;
				turn++;
				dir=0;
				while(now_y < y)now_y++;
				
			}
			else if(dir == 3) {
				while(now_x > x - 1) now_y--;
				dir = 0;
				turn++;
				now_y++;
				dir++;
				turn++;
				now_x++;
				dir++;
				turn++;
				while(now_y > y) now_y--;
			}
			
		}
		else if(x < now_x && y < now_y) { //사과가 2사분면에 있을때
			if(dir == 0) {
				now_y++;
				dir++;
				turn++;
				now_x++;
				dir++;
				turn++;
				while(now_y > y) now_y--;
				turn++;
				dir++;
				while(now_x > x) now_x--;
				
			}
			else if(dir == 1) {
				now_x++;
				dir++;
				turn++;
				while(now_y > y) now_y--;
				turn++;
				dir++;
				while(now_x > x) now_x--;
			}
			else if (dir == 2) {
				while(now_y > y) now_y--;
				turn++;
				dir++;
				while(now_x > x) now_x--;
			}
			else if (dir == 3) {
				while(now_x > x - 1) now_x--;
				turn++;
				dir = 0;
				now_y++;
				turn++;
				dir++;
				turn++;
				dir++;
				while(now_y > y) now_y--;
			}
		}
		else if(x > now_x && y < now_y) { //사과가 3사분면에 있을때
			if(dir == 0) {
				now_y++;
				turn++;
				dir++;
				while(now_x < x)now_x++;
				turn++;
				dir++;
				while(now_y > y)now_y--;
				
			}
			else if(dir == 1) {
				while(now_x < x) now_x++;
				dir++;
				turn++;
				while(now_y > y) now_y--;
			}
			else if (dir == 2) {
				while(now_y > y - 1)now_y--;
				turn++;
				dir++;
				now_x--;
				turn++;
				dir=0;
				now_y++;
				turn++;
				dir++;
				while(now_x < x) now_x++;
			}
			else if (dir == 3) {
				now_x--;
				dir = 0;
				turn++;
				now_y++;
				dir++;
				turn++;
				while(now_x < x) now_x++;
				dir++;
				turn++;
				while(now_y > y) now_y--;
			}
		}
		else if(x > now_x && y > now_y) { //사과가 4사분면에 있을때
			if(dir == 0) {
				while(now_y < y) now_y++;
				dir++; //턴
				turn++;
				while(now_x < x) now_x++;
			}
			else if(dir == 1) {
				while(now_x < x + 1) now_x++;
				dir++;
				turn++;
				now_y--;
				turn++;
				dir++;
				now_x--;
				dir = 0;
				turn++;
				while(now_y < y) now_y++;
			}
			else if(dir == 2) {
				now_y--;
				dir++;
				turn++;
				now_x--;
				dir=0;
				turn++;
				while(now_y < y) now_y++;
				turn++;
				dir++;
				while(now_x < x) now_x++;
			}
			else if(dir == 3) {
				now_x--;
				dir = 0;
				turn++;
				dir++;
				now_y++;
				turn++;
				while(now_x < x) now_x++;
			}
		}
		
	}

}
