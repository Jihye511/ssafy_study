import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
			
			int ans = 0;
			int open = 0;
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') {
					open++;
				} else if(s.charAt(i) == ')') {
					open--;
					if(s.charAt(i-1) == '(') {
						ans += open;
					} else {
						ans += 1;
					}
				}
			}

			System.out.println("#"+ test_case+" "+ ans);
		}
	}
}



