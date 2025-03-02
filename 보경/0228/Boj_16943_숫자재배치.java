import java.util.*;
import java.io.*;

public class Boj_16943_숫자재배치 {
    static int[] num;
    static boolean[] visited;
    static int N;
    static int ans;
    static int b;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        b = Integer.parseInt(st.nextToken());

        N = a.length();
        num = new int[N];
        ans = Integer.MIN_VALUE;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            num[i] = a.charAt(i) - '0';
        }
        comb(0,new int[N]);
        if (ans == Integer.MIN_VALUE) ans = -1;
        System.out.println(ans);

    }

    static void comb(int depth, int[] sel) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(sel[i]);
            }
            int c = Integer.parseInt(sb.toString());
            if (c < b) {
                ans = Math.max(ans, Integer.parseInt(sb.toString()));
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (depth == 0 && num[i] == 0) continue;
                visited[i] = true;
                sel[depth] = num[i];
                comb(depth + 1, sel);
                visited[i] = false;
            }
        }
    }
}
