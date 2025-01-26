import java.util.Scanner;

public class Jol_1329_별삼각형3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 0 || n > 100 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }
        for(int i = 0; i<=n/2;i++) {
            System.out.println(" ".repeat(i) + "*".repeat(i*2+1));
        }
        for(int i = n/2-1; i>=0;i--) {
            System.out.println(" ".repeat(i) + "*".repeat(i*2+1));
        }
    }
}
