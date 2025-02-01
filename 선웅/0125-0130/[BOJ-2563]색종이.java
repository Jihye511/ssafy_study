import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 흰색 도화지 크기
        int canvasSize = 100;
        boolean[][] canvas = new boolean[canvasSize][canvasSize];

        // 색종이 수 입력
        int n = scanner.nextInt();

        // 색종이 붙이기
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt(); // 색종이의 왼쪽 변과 도화지 왼쪽 변 사이의 거리
            int y = scanner.nextInt(); // 색종이의 아래쪽 변과 도화지 아래쪽 변 사이의 거리

            // 색종이의 크기 10x10을 도화지에 반영
            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    canvas[row][col] = true; // 색종이가 붙은 영역을 true로 설정
                }
            }
        }

        // 검은 영역의 넓이 계산
        int blackArea = 0;
        for (int i = 0; i < canvasSize; i++) {
            for (int j = 0; j < canvasSize; j++) {
                if (canvas[i][j]) {
                    blackArea++;
                }
            }
        }

        // 결과 출력
        System.out.println(blackArea);

        scanner.close();
    }
}