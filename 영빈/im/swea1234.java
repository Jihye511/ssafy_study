import java.util.Scanner;
import java.util.Stack;

public class swea {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int t = 0; t < 10; t++)
        {

            int N = sc.nextInt();

            int[] sn = new int[N];
            String num = new String(sc.next());
            sc.nextLine();



            for(int i = 0; i < N; i++)
            {
                sn[i] = num.charAt(i) - '0';
            }

            Stack<Integer> stack = new Stack<>();


            for(int i = 0; i < N; i++)
            {
                if(!stack.empty() && stack.peek() == sn[i])
                {
                    stack.pop();
                    continue;
                }
                stack.push(sn[i]);
            }

            int res = 0;
            int idx = 0;


            while(!stack.empty())
            {
                res += stack.pop() * Math.pow(10, idx) ;
                idx++;
            }

            System.out.printf("#%d %d\n", t+1, res);
        }
        sc.close();

    }
    
}
