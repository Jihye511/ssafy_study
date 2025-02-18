import java.util.*;
import java.io.*;

public class Solution {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int maxLen;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim()); 

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  
            K = Integer.parseInt(st.nextToken()); 

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }

            maxLen = 0;  

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        visited = new boolean[N][N];
                        visited[i][j] = true;
                        dfs(i, j, 1, false);
                    }
                }
            }

            System.out.println("#" + t + " " + maxLen);
        }
    }

    static void dfs(int r, int c, int length, boolean usedCut) {
        maxLen = Math.max(maxLen, length);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }

            if (map[nr][nc] < map[r][c]) {
                visited[nr][nc] = true;
                dfs(nr, nc, length + 1, usedCut);
                visited[nr][nc] = false;
            } 
            else if (!usedCut) {
                int diff = map[nr][nc] - map[r][c];
                if (diff < K) {
                    int original = map[nr][nc];
                    map[nr][nc] = map[r][c] - 1;
                    
                    visited[nr][nc] = true;
                    dfs(nr, nc, length + 1, true);
                    visited[nr][nc] = false;
                    
                    map[nr][nc] = original;
                }
            }
        }
    }
}
