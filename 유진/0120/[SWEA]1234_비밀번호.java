import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String s = sc.next();

			int[] pw = new int[n];
			for (int i = 0; i < n; i++) {
				pw[i] = s.charAt(i) - '0';
			}

			while (true) {
				int prev = pw[0];
				int prevIdx = 0;
				int cnt = 0;

				for (int i = 1; i < pw.length; i++) {
					if (pw[i] != -1) {
						if (pw[i] == prev) {
							pw[i] = -1;
							pw[prevIdx] = -1;
							cnt++;
						}
						prev = pw[i];
						prevIdx = i;
					}
				}
				if (cnt == 0) {
					break;
				}
			}

			String ans = "";
			for (int p : pw) {
				if (p != -1) {
					ans += Integer.toString(p);
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}

		sc.close();
	}
}