import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 스위치 개수 입력
        int n = scanner.nextInt();
        int[] switches = new int[n + 1]; // 1-based index

        // 스위치 상태 입력
        for (int i = 1; i <= n; i++) {
            switches[i] = scanner.nextInt();
        }

        // 학생 수 입력
        int studentCount = scanner.nextInt();

        // 각 학생의 성별과 번호에 따른 스위치 조작
        for (int i = 0; i < studentCount; i++) {
            int gender = scanner.nextInt();
            int number = scanner.nextInt();

            if (gender == 1) { // 남학생
                for (int j = number; j <= n; j += number) {
                    switches[j] = 1 - switches[j]; // 상태 변경
                }
            } else if (gender == 2) { // 여학생
                int left = number, right = number;
                while (left > 0 && right <= n && switches[left] == switches[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                for (int j = left; j <= right; j++) {
                    switches[j] = 1 - switches[j]; // 상태 변경
                }
            }
        }

        // 스위치 상태 출력
        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) { // 20개씩 출력
                System.out.println();
            }
        }
        scanner.close();
    }
}
