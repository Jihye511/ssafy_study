import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        for (int t = 1; t <= T; t++) {
            String originalMemory = scanner.nextLine();
            int changeCount = 0;
            char currentState = '0';

            // 메모리 값 비교를 통해 최소 수정 횟수 계산
            for (char c : originalMemory.toCharArray()) {
                if (c != currentState) {
                    changeCount++;
                    currentState = c;
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + changeCount);
        }

        scanner.close();
    }
}
