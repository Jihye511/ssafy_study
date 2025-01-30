package 설연휴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6958_동철이의프로그래밍대회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] solve = new int[N];

            int[][] map = new int[N][M];
            int max =Integer.MIN_VALUE;
            for(int i =0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j =0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] ==1){
                        solve[i] +=1;
                    }
                    max = Math.max(max, solve[i]);
                }
            }
            int cnt =0;
            for(int i =0; i<N; i++){
                if(max == solve[i]){
                    cnt++;
                }
            }
            System.out.println("#" + t + " " + cnt +" " + max);

        }
    }
}