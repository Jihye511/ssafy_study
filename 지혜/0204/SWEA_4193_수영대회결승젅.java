import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int x, y, time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time; // 시간 기준으로 오름차순 정렬 (우선순위 큐 사용)
    }
}

public class SWEA_4193_수영대회결승젅 {
    static int[][] map;
    static int N;
    static int[] depart = new int[2];
    static int[] arrival = new int[2];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            depart[0] = Integer.parseInt(st.nextToken());
            depart[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arrival[0] = Integer.parseInt(st.nextToken());
            arrival[1] = Integer.parseInt(st.nextToken());

            int result = bfs(depart[0], depart[1]);
            System.out.println("#" + t + " " + result);
        }
    }

    public static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        pq.offer(new Node(x, y, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();


            if (node.x == arrival[0] && node.y == arrival[1]) {
                return node.time;
            }

            if (visited[node.x][node.y]) continue;
            visited[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                int newTime = node.time + 1;

                if (map[nx][ny] == 2) {
                    if (newTime % 3 != 0) {
                        newTime += (3 - (newTime % 3));
                    }
                }

                pq.offer(new Node(nx, ny, newTime));
            }
        }
        return -1;
    }
}
