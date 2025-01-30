import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j = a; j < a+10; j++) {
				for(int k = b; k < b+10; k++) {
					map[j][k] = 1;
				}
			}
			
			
		}
		
		int ans = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}
}
