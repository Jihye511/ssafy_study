import java.io.*;
import java.util.*;
public class Swea_10726_이진수표현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
             st = new StringTokenizer(br.readLine());
             int N = Integer.parseInt(st.nextToken());
             int M = Integer.parseInt(st.nextToken());

            //M의 이진수 표현의 마지막 N 비트가 모두 1로 켜져 있는지 아닌지를 판별
            //OFF / ON 출력
            int offset = (1 << N) - 1; //1111111
            //System.out.println(Integer.toBinaryString(offset));
            String result = (M & offset) == offset ? "ON" : "OFF";
            System.out.printf("#%d %s\n", t, result);
        }
    }
}
