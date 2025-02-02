import java.io.*;
import java.util.*;

public class Main {
    // 각 상태를 저장하는 Node 클래스입니다.
    // x, y: 현재 좌표, dist: 시작점부터 현재까지 이동한 칸의 수, wall: 벽 부순 여부 (0이면 안 부숨, 1이면 부숨)
    static class Node {
        int x, y, dist, wall;
        public Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        
        // 문자열을 한 줄씩 읽어서 맵에 저장합니다.
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        int result = bfs(map, N, M);
        System.out.println(result);
    }
    
    // BFS 메서드: 최단 경로를 찾으며, 벽을 최대 한 번 부수는 경우를 고려합니다.
    static int bfs(int[][] map, int N, int M) {
        // visited[x][y][k] : (x, y) 위치에, k (0 또는 1) 상태로 방문했는지 체크합니다.
        boolean[][][] visited = new boolean[N][M][2];
        // 상하좌우 이동을 위한 방향 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<Node> queue = new LinkedList<>();
        // 시작점 (0, 0)에서 벽을 부수지 않은 상태(wall = 0)로 시작하며, 칸의 수는 1부터 시작합니다.
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 도착지에 도달하면 현재까지 이동한 칸의 수를 반환합니다.
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }
            
            // 네 방향으로 이동 시도
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                // 이동할 좌표가 범위 내에 있는지 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 다음 칸이 빈 칸(0)인 경우
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.wall]) {
                        visited[nx][ny][cur.wall] = true;
                        queue.add(new Node(nx, ny, cur.dist + 1, cur.wall));
                    }
                    // 다음 칸이 벽(1)인 경우, 아직 벽을 부수지 않았다면 벽을 부수고 이동
                    if (map[nx][ny] == 1 && cur.wall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, cur.dist + 1, 1));
                    }
                }
            }
        }
        // 모든 경로를 탐색해도 도착지에 도달하지 못하면 -1을 반환합니다.
        return -1;
    }
}
