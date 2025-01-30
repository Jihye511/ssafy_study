import java.util.Scanner;

public class Swea_6730_장매물_경주_난이도 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] box = new int[n];
            for (int k = 0; k < n; k++) {
                box[k] = sc.nextInt();
            }

            //난이도 구하기
            int up = 0;
            int down = 0;
            for (int k = 0; k < n-1; k++) {
                if (box[k] > box[k+1]) {
                    down = Math.max(down, box[k] - box[k+1]);
                }

                else {
                    up = Math.max(up, box[k+1] - box[k]);
                }
            }

            System.out.printf("#%d %d %d\n",i+1, up,down);
        }
        sc.close();
    }
}
