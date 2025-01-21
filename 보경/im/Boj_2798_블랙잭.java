import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2798_블랙잭 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //완전탐색
        String[] input = bf.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] str = bf.readLine().split(" ");
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(cards);
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
//                if (cards[i] + cards[j] > m) {
//                    break;
//                }
                for (int k = j+1; k < n; k++) {
                    int temp = cards[i] + cards[j] + cards[k];
                    if (temp > m) {
                        break;
                    }
                    result  = Math.max(result, temp);
                }
            }
        }
        System.out.println(result);
    }
}
