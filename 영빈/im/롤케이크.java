import java.lang.reflect.Array;
import java.util.Scanner;

public class boj3985 {// 롤케이크
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int N = sc.nextInt();
        int[][] PK = new int[N + 1][2];
        int[] bread = new int[L + 1];
        int premax = 0;
        int preper = 0;

        for (int i = 1; i <= N; i++) {
            int P = sc.nextInt();
            int K = sc.nextInt();
            if (K - P > premax) {
                premax = Math.max(premax, K - P);
                preper = i;
            }

            for (int j = P; j <= K; j++) {
                if (bread[j] == 0) {
                    bread[j] = i;
                }
            }

        }

        int aftermax;
        int afterper = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            aftermax = 0;
            for (int j = 1; j <= L; j++) {
                if (bread[j] == i) {
                    aftermax++;
                }
            }
            if (aftermax > max) {
                max = aftermax;
                afterper = i;
            }
        }

        System.out.println(preper);
        System.out.println(afterper);

    }
}
