import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) { // 총 10개의 테스트 케이스
            int dumpLimit = Integer.parseInt(br.readLine()); // 덤프 횟수
            int[] heights = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // 덤프 진행
            for (int i = 0; i < dumpLimit; i++) {
                Arrays.sort(heights); // 오름차순 정렬
                if (heights[99] - heights[0] <= 1) {
                    break; // 평탄화 완료
                }
                heights[99]--; // 최고점에서 하나 제거
                heights[0]++; // 최저점에 하나 추가
            }

            Arrays.sort(heights); // 최종 정렬
            int result = heights[99] - heights[0];
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
