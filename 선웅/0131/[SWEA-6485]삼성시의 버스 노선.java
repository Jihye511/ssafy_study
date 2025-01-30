import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // Number of test cases

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // Number of bus routes
            
            // Create an array to count the number of buses passing each stop
            int[] stops = new int[5001];

            // Read bus routes and mark the ranges in the array
            for (int i = 0; i < N; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                for (int j = A; j <= B; j++) {
                    stops[j]++;
                }
            }

            int P = sc.nextInt(); // Number of queries
            int[] results = new int[P];

            for (int i = 0; i < P; i++) {
                int C = sc.nextInt(); // Bus stop to query
                results[i] = stops[C];
            }

            // Print the result for the current test case
            System.out.print("#" + t);
            for (int result : results) {
                System.out.print(" " + result);
            }
            System.out.println();
        }

        sc.close();
    }
}
