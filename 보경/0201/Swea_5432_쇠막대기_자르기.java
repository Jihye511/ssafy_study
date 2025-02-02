import java.util.*;
import java.io.*;
//재귀..?

public class Swea_5432_쇠막대기_자르기 {
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            int result = 0;

            //1. ( 열린 막대기
            //2. () 레이저 -> 열린 막대기 자름
            //3. ) 닫힌 막대기 -> 잘리고 남은 조각 +1

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.push('(');
                }

                else {
                    if (input.charAt(i-1) == '(') {
                        //레이저
                        stack.pop();
                        result += stack.size();
                    }
                    else {
                        stack.pop();
                        result += 1;
                    }
                }
            }

            System.out.printf("#%d %d\n",t,result);
        }
    }
}
