import java.util.Scanner;

public class jo1523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 삼각형의 높이
        int m = sc.nextInt(); // 삼각형의 종류

        for (int i = 0; i < n; i++) { // 0 1 2 3 4
            if (n > 100 || m < 1 || m > 3) {
                System.out.println("INPUT ERROR!");
                break;
            }

            if (m == 1) {
                for (int j = 0; j < i + 1; j++) { // 1 2 3 4 5
                    System.out.print("*");
                }
                System.out.println();
            }

            if (m == 2) {
                for (int j = 0; j < n - i; j++) { // 5 4 3 2 1
                    System.out.print("*");
                }
                System.out.println();
            }

            if (m == 3) { // 1 3 5 7 9
                // 공백 4 3 2 1 0
                for (int j = 1; j < n - i; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < i * 2 + 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}