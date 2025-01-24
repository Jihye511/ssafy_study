import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] matrix = new int[n+2][n+2];
		
		for(int i = 0; i < n+2; i++) {
			matrix[0][i] = -1;
			matrix[n+1][i] = -1;
			matrix[i][0] = -1;
			matrix[i][n+1] = -1;
		}
		
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		
		int d = 0;
		int num = 1;
		int cy = 1, cx = 1;
		while(num <= n*n) {
			matrix[cy][cx] = num++;
			
			int ny = cy + dy[d];
			int nx = cx + dx[d];
			
			if(matrix[ny][nx] != 0 || matrix[ny][nx] == -1) {
				d = (d+1) % 4;
			}
			cy = cy + dy[d];
			cx = cx + dx[d];
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
