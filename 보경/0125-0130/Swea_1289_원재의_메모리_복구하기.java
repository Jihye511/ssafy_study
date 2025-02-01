import java.util.Scanner;

public class Swea_1289_원재의_메모리_복구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String input = sc.next();
            char bit = '0';
            int result = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) != bit) {
                    result += 1;
                    if (bit == '0') {
                        bit = '1';
                    }
                    else {
                        bit = '0';
                    }
                }
            }

            System.out.printf("#%d %d\n",i+1,result);
        }
    }
}
