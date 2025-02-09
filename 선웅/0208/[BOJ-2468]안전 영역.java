import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        
        int minHeight = 101;
        int maxHeight = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        
        int maxSafeZones = 1; // 아무 지역도 물에 잠기지 않는 경우 최소값 1
        
        for (int h = minHeight; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        count++;
                        dfs(i, j, h);
                    }
                }
            }
            maxSafeZones = Math.max(maxSafeZones, count);
        }
        
        System.out.println(maxSafeZones);
        sc.close();
    }
    
    static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] > height) {
                    dfs(nx, ny, height);
                }
            }
        }
    }
}
