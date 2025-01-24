import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n % 2 == 0 || n > 100 || m < 1 || m > 5) {
            System.out.println("INPUT ERROR!");
            return;
        }
        switch (m) {
            case 1:
                for (int i = 1; i <= n; i++) {
                    if (i <= (n + 1) / 2) {
                        for (int j = 1; j <= i; j++)
                            System.out.print("*");
                    } else {
                        for (int j = 1; (i + j) <= n + 1; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 1; i <= n; i++) {
                    if (i <= (n + 1) / 2) {
                        for (int j = 1; (i + j) <= (n + 1) / 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++)
                            System.out.print("*");
                    } else {
                        for (int j = 1; (i - j) >= (n + 1) / 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; (i + j) <= n + 1; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 1; i <= n; i++) {
                    if (i <= (n + 1) / 2) {
                        for (int j = 1; j <= i - 1; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= n - 2 * (i - 1); j++) {
                            System.out.print("*");
                        }
                    } else {
                        for (int j = 1; j <= n - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= 2 * i - n; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            case 4:
                for (int i = 1; i <= n; i++) {
                    if (i <= (n + 1) / 2) {
                        for (int j = 1; j <= i - 1; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= (n + 1) / 2 - (i - 1); j++) {
                            System.out.print("*");
                        }
                    } else {
                        for (int j = 1; j <= (n - 1) / 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i - (n - 1) / 2; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();

                }
                break;

        }

        sc.close();
    }
}
