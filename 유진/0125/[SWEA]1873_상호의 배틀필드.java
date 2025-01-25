import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static char[][] map; 
	static int[] loc;
	static int dir;
	static int[] dy = {-1, 1, 0, 0}; 
	static int[] dx = {0, 0, -1, 1};
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int H = sc.nextInt();
        	int W = sc.nextInt();
        	
        	map = new char[H][W];
        	loc = new int[2];
        	dir = 0; // UDLR
        	
        	
        	for(int i = 0; i < H; i++) {
        		String temp = sc.next();
        		for(int j = 0; j < W; j++) {
        			map[i][j] = temp.charAt(j);
        			
        			// 전차 정보 저장 
        			if(map[i][j] == '^') {
        				loc[0] = i;
        				loc[1] = j;
        				dir = 0;
        			} else if (map[i][j] == 'v') {
        				loc[0] = i;
        				loc[1] = j;
        				dir = 1;
        			} else if (map[i][j] == '<') {
        				loc[0] = i;
        				loc[1] = j;
        				dir = 2;
        			} else if( map[i][j] == '>'){
        				loc[0] = i;
        				loc[1] = j;
        				dir = 3;
        			}
        		}
        	}
        	
        	int N = sc.nextInt();
        	String input = sc.next();
        	
        	for(int i = 0; i < N; i++) {
        		char c = input.charAt(i);
        		int dirNum = convert(c);
        		int ny, nx;
        		
        		if(dirNum == 4) { // Shoot
        			ny = loc[0] + dy[dir];
        	    	nx = loc[1] + dx[dir];
        	    	
        	    	while(inMap(ny, nx)) {
        				if(map[ny][nx] == '#') {
        					break;
        				}
        				if(map[ny][nx] == '*') {
        					map[ny][nx] = '.';
        					break;
        				}
        				ny = ny + dy[dir];
            	    	nx = nx + dx[dir];
        			}
        		} else { // Move
        			ny = loc[0] + dy[dirNum];
        	    	nx = loc[1] + dx[dirNum];
        	    	
        	    	if(canGo(ny, nx, dirNum)) go(ny, nx, dirNum);
        	    	else go(loc[0], loc[1], dirNum);
        		}
        	}
        	
            System.out.print("#"+ test_case+" ");
            for(int i = 0; i < H; i++) {
        		for(int j = 0; j < W; j++) {
        			System.out.print(map[i][j]);
        		}
        		System.out.println();
        	}
        }
    }
    
    public static boolean inMap(int y, int x) {
    	return (0 <= y && y < map.length && 0 <= x && x < map[0].length);
    }
    
    public static boolean canGo(int ny, int nx, int d) {    	
    	// 범위 내 & 평지 
        return (0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length && map[ny][nx] == '.');
    }
    
    public static void go(int ny, int nx, int d) {    	
    	// 맵 갱신 
    	map[loc[0]][loc[1]] = '.';
    	
    	switch(d) {
    	case 0:
    		map[ny][nx] = '^'; break;
    	case 1:
    		map[ny][nx] = 'v'; break;
    	case 2:
    		map[ny][nx] = '<'; break;
    	case 3:
    		map[ny][nx] = '>'; break;	
    	}
    	
    	
    	// 전차 정보 갱신 
		loc[0] = ny;
		loc[1] = nx;
		dir = d;
    }
    
    public static int convert(char c) {
    	switch (c) {
		case 'U':
			return 0;
		case 'D':
			return 1;
		case 'L':
			return 2;
		case 'R':
			return 3;
		default:
			return 4;
    	}
    }
}