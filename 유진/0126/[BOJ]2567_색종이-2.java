import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[102][102];
		
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
		for(int i = 0; i < 102; i++) {
			int curr = map[i][0];
			for(int j = 1; j < 102; j++) {
				if(map[i][j] != curr) {
					ans++;
					curr = map[i][j];
				}
			}
		}
		
		for(int i = 0; i < 102; i++) {
			int curr = map[0][i];
			for(int j = 1; j < 102; j++) {
				if(map[j][i] != curr) {
					ans++;
					curr = map[j][i];
				}
			}
		}
		
		System.out.println(ans);
	}
}
