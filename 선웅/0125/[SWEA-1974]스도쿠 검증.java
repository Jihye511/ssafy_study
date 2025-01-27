import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int[][] grid = new int[9][9];

            // 스도쿠 입력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + (isValidSudoku(grid) ? 1 : 0));
        }

        sc.close();
    }

    // 스도쿠 유효성 검사 함수
    public static boolean isValidSudoku(int[][] grid) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (!isValidSet(grid[i])) {
                return false;
            }
        }

        // 열 검사
        for (int j = 0; j < 9; j++) {
            int[] column = new int[9];
            for (int i = 0; i < 9; i++) {
                column[i] = grid[i][j];
            }
            if (!isValidSet(column)) {
                return false;
            }
        }

        // 3x3 박스 검사
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                int[] box = new int[9];
                int index = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        box[index++] = grid[boxRow * 3 + i][boxCol * 3 + j];
                    }
                }
                if (!isValidSet(box)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 1부터 9까지의 숫자가 한 번씩만 있는지 확인하는 함수
    public static boolean isValidSet(int[] nums) {
        boolean[] seen = new boolean[10]; // 1~9의 숫자 체크를 위한 배열
        for (int num : nums) {
            if (num < 1 || num > 9 || seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }
}
