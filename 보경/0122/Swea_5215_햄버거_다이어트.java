import java.util.Scanner;

public class Swea_5215_햄버거_다이어트 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] results = new int[T];
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int limit = sc.nextInt();
            int[][] scoreAndCal = new int[N][2];

            //점수와 칼로리 입력
            for (int j = 0; j < N; j++) {
                int score = sc.nextInt();
                int cal = sc.nextInt();
                scoreAndCal[j][0] = score;
                scoreAndCal[j][1] = cal;
            }

            recursive(i,limit,scoreAndCal,0,0,0, N, results);
            System.out.printf("#%d %d\n",i+1,results[i]);
        }

    }

    public static void recursive(int iter, int limitCal, int[][] scoreAndCal, int idx, int currScore, int currCal, int n, int[] results) {
        //basis part
        //칼로리를 넘긴경우
        if (currCal > limitCal) {
            return;
        }
        results[iter] = Math.max(results[iter],currScore);

        //더이상 고를 재료가 없는 경우
        if (idx == n) {
            return;
        }



        //inductive part

        //선택
        recursive(iter,limitCal,scoreAndCal,idx+1,currScore + scoreAndCal[idx][0], currCal + scoreAndCal[idx][1],n,results);
        //선택X
        recursive(iter,limitCal,scoreAndCal,idx+1,currScore,currCal,n,results);
    }
}
