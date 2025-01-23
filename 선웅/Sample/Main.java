import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n > 100 || m < 1 || m > 3) {
            System.out.println("INPUT ERROR!");
            sc.close();
            return;
        }
        switch (m) {
            case 1:
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = n; i >= 1; i--) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < n - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 2 * i - 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
        }
        sc.close();
    }
}
