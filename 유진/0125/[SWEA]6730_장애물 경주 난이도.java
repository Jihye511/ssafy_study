import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int min = 0;
        	int max = 0;
        	
        	int n = sc.nextInt();
        	int curr = sc.nextInt();
        	
        	for(int i = 1; i < n; i++) {
        		int h = sc.nextInt();
        		
        		max = Math.max(h-curr, max);
        		min = Math.min(h-curr, min);
        		
        		curr = h;
        	}
            System.out.println("#"+ test_case+" "+max+ " "+ Math.abs(min));
        }
    }
}