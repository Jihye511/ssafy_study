import java.util.Scanner;

public class Jo_1523_별삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m > 3 || m < 1 || n > 100) {
            System.out.println("INPUT ERROR!");
            return;
        }

        if (m == 1) {
            for (int i = 1; i <= n; i++) {
                System.out.println("*".repeat(i) );
            }
        }

        if (m == 2) {
            for(int i = n; i > 0; i--) {
                System.out.println("*".repeat(i));
            }
        }

        if (m ==3) {
            int blank =  n-1;
            for(int i = 1; i <= n; i++) {
                System.out.println(" ".repeat(blank) + "*".repeat(i*2-1));
                blank -= 1;
            }
        }
        sc.close();
    }
}
