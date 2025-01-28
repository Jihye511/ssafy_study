import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 비우기
        for (int tc = 1; tc <= T; tc++) {
            String input = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            int result = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                // '('인 경우 스택에 push
                if (c == '(') {
                    stack.push(c);
                } else {
                    // ')'인 경우
                    if (input.charAt(i - 1) == '(') {
                        // 레이저
                        stack.pop(); // 직전 '(' 제거
                        result += stack.size(); // 현재 스택에 남아있는 '(' 수만큼 잘린 조각
                    } else {
                        // 쇠막대기 끝
                        stack.pop();
                        result += 1; // 막대기 하나가 끝났으므로 조각 1개 추가
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }
}
