import java.util.*;
import java.io.*;

public class Boj_16922_로마숫자_만들기 {
    static Set<Integer> results;
    static int[] arr;
    static int R;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        arr = new int[]{1, 5, 10, 50};
        results = new HashSet<>();

        getComb_replacement(0,0,0);
        System.out.println(results.size());

    }

    //중복조합
    static void getComb_replacement(int sum, int idx, int depth) {
        if (depth == R) {
            results.add(sum);
            return;
        }
        if (idx == arr.length) {
            return;
        }
        for (int i = idx; i < 4; i++) {
            getComb_replacement(sum+arr[i], i, depth + 1);
        }
    }
}
