import java.util.*;

/**
 * @author Sunwoong Moon
 */

/*
 * 수 N을 입력받고
 * 각 자리 숫자를 통해 boolean 배열을 바꾸자
 * 0~9까지 boolean 배열이 true가 되면 멈추기
 */
public class Solution {
    static int N;
    static boolean[] numbers;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            numbers = new boolean[10];
            int x = countSheep();
            System.out.printf("#%d %d\n", testCase, x * N);
        }

        sc.close();
    }

    public static int countSheep() {
        int copied = 0;
        int x = 0;
        boolean run = true;
        while (run) {
            copied += N;
            x++;
            checkNumber(copied);
            for (int i = 0; i < 10; i++) {
                if (numbers[i] == false) {
                    run = true;
                    break;
                }
                run = false;
            }
        }
        return x;
    }

    public static void checkNumber(int n) {
        while (n > 0) {
            numbers[n % 10] = true;
            n = n / 10;
        }
    }
}