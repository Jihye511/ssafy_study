import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // 날짜 수
            int[] prices = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long maxProfit = 0;
            int maxPrice = 0; // 오른쪽에서부터 최대 매매가

            // 뒤에서부터 앞으로 순회하며 최대 이익 계산
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    maxProfit += (maxPrice - prices[i]);
                }
            }

            sb.append("#").append(t).append(" ").append(maxProfit).append("\n");
        }

        System.out.print(sb);
    }
}