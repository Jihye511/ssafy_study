package 설연휴;
import java.io.*;
import java.util.*;

public class 백준_2991_사나운개 {
    static int A, B, C, D;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int time = Integer.parseInt(st.nextToken());
            sb.append(getAttackCount(time)).append("\n");
        }

        System.out.println(sb);
    }

    public static int getAttackCount(int time) {
        int count = 0;

        if (isAttacked(time, A, B)) count++;
        if (isAttacked(time, C, D)) count++;

        return count;
    }

    public static boolean isAttacked(int time, int attack, int rest) {
        int cycle = attack + rest; // 한 사이클(공격+휴식) 길이
        return (time % cycle) != 0 && (time % cycle) <= attack;
    }
}
