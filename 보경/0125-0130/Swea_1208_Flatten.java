import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Swea_1208_Flatten {
    public static void main(String[] args) {
        //주어진 덤프 횟수 내에 덤프 수행 완료 가능
        int T = 10;
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < T; i++){
            int dump = sc.nextInt();
            ArrayList<Integer> heap = new ArrayList<>();
            int result = -1;
            for(int j = 0; j < 100; j++) {
                heap.add(sc.nextInt());
            }

            for (int k = 0; k < dump+1; k++) {
                int small = Collections.min(heap);
                heap.remove(Integer.valueOf(small));

                int big = Collections.max(heap);
                heap.remove(Integer.valueOf(big));

                result = big - small;

                small += 1;
                big -= 1;

                if (result <= 1) { //평탄화 완료
                    break;
                }

                heap.add(small);
                heap.add(big);
            }

            System.out.printf("#%d %d\n",i+1, result);

        }
    }
}
