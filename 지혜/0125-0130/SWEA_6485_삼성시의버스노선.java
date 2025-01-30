package 설연휴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6485_삼성시의버스노선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] bus = new int[N][2];
            for(int i =0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                bus[i][0] = Integer.parseInt(st.nextToken());
                bus[i][1] = Integer.parseInt(st.nextToken());

            }
            StringBuilder sb = new StringBuilder();
            int P = Integer.parseInt(br.readLine());
            for(int i =0; i<P; i++){
                int cnt =0;
                int c = Integer.parseInt(br.readLine());
                for(int j =0; j<N; j++){
                    if(bus[j][0]<= c && bus[j][1]>=c) cnt++;
                }
                sb.append(cnt).append(" ");

            }
            System.out.println("#"+ t+ " "+ sb);

        }
    }
}
