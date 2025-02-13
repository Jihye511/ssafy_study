import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int max = Integer.MAX_VALUE;
    static int[] numbers;
    static char[] operators;
    static int N;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        boolean isNumber = true;
        numbers = new int[N / 2 + 1];
        operators = new char[N / 2];
        int index = 0;
        for (char a : input.toCharArray()) {
            if (isNumber) {
                isNumber = false;
                numbers[index] = a - '0';
            } else {
                isNumber = true;
                operators[index] = a;
                index++;
            }
        }
        if (N == 1) {
            System.out.println(input.charAt(0) - '0');
        } else {
            System.out.println(makeParentheses(index));
        }
    }

    public static int makeParentheses(int start) {
        int max = Integer.MIN_VALUE;

        for (int mask = 0; mask < (1 << N/2); mask++) {
            if (isValid(mask)) {
                continue;
            }
            max = Math.max(max,calculate(mask));
        }
        return max;
    }

    public static boolean isValid(int mask) {
        while (mask != 0) {
            if ((mask & 1) == 1 && ((mask >> 1) & 1) == 1) {
                return true;
            }
            mask = mask >> 1;
        }
        return false;
    }

    public static int calculate(int mask) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        nums.add(numbers[0]);
        for (int i = 0; i < N / 2; i++) {
            if ((mask & 1) == 1) {
                int left = nums.get(nums.size() - 1);
                int right = numbers[i + 1];
                int value = calc(left, right, operators[i]);
                nums.set(nums.size() - 1, value);
            } else {
                nums.add(numbers[i + 1]);
                chars.add(operators[i]);
            }
            mask = mask >> 1;
        }

        int result = nums.get(0);
        int index = 0;
        for(char ch: chars){
            result = calc(result, nums.get(index + 1), ch);
            index++;
        }

        return result;
    }

    public static int calc(int left, int right, char op) {
        switch (op) {
            case '*':
                return left * right;
            case '+':
                return left + right;
            case '-':
                return left - right;
        }

        System.out.println("연산자 입력 오류");
        return 0;
    }

}