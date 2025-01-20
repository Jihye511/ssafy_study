import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int length = sc.nextInt();
            
            // 번호 문자열
            String s = sc.next();
            
            // 스택을 이용해 쌍 제거
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                // 스택이 비어있지 않고 top과 현재 문자가 같으면 pop
                // EmptyStackException이 발생하지 않도록 !stack.isEmpty()를 앞에 놓기
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    // 그렇지 않으면 push
                    stack.push(c);
                }
            }
            
            // 남은 스택 요소를 순서대로 이어 붙이면 결과(비밀번호)
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            
            // 출력
            System.out.println("#" + t + " " + sb);
        }

        sc.close();
    }
}
