import java.io.*;
import java.util.*;
public class SWEA_7272_안경이없어 {
    // 구멍이 1개
    static char[] oneHole = {'A', 'D', 'O', 'P', 'Q', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String preWord = st.nextToken();
            String posWord = st.nextToken();

            if (preWord.length() != posWord.length()) {
                sb.append("#").append(t).append(" DIFF").append("\n");
                continue;
            }

            boolean isSame = true;
            int size = preWord.length();
            for (int i = 0; i < size; i++) {
                char preC = preWord.charAt(i);
                char posC = posWord.charAt(i);

                // 각 문자의 구멍 개수 확인
                int preHoles = getHoles(preC);
                int posHoles = getHoles(posC);

                // 구멍 개수가 다르면 다른 문자
                if (preHoles != posHoles) {
                    isSame = false;
                    break;
                }
            }
            sb.append("#").append(t).append(isSame ? " SAME" : " DIFF").append("\n");
        }
        System.out.print(sb.toString());
    }

    static int getHoles(char c) {
        if (c == 'B') return 2;

        for (char oneHoleChar : oneHole) {
            if (oneHoleChar == c) return 1;
        }
        return 0;
    }
}