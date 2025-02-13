package A형기출_0210;

import java.io.*;
import java.util.*;

public class BOJ_16637_괄호추가하기 {
    static int N;
    static char[] operators;
    static int[] numbers;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        numbers = new int[N / 2 + 1];
        operators = new char[N / 2];

        int numIndex = 0, opIndex = 0;
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (i % 2 == 0) {
                numbers[numIndex++] = c - '0';
            } else {
                operators[opIndex++] = c;
            }
        }

        dfs(0, numbers[0]);
        System.out.println(maxResult);
    }

    static void dfs(int idx, int result) {
        if (idx == operators.length) {
            maxResult = Math.max(maxResult, result);
            return;
        }

        //괄호 없이 계산
        int res1 = calculate(result, numbers[idx + 1], operators[idx]);
        dfs(idx + 1, res1);

        // 괄호를 추가하는 경우 (idx + 1 연산을 먼저 수행)
        if (idx + 1 < operators.length) {
            int temp = calculate(numbers[idx + 1], numbers[idx + 2], operators[idx + 1]);
            int res2 = calculate(result, temp, operators[idx]);
            dfs(idx + 2, res2);
        }
    }

    static int calculate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return 0;
        }
    }
}
