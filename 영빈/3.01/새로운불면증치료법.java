package swea;

import java.util.Scanner;

public class 새로운불면증치료법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			boolean[] v = new boolean[10];
			int i = 1;
			int sheep;

			while(true) {
				sheep = i * N;
				boolean out = true;
				
				String str = Integer.toString(sheep);
				int len = str.length();
				for(int n = 0; n < len; n++) {
					v[str.charAt(n) - '0'] = true;
				}
				
				for(int n = 0; n < 10; n++) {
					if(!v[n]) out =false;
					
				}
				
				
				
				if(out) break;
				i++;
			}
			
			
			
			
			
			
			
			
			
			
			System.out.printf("#%d %d\n", t, sheep);
		}
		
		
	}

}
