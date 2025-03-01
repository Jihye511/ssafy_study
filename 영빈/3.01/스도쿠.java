package boj;
import java.util.Scanner;

public class 스도쿠 {
    
    static int[][] map;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[9][9];
        
        // 스도쿠 보드 입력 받기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        // 스도쿠 풀기 (백트래킹)
        if (solve()) {
            // 해결된 스도쿠 보드 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf("%d ", map[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("해결 불가능한 퍼즐입니다.");
        }
    }
    
    // 빈 칸을 찾아 숫자를 채워 넣는 백트래킹 메서드
    static boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            	
                if (map[i][j] == 0) { // 빈 칸이면
                	
                    for (int num = 1; num <= 9; num++) {
                        if (insert(i, j, num)) { // 해당 숫자 채워넣을 수 있으면
                            map[i][j] = num;
                            
                            if (solve()) { // 재귀적으로 다음 빈 칸 해결
                                return true;
                            }
                            map[i][j] = 0; // 실패 시 초기화 후 다른 숫자 시도
                        }
                    }
                    return false; // 모든 숫자가 불가능하면 되돌아감
                }
            }
        }
        return true; // 모든 칸이 채워졌다면 성공
    }
    
    static boolean insert(int x, int y, int num) {
        // 같은 행에 중복이 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) {
                return false;
            }
        }
        // 같은 열에 중복이 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == num) {
                return false;
            }
        }
        // 해당 3×3 박스 내에 중복이 있는지 확인
        int R = x - x % 3;
        int C = y - y % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[R + i][C + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
