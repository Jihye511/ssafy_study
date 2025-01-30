import java.util.Scanner;

public class Solution {
	static int[][] map; 
    static int[] score;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	String s = sc.next();
        	
        	int cnt = 0;
        	char curr = s.charAt(0);
        	
        	for(int i = 1; i < s.length(); i++) {
        		if(s.charAt(i) != curr) {
        			cnt++;
        			curr = s.charAt(i);
        		}
        	}
        	
        	if(s.charAt(0) == '1') {
        		cnt++;
        	}
        	
            System.out.println("#"+ test_case+" "+ cnt);
        }
    }
}



