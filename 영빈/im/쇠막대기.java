import java.util.Scanner;
import java.io.*;

// 가랏! RC카!
public class swea5432 {// 쇠막대기 자르기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		int barcount = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			int count = 0;
			String str = sc.nextLine();
			int bar = 0;

			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == '(') {
					bar++;
					barcount++;
					if (str.charAt(i + 1) == ')')// 레이저라면
					{
						bar--;
						i++;
						barcount--;
						count += bar;
						// 레이저부분 구현

					}
				} else if (str.charAt(i) == ')') {
					bar--;
				}

			}

			System.out.printf("#%d %d\n", t, count + barcount);
		}
	}
}