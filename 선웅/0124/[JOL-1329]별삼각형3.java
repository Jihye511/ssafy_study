import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 100 || n < 1 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }

        for (int i = 1; i <= (n + 1) / 2; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = (n + 1) / 2 + 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (n - i) * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}