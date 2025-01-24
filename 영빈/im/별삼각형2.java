import java.util.Scanner;

public class jo1719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = n / 2 + 1;
        int star = 0;
        int space = k;

        if (m == 1) {

            for (int i = 0; i < k; i++) {
                star++;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }
                System.out.printf("\n");

            }
            for (int i = k; i < n; i++) {
                star--;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }
                System.out.printf("\n");
            }
        } else if (m == 2) {

            for (int i = 0; i < k; i++) {
                space--;
                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                star++;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }
                System.out.printf("\n");

            }
            for (int i = k; i < n; i++) {
                space++;
                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                star--;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }
                System.out.printf("\n");
            }

        } else if (m == 3) {
            star = n + 2;
            space = -1;
            for (int i = 0; i < k; i++) {
                space++;
                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                star -= 2;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }

                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                System.out.printf("\n");
            }

            for (int i = k; i < n; i++) {

                space--;
                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                star += 2;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }

                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                System.out.printf("\n");

            }

        } else if (m == 4) {
            star = n / 2 + 2;
            space = -1;
            int space2 = n / 2;
            for (int i = 0; i < k; i++) {
                space++;
                for (int j = 0; j < space; j++) {
                    System.out.printf(" ");
                }
                star--;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }

                for (int j = 0; j < space2; j++) {
                    System.out.printf(" ");
                }
                System.out.printf("\n");
            }

            for (int i = k; i < n; i++) {
                for (int j = 0; j < space2; j++) {
                    System.out.printf(" ");
                }
                star++;
                for (int j = 0; j < star; j++) {
                    System.out.printf("*");
                }

                System.out.printf("\n");

            }
        }

    }
}
