import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	
        	int max = -1;
        	int cnt = 1;
        	
        	for(int i = 0; i < n; i++) {
        		int temp = 0;
        		for(int j = 0; j < m; j++) {
        			temp += sc.nextInt();
        		}
        		if(temp > max) {
        			max = temp;
        			cnt = 1;
        		} else if(temp == max) {
        			cnt += 1;
        		}
        	}
            System.out.println("#"+ test_case+" "+cnt+ " "+ max);
        }
    }
}