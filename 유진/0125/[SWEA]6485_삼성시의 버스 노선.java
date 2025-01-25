import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int n = sc.nextInt();
        	int[][] time = new int[n][2];
        	
        	for(int i = 0; i < n; i++) {
        		time[i][0] = sc.nextInt();
        		time[i][1] = sc.nextInt();
        	}
        	
        	int p = sc.nextInt();
        	
        	System.out.print("#"+ test_case+" ");
        	
        	for(int i = 0; i < p; i++) {
        		int bus = sc.nextInt();
        		int cnt = 0;
        		
        		for(int j = 0; j < n; j++) {
        			if(bus >= time[j][0] && bus <= time[j][1]) {
        				cnt++;
        			}
        		}
        		System.out.print(cnt+ " ");
        	}
        	System.out.println();
        }
    }
}