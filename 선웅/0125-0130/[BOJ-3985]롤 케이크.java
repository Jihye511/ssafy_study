import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 롤 케이크의 길이
        int L = sc.nextInt();
        // 방청객의 수
        int N = sc.nextInt();

        // 케이크 조각 배열 (0: 아무도 안받음)
        int[] cake = new int[L + 1];

        // 각 방청객이 기대하는 조각 수
        int[] expectedPieces = new int[N + 1];
        // 각 방청객이 실제로 받은 조각 수
        int[] actualPieces = new int[N + 1];

        int maxExpected = 0;
        int maxExpectedIndex = 0;

        // 방청객의 요청을 입력 받기
        for (int i = 1; i <= N; i++) {
            int P = sc.nextInt(); // 시작 조각 번호
            int K = sc.nextInt(); // 끝 조각 번호

            // 기대하는 조각 수 계산
            expectedPieces[i] = K - P + 1;
            if (expectedPieces[i] > maxExpected) {
                maxExpected = expectedPieces[i];
                maxExpectedIndex = i;
            }

            // 실제로 조각 배정
            for (int j = P; j <= K; j++) {
                if (cake[j] == 0) { // 아직 배정되지 않은 조각
                    cake[j] = i;
                    actualPieces[i]++;
                }
            }
        }

        // 실제로 가장 많은 조각을 받은 방청객 찾기
        int maxActual = 0;
        int maxActualIndex = 0;
        for (int i = 1; i <= N; i++) {
            if (actualPieces[i] > maxActual) {
                maxActual = actualPieces[i];
                maxActualIndex = i;
            }
        }

        // 결과 출력
        System.out.println(maxExpectedIndex); // 가장 기대된 방청객 번호
        System.out.println(maxActualIndex);   // 실제로 가장 많이 받은 방청객 번호

        sc.close();
    }
}
