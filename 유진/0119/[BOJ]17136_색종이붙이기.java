import java.util.Scanner;

class Main {
	public static int ans = 100;
	
	public static void solve(int[][] matrix, int r, int c, int[] limit) {	
		if(isAllZero(matrix, 0, 0, 10)) {
			int cnt = 0;
			for(int i = 1; i < 6; i++) {
				cnt += 5-limit[i];
			}
			
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int size = 1; size <= 5; size++) {
			if(limit[size] > 0 && r+size <= 10 && c+size <= 10 && isAllOnes(matrix, r, c, size)) {
				int[][] newMatrix = new int[10][10];
				int[] newLimit = new int[6];
				
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						newMatrix[i][j] = (i >= r && i < r+size && j >= c && j < c+size) ? 0 : matrix[i][j];
					}
				}
				for(int i = 1; i < 6; i++) {
					newLimit[i] = limit[i];
				}
				newLimit[size]--;
				
				int[] start = findStartPoint(newMatrix);
				
				solve(newMatrix, start[0], start[1], newLimit);
			}
		}
		
	}
	
	public static boolean isAllOnes(int[][] matrix, int i, int j, int size) {
		for(int a = i; a < i+size; a++) {
			for(int b = j; b < j+size; b++) {
				if(matrix[a][b] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isAllZero(int[][] matrix, int i, int j, int size) {
		for(int a = i; a < i+size; a++) {
			for(int b = j; b < j+size; b++) {
				if(matrix[a][b] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int[] findStartPoint(int[][] matrix) {
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				if(matrix[r][c] == 1) {
					return new int[]{r, c};
				}
			}
		}
		return new int[]{0, 0};
	}
	
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int[][] matrix = new int[10][10];
		int[] limit = {0, 5, 5, 5, 5, 5};
		
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				matrix[r][c] = sc.nextInt();
			}
		}
		
		int[] start = findStartPoint(matrix);
	
		solve(matrix, start[0], start[1], limit);
		
		if(ans == 100) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
		sc.close();
	}
}