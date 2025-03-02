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
        hurricane(0, 0);

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
        int width = M - 2 * left;
        int height = N - 2 * top;
        if (width <= 0 || height <= 0) {
            return;
        }
        // 큐에 차곡차곡 잘 모으자
        Queue<Integer> queue = new ArrayDeque<>();
        // 오른쪽 아래 꼭짓점 좌표 구해주자
        int right = M - 1 - left;
        int bottom = N - 1 - top;
        // 왼쪽으로~
        for (int y = left; y <= right; y++) {
            queue.offer(arr[top][y]);
        }
        // 위로~
        for (int x = top + 1; x <= bottom; x++) {
            queue.offer(arr[x][right]);
        }
        // 오른쪽으로~
        for (int y = right - 1; y >= left; y--) {
            queue.offer(arr[bottom][y]);
        }
        // 아래로~ 좌표 (top,left)는 바뀐 값이므로 나중에 넘겨주기
        for (int x = bottom - 1; x > top; x--) {
            queue.offer(arr[x][left]);
        }
        // 한 바퀴는 이러하다
        int round = 2 * (width - 1 + height - 1);
        // 가상으로 n바퀴 돌려보자
        int position = R % round;
        for (int i = 0; i < position; i++) {
            queue.offer(queue.poll());
        }
        // 이제 배치하자!
        // 왼쪽으로~
        for (int y = left; y <= right; y++) {
            arr[top][y] = queue.poll();
        }
        // 위로~
        for (int x = top + 1; x <= bottom; x++) {
            arr[x][right] = queue.poll();
        }
        // 오른쪽으로~
        for (int y = right - 1; y >= left; y--) {
            arr[bottom][y] = queue.poll();
        }
        // 아래로~ 좌표 (top,left)는 바뀐 값이므로 나중에 넘겨주기
        for (int x = bottom - 1; x > top; x--) {
            arr[x][left] = queue.poll();
        }
        // 또 돌려?
        hurricane(top + 1, left + 1);
    }
}