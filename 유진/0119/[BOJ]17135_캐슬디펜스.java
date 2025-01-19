import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.awt.Point;

class Main {
	
	public static int dist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	public static int game(Point a, Point b, Point c, int d) {
		int cnt = 0;
		
		ArrayList<Point> e = new ArrayList<>();
        for (Point p : enemy) {
        	e.add(new Point(p.x, p.y));
        }
		
        int distA, distB, distC;
        Point[] targets = new Point[3];
        
        while(true) {
        	distA = Integer.MAX_VALUE; 
        	distB = Integer.MAX_VALUE; 
        	distC = Integer.MAX_VALUE;
        	targets[0] = null;
        	targets[1] = null; 
        	targets[2] = null;
        	
        	for(Point p: e) {
        		if(dist(p, a) <= d) {
        			if(dist(p, a) < distA || (dist(p, a) == distA && p.x < targets[0].x) ) {
        				distA = dist(p, a);
        				targets[0] = p;
        			}	
        		}
        		if(dist(p, b) <= d) {
        			if(dist(p, b) < distB || (dist(p, b) == distB && p.x < targets[1].x) ) {
        				distB = dist(p, b);
        				targets[1] = p;
        			}   			
        		}
        		if(dist(p, c) <= d) {
        			if(dist(p, c) < distC || (dist(p, c) == distC && p.x < targets[2].x) ) {
        				distC = dist(p, c);
        				targets[2] = p;
        			}
        		}
        	}
        	
        	HashSet<Point> set = new HashSet<>();
        	for(Point p: targets) {
        		if(p != null) {
        			set.add(p);
        		}
        	}
        	
        	for(Point p: set) {
        		e.remove(p);
        		cnt++;
        	}
        	
        	ArrayList<Point> toRemove = new ArrayList<>();
        	
        	for(Point p: e) {
        		p.y++;
        		
        		if(p.y == a.y) {
        			toRemove.add(p);
        		}
        	}
        	
        	for(Point p: toRemove) {
        		e.remove(p);
        	}
        	
        	if(e.isEmpty()) {
        		return cnt;
        	}
        }		
	}
	public static ArrayList<Point> enemy = new ArrayList<> ();
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(sc.nextInt() == 1) {
					enemy.add(new Point(j, i));
				}
			}
		}
		
		int ans = 0;
		
		for(int a = 0; a < M-2; a++) {
			for(int b = a+1; b < M-1; b++) {
				for(int c = b+1; c < M; c++) {
					Point playerA = new Point(a, N);
					Point playerB = new Point(b, N);
					Point playerC = new Point(c, N);
					
					ans = Math.max(ans, game(playerA, playerB, playerC, D));
				}
			}
		}
		
		System.out.println(ans);
		
	}
}