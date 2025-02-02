import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] box;
    // 상, 하, 좌, 우
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용하여 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
            h = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수
            int[][] map = new int[h][w];
            // 둘 다 0이면 애플리케이션 종료
            if (w == 0 && h == 0) {
                return;
            }
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[][] visited = new boolean[h][w];
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        bfs(map, i, j, visited);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }


    public static void bfs(int[][] map, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 8; i++) {
                int newX = cx + dx[i];
                int newY = cy + dy[i];
                if (newX < 0 || newX >= h || newY < 0 || newY >= w) {
                    continue;
                }
                if (map[newX][newY] == 0 || visited[newX][newY]) {
                    continue;
                }
                visited[newX][newY] = true;
                queue.offer(new int[] { newX, newY });
            }
        }
    }
}
