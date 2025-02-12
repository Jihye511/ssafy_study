package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class 배열돌리기4 {
static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
static int N, M, K;
static int[][] map;
public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    map = new int[N + 1][M + 1];
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            map[i][j] = sc.nextInt();
        }
    }
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < K; i++) {
        int r = sc.nextInt();
        int c = sc.nextInt();
        int s = sc.nextInt();
        
        turn(r, c, s);
 
    }
    
    
    
    for(int i = 1; i <= N; i++) {
        int temp = 0;

        for(int j = 1; j <= M; j++) {
            temp += map[i][j];
            
        }
        min = Math.min(min, temp);
    }
    System.out.println(min);
    sc.close();
    
}

static void turn(int r, int c, int s) {
    
	int[][] copy = new int[N + 1][M + 1];
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            copy[i][j] = map[i][j];
        }
    }
	ArrayList<Integer> list = new ArrayList<>();
	for(int k = 1; k <= s; k++) 
	{

		for(int i = 1; i <= k*2; i++) {
			list.add(map[r-k][c-k + i]);
		
		}
		for(int i = 1; i <= k*2; i++) {
			list.add(map[r-k + i][c+k]);
		
		}
		for(int i = 1; i <= k*2; i++) {
			list.add(map[r+k][c+k - i]);
		
		}
		for(int i = 1; i <= k*2; i++) {
			list.add(map[r+k - i][c-k]);
		
		}
		
		int be = 0;

		list.add(0, list.getLast());
		
		for(int i = 1; i <= k*2; i++) {
			copy[r-k][c-k + i] = list.get(be++);
		
		}
		for(int i = 1; i <= k*2; i++) {
			copy[r-k + i][c+k] = list.get(be++);
		
		}
		for(int i = 1; i <= k*2; i++) {
			copy[r+k][c+k - i] = list.get(be++);
		
		}
		for(int i = 1; i <= k*2; i++) {
			copy[r+k - i][c-k] = list.get(be++);
		
		}
		list.clear();
	}
	
	for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            map[i][j] = copy[i][j];
        }
    	}
	
	
	
	}
}

