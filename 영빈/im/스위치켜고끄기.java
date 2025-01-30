import java.util.Scanner;

/**
 * 스위치 켜고 끄기
 * https://www.acmicpc.net/problem/1244
 */
public class boj1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int gender = sc.nextInt();
            int number = sc.nextInt();
            if (gender == 1) { // 남자
                for (int k = number; k <= n; k += number) {
                    if (arr[k] == 1) {
                        arr[k] = 0;
                    } else {
                        arr[k] = 1;
                    }
                }
            } else { // 여자
                int left = number - 1;
                int right = number + 1;
                while (left > 0 && right <= n) {
                    if (arr[left] != arr[right]) {
                        break;
                    }
                    left--;
                    right++;
                }
                for (int k = left + 1; k < right; k++) {
                    if (arr[k] == 1) {
                        arr[k] = 0;
                    } else {
                        arr[k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}