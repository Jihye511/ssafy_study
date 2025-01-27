import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		
		Point[] points = new Point[n+1];
		
		for(int i = 0; i < n+1; i++) {
			int dir = sc.nextInt();
			int dist = sc.nextInt();
			
			switch(dir) { // 좌표로 변환하여 저장 
			case 1:
				points[i] = new Point(dist, 0);
				break;
			case 2:
				points[i] = new Point(dist, h);
				break;
			case 3:
				points[i] = new Point(0, dist);
				break;
			case 4:
				points[i] = new Point(w, dist);
				break;
			}
		}
		
		int ans = 0;
		Point dg = points[n];
		for(int i = 0; i < n; i++) {
			int x = points[i].x;
			int y = points[i].y;
			
			if(Math.abs(dg.x - x) == w) { // 3,4 방향에 있는 경우 
				int case1 = dg.y + y + w;
				int case2 = 2*h - dg.y - y + w;
				ans += Math.min(case1, case2);
			}
			else if(Math.abs(dg.y - y) == h) { // 1,2 방향에 있는 경우 
				int case1 = dg.x + x + h;
				int case2 = 2*w - dg.x - x + h;
				ans += Math.min(case1, case2);
			} else { // 인접한 방향 또는 같은 방향에 있는 경우 
				ans += Math.abs(dg.x-x) + Math.abs(dg.y-y);
			}
		}

		System.out.println(ans);
	}
}
