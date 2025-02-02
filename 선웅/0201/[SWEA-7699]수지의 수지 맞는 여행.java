import java.io.*;
import java.util.*;
 
public class Solution {
    static int R, C, max;
    static char[][] board;
    static boolean[] visited;
    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
 
    public static void main(String[] args) throws Exception {
        // 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
         
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
             
            board = new char[R][C];
            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                board[i] = line.toCharArray();
            }
             
            // DFS 탐색 준비
            max = 0;
            visited = new boolean[26]; // A~Z 까지 알파벳 방문 체크
            // 시작 칸 (0,0)의 알파벳 방문 체크
            visited[board[0][0] - 'A'] = true;
            dfs(0, 0, 1);
             
            // 결과 출력
            System.out.println("#" + t + " " + max);
        }
    }
     
    // (x, y)에서 시작하여 현재까지 count개의 명물을 방문한 상태에서 DFS 수행
    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);
         
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 체크
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
             
            int index = board[nx][ny] - 'A';
            // 아직 방문하지 않은 명물인 경우
            if (!visited[index]) {
                visited[index] = true;
                dfs(nx, ny, count + 1);
                // 백트래킹: 다음 경로를 위해 방문 상태를 해제
                visited[index] = false;
            }
        }
    }
}