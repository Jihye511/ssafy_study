import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Study {
	static int N, ans;
	static ArrayList<Apple> apples;
	
	static class Apple implements Comparable<Apple>{
		int y, x, num;
		Apple(int y, int x, int num){
			this.y = y;
			this.x = x;
			this.num = num;
		}
		@Override
		public int compareTo(Study.Apple o) {
			return Integer.compare(this.num, o.num);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			apples = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num != 0) {
						apples.add(new Apple(i, j, num));
					}
				}
			}
			
			Collections.sort(apples);
			
			ans = 0;
			int y = 0, x = 0, d = 1;
			for(Apple a: apples) {
				d = rotate(y, x, d, a.y, a.x);
				y = a.y;
				x = a.x;
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static int rotate(int sy, int sx, int d, int ey, int ex) {
		if(sy > ey && sx > ex) { // 왼쪽 위 
			if(d == 0) {
				ans += 3; return 3; 
			}
			else if(d == 1) ans += 3;  
			else if(d == 2) ans += 2;
			else if(d == 3) ans += 1;
			return 0;
		} else if(sy > ey && sx < ex) { // 오른쪽 위 
			if(d == 0) ans += 1;
			else if(d == 1) {
				ans += 3;
				return 0;
			}
			else if(d == 2) ans += 3;
			else if(d == 3) ans += 2;
			return 1;
		} else if(sy < ey && sx < ex) { // 오른쪽 아래 
			if(d == 0) ans += 2;
			else if(d == 1) ans += 1;
			else if(d == 2) {
				ans += 3;
				return 1;
			}
			else if(d == 3) ans += 3;
			return 2;
		} else if(sy < ey && sx > ex) { // 왼쪽 아래 
			if(d == 0) ans += 3;
			else if(d == 1) ans += 2;
			else if(d == 2) ans += 1;
			else if(d == 3) {
				ans += 3;
				return 2;
			}
			return 3;
		} 
		return -1;
	}
}


//#1 7
//#2 9
//#3 10
//#4 14
//#5 14