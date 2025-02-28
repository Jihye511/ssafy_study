import java.util.*;

/**
 * @author Sungwoong Moon
 * @start 2025.02.28 22:40
 * @comment 숫자 재배치 문제
 *          0으로 시작하면 안됌
 *          일단 자릿수부터 알고 시작해야 되지 않을까?
 *          자릿수 구하려면 while문으로 10씩 나누면서 횟수를 구하면 될듯
 *          예를 들어 123을 보자
 *          10으로 나누면 12 다시 나누면 1 다시 나누면 0 총 3번 나누면 0이 된다.
 *          그러면 0이 될때까지 나누고 횟수 세면 된다.
 * @end
 */
public class Main {
    static int A, B, numLength;
    static int[] C;
    static boolean[] visited;
    static int max = -1;
    static int[] numArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        numLength = 0;
        int temp = A;
        while (temp != 0) {
            temp /= 10;
            numLength++;
        }

        C = new int[numLength];
        temp = A;

        for (int i = 0; i < numLength; i++) {
            C[i] = temp % 10;
            temp /= 10;
        }

        numArray = new int[numLength];

        visited = new boolean[numLength];
        search(0);
        System.out.println(max);
        sc.close();
    }

    public static void search(int depth) {
        if (depth == numLength) {
            if (numArray[0] == 0) {
                return;
            }
            int num = numArray[0];
            for (int i = 1; i < numLength; i++) {
                num *= 10;
                num += numArray[i];
            }
            if (num < B && num > max) {
                max = num;
            }
        }
        for (int i = 0; i < numLength; i++) {
            if (visited[i]) {
                continue;
            }
            numArray[depth] = C[i];
            visited[i] = true;
            search(depth + 1);
            visited[i] = false;
        }
    }
}