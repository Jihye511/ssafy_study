import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class swea1208 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int dump = sc.nextInt();
            int[] ary = new int[100];
            for (int i = 0; i < 100; i++) {
                ary[i] = sc.nextInt();
            }
            Arrays.sort(ary);

            for (int i = 0; i < dump; i++) {
                ary[0]++;
                ary[99]--;
                Arrays.sort(ary);
            }

            System.out.printf("#%d %d\n", t + 1, ary[99] - ary[0]);
        }
    }

}
