import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정올_별삼각형3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n > 100 || n < 0 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }

        for (int i = 0; i < n / 2 + 1; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= n / 2; i++) {
            for (int k = 0; k < n/2-i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - (i * 2); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}