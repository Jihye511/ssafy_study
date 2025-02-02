import java.util.*;
import java.io.*;

public class Swea_7699_수지의_수지_맞는_여행 {
    static int result, N, M;
    public static void main(String[] args) throws Exception {
        //각 알파벳 처음일 때만 방문 -> 1차원 방문 체크
        //최대로 볼 수 있는 명물 수
        //dfs

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            result = 0;
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            Set<Character> visited = new HashSet<>();  //알파벳 방문체크
            //입력
            char[][] maps = new char[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    maps[i][j] = line.charAt(j);
                }
            }

            //dfs
            dfs(0,0,1,visited,maps);

            System.out.printf("#%d %d\n", t, result);

        }
    }

    static void dfs(int r, int c, int cnt, Set<Character> visited, char[][] maps) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        visited.add(maps[r][c]);
        result = Math.max(result,cnt);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc)) {
                if (visited.add(maps[nr][nc])){
                    dfs(nr,nc,cnt+1,visited,maps);
                }

            }
        }

        visited.remove(maps[r][c]);  //백트래킹
    }

    static boolean inRange(int r, int c) {
        return 0<= r && r < N && 0<=c && c < M;
    }
}
