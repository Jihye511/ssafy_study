import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = scanner.nextInt();
            int[][] farm = new int[N][N];
            for (int y = 0; y < N; y++) {
                String line = scanner.next();
                for (int x = 0; x < N; x++) {
                    farm[y][x] =  line.charAt(x) - '0';
                }
            }
            int sum = 0;
            int extend = 0;
            int mid = N / 2;
            for (int row = 0; row < N; row++) {
                extend = mid - Math.abs(mid - row);
                for (int col = mid - extend; col <= mid + extend; col++) {
                    sum += farm[row][col];
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
        scanner.close();
    }
}
