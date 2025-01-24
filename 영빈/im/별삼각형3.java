import java.util.Scanner;

public class jo1329 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = n / 2 + 1;
        int star = -1;
        int space = -1;
        if (n % 2 != 1 || n > 100) {
            System.out.println("INPUT ERROR!");
            return;
        }

        for (int i = 0; i < k; i++) {
            space++;
            for (int j = 0; j < space; j++) {
                System.out.printf(" ");

            }

            star += 2;
            for (int j = 0; j < star; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");

        }

        for (int i = k; i < n; i++) {
            space--;
            for (int j = 0; j < space; j++) {
                System.out.printf(" ");
            }

            star -= 2;
            for (int j = 0; j < star; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");

        }

    }
}
