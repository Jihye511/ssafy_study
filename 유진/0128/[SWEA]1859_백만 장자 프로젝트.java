import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
            	arr[i] = sc.nextInt();
            }
            
            long ans = 0;
			int max = arr[n-1];
			for(int i = n-2; i >= 0; i--) {
				if(arr[i] > max) max = arr[i];
				else ans += max - arr[i];
			}
            
			System.out.println("#"+ test_case + " " + ans);
		}
    }
}
