import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        String[] input = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 0; i < N-1; i++) {
            nums[i+1] = nums[i+1] + nums[i];
            result += nums[i+1];
        }

        System.out.println(result);
    }
}
