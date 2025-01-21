import java.util.Scanner;

class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];

			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					matrix[i][j] = s.charAt(j) - '0';
				}
			}

			int ans = 0;

			int rowCnt = 1;
			int startCol = n / 2;

			for (int r = 0; r < n; r++) {
				for (int c = startCol; c < startCol + rowCnt; c++) {
					ans += matrix[r][c];
				}

				if (r < n / 2) {
					rowCnt += 2;
					startCol--;
				} else {
					rowCnt -= 2;
					startCol++;
				}
			}

			System.out.println("#" + test_case + " " + ans);

		}
		sc.close();
	}
}