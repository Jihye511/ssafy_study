import java.io.*;
import java.util.*;

public class 정올_별삼각형2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n>100 || n%2==0 || m <1 || m > 4) {
            System.out.println("INPUT ERROR!");
            return;
        }

        if (m == 1) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int k = 0; k < i + 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = 0; i < n - (n / 2 + 1); i++) {
                for (int k = 0; k < n / 2 - i; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        if (m == 2) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 1; j < (n / 2 + 1) - i; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < i + 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = 0; i < n - (n / 2 + 1); i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < n / 2 - i; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        if (m == 3) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < n - i * 2; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = 0; i < n - (n / 2 + 1); i++) {
                for (int j = 0; j < (n / 2 - 1) - i; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < 3 + (i * 2); k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        if (m == 4) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < (n / 2 + 1) - i; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = 0; i < n - (n / 2 + 1); i++) {
                for (int j = 0; j < n / 2; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < (n % 2) + i + 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }
}