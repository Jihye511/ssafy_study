import java.util.*;
import java.io.*;

public class Boj_17144_미세먼지안녕 {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static List<Integer> cleaner = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleaner.add(i);
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        //t초 반복
        for (int t = 0; t < T; t++) {

            //먼지 확산
            int[][] temp = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0 ; j < C; j++) {
                    if (map[i][j] == -1) {
                        //공청 자리
                        temp[i][j] = -1;
                        continue;
                    }

                    temp[i][j] += map[i][j];

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (!inRange(nr,nc)) continue;
                        if (map[nr][nc] == -1) continue;

                        temp[nr][nc] += (map[i][j] / 5);
                        temp[i][j] -= (map[i][j] / 5);
                    }
                }
            }
            map = temp;

            //공기청정기
            cleaner();
        }

        // 계산
        int sum = 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static void cleaner() {
        // 위쪽 반시계방향
        int top = cleaner.get(0);

        for (int r = top - 1; r > 0; r--) {
            map[r][0] = map[r-1][0];
        }

        for (int c = 0; c < C - 1; c++) {
            map[0][c] = map[0][c+1];
        }

        for (int r = 0; r < top; r++) {
            map[r][C-1] = map[r+1][C-1];
        }

        for (int c = C - 1; c > 1; c--) {
            map[top][c] = map[top][c-1];
        }

        map[top][1] = 0;


        // 아래쪽 시계 방향
        int bottom = cleaner.get(1);

        for (int r = bottom + 1; r < R - 1; r++) {
            map[r][0] = map[r+1][0];
        }

        for (int c = 0; c < C - 1; c++) {
            map[R-1][c] = map[R-1][c+1];
        }

        for (int r = R - 1; r > bottom; r--) {
            map[r][C-1] = map[r-1][C-1];
        }

        for (int c = C - 1; c > 1; c--) {
            map[bottom][c] = map[bottom][c-1];
        }

        map[bottom][1] = 0;
    }
}

