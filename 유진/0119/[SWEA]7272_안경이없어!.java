import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			String[] dict = new String[26];
			
			for(char c: "CEFGHIJKLMNSTUVWXYZ".toCharArray()) {
				dict[c - 'A'] = "0";
			}
			for(char c: "ADOPQR".toCharArray()) {
				dict[c - 'A'] = "1";
			}
			dict[1] = "2";
			
			String converted1 = "";
			String converted2 = "";
			
			for(char c: s1.toCharArray()) {
				converted1 += dict[c-'A'];
			}
			for(char c: s2.toCharArray()) {
				converted2 += dict[c-'A'];
			}
			
			if(converted1.equals(converted2)) {
				System.out.println("#" + test_case + " " + "SAME");
			} else {
				System.out.println("#" + test_case + " " + "DIFF");
			}
		}
		
		sc.close();
	}
}