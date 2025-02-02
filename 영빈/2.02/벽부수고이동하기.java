import java.util.*;

public class boj2206 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int n, m;
    static int[][] board;
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.valueOf(str.charAt(j)) - '0';
            }
        }

        visited = new boolean[n][m][2];
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y][0] = true; // 0은 벽을 부시지 않고 방문한 노드의 방문 여부
        visited[x][y][1] = true; // 1은 벽을 부시면서 방문한 노드의 방문 여부

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == n - 1 && current.y == m - 1)
                return current.count;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == 0) { // 벽이 아닐 때
                        if (visited[nx][ny][current.wall] == false) { // 현재까지 온 방법(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
                            q.add(new Node(nx, ny, current.count + 1, current.wall));
                            visited[nx][ny][current.wall] = true;
                        }
                    } else if (board[nx][ny] == 1) { // 벽일때
                        if (current.wall == 0 && visited[nx][ny][1] == false) { // 현재까지 벽을 부순적이 없고, 벽을 부숴서 방문한 적이 없다면
                                                                                // 방문한다.
                            q.add(new Node(nx, ny, current.count + 1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static class Node {
        private int x;
        private int y;
        private int count;
        private int wall; // 벽을 부시면서 왔는지 아닌지. 0이면 아니고 1이면 벽을 부시면서 왔다는 것을 의미한다.

        public Node(int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }
}
