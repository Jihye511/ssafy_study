import java.util.Scanner;
import java.util.Stack;

public class Boj_17413_단어_뒤집기_2 {
    public static void main(String[] args) throws Exception{
        //< 나오기 전까지, 공백, > 이후 -> stack 삽입
        Scanner scanner = new Scanner(System.in);
        Stack<Character> st = new Stack();
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx < chars.length) {

            if (!Character.isAlphabetic(chars[idx]) && !Character.isDigit(chars[idx])) {

                if (!st.isEmpty()) {
                    sb.append(reverse(st));
                }

                if (chars[idx] == '<') {
                    while (chars[idx] != '>') {
                        sb.append(chars[idx]);
                        idx++;
                    }
                    sb.append(chars[idx]);
                    if (idx == chars.length -1) {
                        break;
                    }
                    idx++;
                }

                if (chars[idx] == ' ') {
                    sb.append(reverse(st));
                    sb.append(chars[idx]);
                    idx++;
                }
            }

            else {
                st.push(chars[idx]);
                idx++;
            }
        }

        if (!st.isEmpty()) {
            sb.append(reverse(st));
        }
        System.out.println(sb);
    }

    public static String reverse(Stack<Character> chars) {
        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) {
            sb.append(chars.pop());
        }
        return sb.toString();
    }
}
