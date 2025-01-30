import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Boj_2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        //한 장 남을 때까지 반복
        //1.버리고
        //2. 그 다음꺼 젤 밑으로
        while (dq.size() > 1) {
            dq.poll();
            int n = dq.poll();
            dq.add(n);
        }
        System.out.println(dq.poll());
    }
}
