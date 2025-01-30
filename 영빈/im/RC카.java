import java.util.Scanner;

public class swea1974 {// Flatten

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt(); // 테스트 케이스 T 입력 받기
        int arr[][] = new int[9][9]; // 9 x 9 스도쿠를 넣을 배열 생성

        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 1;

            // 배열 arr에 9 x 9 스도쿠 넣는 부분
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 행, 열 1~9의 수가 있는지 검증
            for (int i = 0; i < 9; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 9; j++) {
                    rowSum += arr[i][j]; // 세로 줄 검증 : rowSum에 합 더하기
                    colSum += arr[j][i]; // 가로 줄 검증 : colSum에 합 더하기
                    // 따라서 i, j가 각각 반대로 들어감
                }

                if (rowSum != 45 || colSum != 45) { // 1부터 9까지 더한 값은 45
                    answer = 0;
                    break; // 반복문 탈출
                }
            }

            if (answer == 0) { // 행, 열 검증 후 0일 경우 출력 후 반복문 탈출
                System.out.println("#" + test_case + " " + answer);
                continue;
            }

            // 3 x 3 정사각형 1~9의 수가 있는지 검증
            for (int i = 1; i <= 3; i++) {
                int squareSum = 0;
                for (int j = (i - 1) * 3; j < i * 3; j++) {
                    for (int k = (i - 1) * 3; k < i * 3; k++) {
                        squareSum += arr[j][k];
                    }
                }
                if (squareSum != 45) { // 1부터 9까지 더한 값은 45
                    answer = 0;
                    break; // 반복문 탈출
                }
                if (answer == 0) {
                    break;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }

    }

}
