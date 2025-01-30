package 설연휴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6730_장애물경주난이도 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            int n = Integer.parseInt(br.readLine());
            int[] block = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<n; i++){

                block[i] = Integer.parseInt(st.nextToken());
            }
            int up =0;
            int down = 0;
            for(int i=0;i<n-1; i++){
                int now = block[i];
                int next = block[i+1];
                if(now <next){
                    up = Math.max(up,next-now);
                }else{
                    down = Math.max(down, now-next);
                }
            }
            System.out.println("#" + t + " " + up +" " + down);
        }
    }
}