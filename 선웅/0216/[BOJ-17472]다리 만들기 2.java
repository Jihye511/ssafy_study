import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[][] islandId;
    static int islandCount;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        islandId = new int[N][M];
        islandCount = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (grid[i][j] == 1 && islandId[i][j] == 0) {
                    islandCount++;
                    bfs(i, j, islandCount);
                }
            }
        }
        
        int[][] dist = new int[islandCount + 1][islandCount + 1];
        for (int i = 1; i <= islandCount; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (islandId[i][j] > 0) {
                    int currentIsland = islandId[i][j];
                    for (int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        int len = 0;
                        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (islandId[nx][ny] == currentIsland) break;
                            if (islandId[nx][ny] == 0) {
                                len++;
                                nx += dx[d];
                                ny += dy[d];
                            } else { 
                                if (len >= 2) {
                                    int otherIsland = islandId[nx][ny];
                                    dist[currentIsland][otherIsland] = Math.min(dist[currentIsland][otherIsland], len);
                                    dist[otherIsland][currentIsland] = Math.min(dist[otherIsland][currentIsland], len);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= islandCount; i++){
            for (int j = i + 1; j <= islandCount; j++){
                if (dist[i][j] != Integer.MAX_VALUE) {
                    edges.add(new Edge(i, j, dist[i][j]));
                }
            }
        }
        
        Collections.sort(edges, Comparator.comparingInt(e -> e.cost));
        int[] parent = new int[islandCount + 1];
        for (int i = 1; i <= islandCount; i++){
            parent[i] = i;
        }
        
        int result = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (find(parent, edge.from) != find(parent, edge.to)) {
                union(parent, edge.from, edge.to);
                result += edge.cost;
                count++;
            }
        }
        
        if (count == islandCount - 1) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
    
    static void bfs(int i, int j, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        islandId[i][j] = id;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (grid[nx][ny] == 1 && islandId[nx][ny] == 0) {
                        islandId[nx][ny] = id;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    
    static int find(int[] parent, int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent, parent[a]);
    }
    
    static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    
    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
