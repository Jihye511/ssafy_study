import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 색종이의 수

        // 도화지 크기 정의
        int[][] canvas = new int[100][100]; // 100x100 크기의 도화지

        // 색종이를 도화지에 붙이기
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // 색종이의 크기 10x10
            for (int dx = 0; dx < 10; dx++) {
                for (int dy = 0; dy < 10; dy++) {
                    canvas[x + dx][y + dy] = 1;
                }
            }
        }

        // 둘레 계산
        int perimeter = 0;
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (canvas[i][j] == 1) { // 색종이가 있는 칸
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        // 주변이 도화지 밖이거나 빈 칸이면 둘레 증가
                        if (nx < 0 || nx > 99 || ny < 0 || ny > 99 || canvas[nx][ny] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        System.out.println(perimeter);
    }
}
