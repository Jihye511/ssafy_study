import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr;
    static int i = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                arr[x][y] = sc.nextInt();
            }
        }
        
        // 회전 회오리!
        for (int turn = 0; turn < R; turn++) {
            hurricane(0, 0);
        }

        // 어지러워~
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                System.out.printf("%d ", arr[x][y]);
            }
            System.out.println();
        }
        sc.close();
    }

    // 돌려 돌려 돌림판~~
    public static void hurricane(int top, int left) {
        int first = arr[top][left];
        int width = M - 2 * left;
        int height = N - 2 * top;
        if (width <= 0 || height <= 0) {
            return;
        }
        int right = M - 1 - left;
        int bottom = N - 1 - top;
        // 왼쪽으로~
        for (int y = left + 1; y <= right; y++) {
            arr[top][y - 1] = arr[top][y];
        }
        // 위로~
        for (int x = top + 1; x <= bottom; x++) {
            arr[x - 1][right] = arr[x][right];
        }
        // 오른쪽으로~
        for (int y = right - 1; y >= left; y--) {
            arr[bottom][y + 1] = arr[bottom][y];
        }
        // 아래로~ 좌표 (top,left)는 바뀐 값이므로 나중에 넘겨주기
        for (int x = bottom - 1; x >= top; x--) {
            arr[x + 1][left] = arr[x][left];
        }
        arr[top + 1][left] = first;
        // 또 돌려?
        hurricane(top + 1, left + 1);
    }
}