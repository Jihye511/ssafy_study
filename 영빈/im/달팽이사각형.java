import java.util.Scanner;

public class jo1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int num = 0;
        int x = 0;
        int y = n;
        int k = 0;

        while (num < n * n) {

            for (int i = 0; i < n - k; i++) {
                y--;
                num++;
                map[x][y] = num;
            }
            k++;
            for (int i = 0; i < n - k; i++) {
                x++;
                num++;
                map[x][y] = num;
            }
            for (int i = 0; i < n - k; i++) {
                y++;
                num++;
                map[x][y] = num;
            }

            k++;
            for (int i = 0; i < n - k; i++) {
                x--;
                num++;
                map[x][y] = num;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

    }
}