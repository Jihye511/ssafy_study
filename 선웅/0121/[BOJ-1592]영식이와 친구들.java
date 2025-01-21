import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt(); // 사람 수
        int M = scanner.nextInt(); // 한 사람이 공을 받을 최대 횟수
        int L = scanner.nextInt(); // 공을 던질 거리

        // 공을 받은 횟수를 저장하는 배열
        int[] receivedCount = new int[N];

        // 초기 상태 설정
        int currentPosition = 0; // 현재 공을 가진 사람의 위치 (0-indexed)
        int throwsCount = 0; // 공을 던진 횟수

        while (true) {
            receivedCount[currentPosition]++; // 현재 사람의 공 받은 횟수 증가

            // M번 받았으면 게임 종료
            if (receivedCount[currentPosition] == M) {
                break;
            }

            // 공을 던질 방향 및 위치 계산
            if (receivedCount[currentPosition] % 2 == 1) {
                // 홀수번 받았으면 시계 방향으로 L번째 사람에게 던짐
                currentPosition = (currentPosition + L) % N;
            } else {
                // 짝수번 받았으면 반시계 방향으로 L번째 사람에게 던짐
                currentPosition = (currentPosition - L + N) % N;
            }

            throwsCount++; // 공을 던진 횟수 증가
        }

        // 결과 출력
        System.out.println(throwsCount);

        scanner.close();
    }
}
