import java.util.Scanner;
//최대 백만 각 매매가 최대 10000 -> long
public class Swea_1859_백만장자_프로젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] price = new int[n];
            for(int idx = 0; idx < n; idx++) {
                price[idx] = sc.nextInt();
            }

            /*
            뒤에서부터 탐색 -> 현재 값보다 작은 값 => 이익 발생
            현재 값보다 큰 값 -> 그 값으로 max 갱신후 탐색 ->
             */
            int max = 0;
            long benefit = 0L;
            for(int idx = n-1; idx >= 0; idx--) {
                if (price[idx] < max) {
                    benefit += max - price[idx];
                }

                else {
                    //사면 안됨
                    max = price[idx];
                }
            }

            System.out.printf("#%d %d\n",i+1,benefit);
        }


        sc.close();
    }
}
