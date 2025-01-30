import java.util.Arrays;
import java.util.Scanner;

public class Boj_2999_비밀_이메일 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] divisor = getDiv(input.length());
        char[][] mail = new char[divisor[0]][divisor[1]];

        int idx = 0;
        for (int i = 0; i < divisor[1]; i++) {
            for (int j = 0; j < divisor[0]; j++) {
                mail[j][i] = input.charAt(idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < divisor[0]; i++) {
            for (int j = 0; j < divisor[1]; j++) {
                sb.append(mail[i][j]);
            }
        }

        System.out.println(sb);

    }

    public static int[] getDiv(int num) {
        int r = 0;
        int c = num;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i <= c) {
                    r = i;
                    c = num / i;
                }
                else {
                    break;
                }
            }
        }
        return new int[]{r,c};
    }
}
