import java.util.*;

/**
 * @author: Sunwoong Moon
 * @time: about 1 hour
 */
public class Main {
    static int N, K, L;
    static boolean[][] board;

    static class Command {
        int time;
        char direction;

        Command(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    static Queue<Command> queue;
    static Deque<int[]> snake;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        board = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = true;
        }
        L = sc.nextInt();
        queue = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            queue.offer(new Command(sc.nextInt(), sc.next().charAt(0)));
        }
        snake = new ArrayDeque<>();
        snake.add(new int[] { 1, 1 });
        int answer = playGame();
        System.out.printf("%d", answer);
        sc.close();
    }

    public static int playGame() {
        int time = 0;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int dir = 0;
        Command c = queue.poll();
        while (true) {
            time += 1;

            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 1 || nx > N || ny < 1 || ny > N) {
                return time;
            }

            for (int[] cell : snake) {
                if (nx == cell[0] && ny == cell[1]) {
                    return time;
                }
            }

            snake.addFirst(new int[] { nx, ny });

            if (board[nx][ny]) {
                board[nx][ny] = false;
            } else {// 사과 못 먹으면 꼬리 자르기
                snake.removeLast();

            }

            if (c != null && c.time == time) {
                if (c.direction == 'D') {
                    dir = (dir + 1) % 4;
                } else if (c.direction == 'L') {
                    dir = (dir + 3) % 4;
                }
                c = queue.poll();
            }
        }
    }
}