import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_16206_롤케이크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(   //10의 배수 먼저
                Comparator
                .comparingInt((Integer num) -> num % 10)
                .thenComparingInt(num -> num));


        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 10) {
                result++;
                continue;
            }
            if (num < 10) {
                continue;
            }

            pq.add(num);
        }

        while (M > 0 && !pq.isEmpty()) {
            Integer poll = pq.poll();

            if (poll - 10 == 10) {
                result++;
            }

            if (poll - 10 > 10) {
                pq.add(poll - 10);  //자르고 넣기
            }

            result++;
            M--;
        }

        System.out.println(result);
    }
}
