package 설연휴;
import java.io.*;
import java.util.*;
public class 백준_2564_경비원 {
    public static void main(String[] args)throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int shop = Integer.parseInt(br.readLine());
        int[] dist = new int[shop+1];
        for (int i = 0; i < shop; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            dist[i] = getDistance(N, M, dir, val);
        }
        st = new StringTokenizer(br.readLine());
        int guardDir = Integer.parseInt(st.nextToken());
        int guardVal = Integer.parseInt(st.nextToken());
        int me = getDistance(N, M, guardDir, guardVal);

        int sum = 0;
        for(int i =0; i<shop; i++){
            int clock = Math.abs(me -dist[i]);
            sum += Math.min(clock, 2*(N+M)- clock);
        }
        System.out.println(sum);

    }
    public static int getDistance(int N, int M, int dir, int val) {
        if (dir == 1) return val;                   // 북쪽
        if (dir == 2) return 2 * N + M - val;       // 남쪽
        if (dir == 3) return 2 * (N + M) - val;     // 서쪽
        if (dir == 4) return N + val;               // 동쪽
        return 0;
    }
}
