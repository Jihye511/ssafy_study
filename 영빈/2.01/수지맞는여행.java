import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int n = 0, m = 0;
    static char[][] map = null;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visit = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine()); // tc개수
        for (int t = 1; t <= tc; t++) {
            // --- input start ---
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            set = new HashSet<>();
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j);
                }
            } // --- input end ---
            set.add(map[0][0]);
            visit[0][0] = true;
            max = 0;
            dfs(0, 0, 1);
            sb.append("#").append(t).append(" ").append(max).append("\n"); // 결과 입력
        } // end of tc

        // visit[0][0] = true; // --- 초기값 설정 end ---

        System.out.println(sb);
    } // end of main

    static Set<Character> set = new HashSet<>();

    private static void dfs(int r, int c, int level) {
		max = Math.max(max, level);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= n || nc < 0 || nc >= m)
				continue;

			if (set.contains(map[nr][nc])) { // 이미 방문한 유물이면
				continue;
			} else if (!visit[nr][nc]) {
				visit[nr][nc] = true;
				set.add(map[nr][nc]); // 새 알파벳 추가
				dfs(nr, nc, level + 1);
				set.remove(map[nr][nc]);
				visit[nr][nc]=false;
			}
		}

	}
} // end of class
[출처][SWEA 7699,자바]

수지의 수지맞는 여행-2
가지 풀이|
작성자
jun9