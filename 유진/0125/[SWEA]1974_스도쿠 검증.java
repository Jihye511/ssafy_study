import java.util.Scanner;

public class Solution {
	public static boolean checkRow(int[][] m) {
        for(int i = 0; i < 9; i++) {
            boolean[] c = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(c[m[i][j]] == true) {
                    return false;
                }
                c[m[i][j]] = true;
            }
        }
        return true;
    }
	
	public static boolean checkCol(int[][] m) {
        for(int i = 0; i < 9; i++) {
            boolean[] c = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(c[m[j][i]] == true) {
                    return false;
                }
                c[m[j][i]] = true;
            }
        }
        return true;
    }
	
	public static boolean checkBox(int[][] m) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                boolean[] c = new boolean[10];
                for(int k = i*3; k < i*3+3; k++) {
                    for(int l = j*3; l < j*3+3; l++) {
                        if(c[m[k][l]] == true) {
                            return false;
                        }
                        c[m[k][l]] = true;
                    }
                }
            }
        }
        return true;
    }
	
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {           
            int[][] matrix = new int[9][9]; 
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            if(checkRow(matrix) && checkCol(matrix) && checkBox(matrix)) {
                ans = 1;
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}

