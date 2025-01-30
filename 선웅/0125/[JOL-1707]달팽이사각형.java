import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int direction = 1; // right = 1, down = 2, left = 3, up = 4
        int x = 0, y = 0;
        if (n < 1 || n > 100) {
            sc.close();
            return;
        }
        for (int i = 1; i <= n * n; i++) {
            arr[y][x] = i;
            switch (direction) {
                case 1:
                    if (x + 1 >= n || arr[y][x + 1] != 0) {
                        direction = 2;
                        y++;
                    } else {
                        x++;
                    }
                    break;
                case 2:
                    if (y + 1 >= n || arr[y + 1][x] != 0) {
                        direction = 3;
                        x--;
                    } else {
                        y++;
                    }
                    break;
                case 3:
                    if (x - 1 < 0 || arr[y][x - 1] != 0) {
                        direction = 4;
                        y--;
                    } else {
                        x--;
                    }
                    break;
                case 4:
                    if (y - 1 < 0 || arr[y - 1][x] != 0) {
                        direction = 1;
                        x++;
                    } else {
                        y--;
                    }

                    break;
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%d ", arr[r][c]);
            }
            System.out.println();
        }
        sc.close();
    }
}