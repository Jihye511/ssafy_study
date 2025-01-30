import java.util.Scanner;

public class Swea_6485_삼성시의_버스노선 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] course = new int[N][2];
            //코스 입력
            for (int i = 0; i < N; i++) {
                course[i][0] = sc.nextInt();
                course[i][1] = sc.nextInt();
            }
            //P
            int p = sc.nextInt();
            int[] answer = new int[p];
            for (int i = 0; i < p; i++) {
                int station = sc.nextInt();
                for (int j = 0; j < N; j++) {
                    if (course[j][0] <= station && course[j][1] >= station) {
                        answer[i] += 1;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int res : answer) {
                sb.append(res);
                sb.append(" ");
            }
            System.out.printf("#%d %s\n",t+1,sb);
        }
    }
}
