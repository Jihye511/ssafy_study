import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람의 수 입력
        int N = sc.nextInt();

        // 각 사람이 돈을 인출하는 데 걸리는 시간 입력
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(P);

        // 누적 시간 계산
        int totalTime = 0; // 총 시간 합계
        int cumulativeTime = 0; // 현재 사람까지 걸린 누적 시간

        for (int i = 0; i < N; i++) {
            cumulativeTime += P[i]; // 현재 사람까지의 누적 시간 갱신
            totalTime += cumulativeTime; // 총 시간에 누적 시간 추가
        }

        // 결과 출력
        System.out.println(totalTime);
    }
}
