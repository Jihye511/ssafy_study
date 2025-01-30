import java.util.Scanner;

public class Jol_1719_별삼각형2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n>100 || m<1 || m > 4 || n%2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }

        if (m == 1) {
            for (int i = 1; i<=n/2; i++) {
                System.out.println("*".repeat(i));
            }

            for (int i = n/2+1;i>=1;i--) {
                System.out.println("*".repeat(i));
            }
        }

        if (m == 2) {
            for (int i = 1; i <= n/2; i++) {
                System.out.println(" ".repeat(n/2+1-i) + "*".repeat(i));
            }
            for (int i = n/2+1;i>=1;i--) {
                System.out.println(" ".repeat(n/2+1-i) + "*".repeat(i));
            }
        }

        if (m==3) {
            for (int i = 0; i <= n/2; i++) {
                System.out.println(" ".repeat(i) + "*".repeat(n-i*2) + " ".repeat(i));
            }
            for (int i = n/2-1; i >= 0; i--) {
                System.out.println(" ".repeat(i) + "*".repeat(n-i*2) + " ".repeat(i));
            }
        }

        if (m==4) {
            for (int i = 0; i <= n/2; i++) {
                System.out.println(" ".repeat(i) + "*".repeat(n/2+1-i));
            }
            for (int i = 2; i <= n/2+1; i++) {
                System.out.println(" ".repeat(n/2) + "*".repeat(i));
            }

        }
    }

}
