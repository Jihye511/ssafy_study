import java.util.*;
import java.io.*;

public class Swea_1767_프로세서연결하기 {
    static ArrayList<int[]> cores;
    static int N;
    static int[][] map;
    static int maxCore;
    static int minL;
    static int[] dr = new int[] {-1,1,0,0};
    static int[] dc = new int[] {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            cores = new ArrayList<>();
            maxCore = 0;
            minL = Integer.MAX_VALUE;


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && !inEdge(i, j)) {
                        cores.add(new int[]{i, j});
                    }
                }
            }

            dfs(0,0,0);

            System.out.printf("#%d %d\n",t,minL);
        }
    }

    //조합 + 백트래킹
    static void dfs(int idx, int cnt, int len) {
        if (idx == cores.size()) {
            //탐색 완료
            if (cnt > maxCore) {
                maxCore = cnt;
                minL = len;
            }
            else if (cnt == maxCore) {
                minL = Math.min(len,minL);
            }

            return;
        }

        int[] core = cores.get(idx);
        int r = core[0];
        int c = core[1];
        //탐색


        for (int d = 0; d < 4; d++) {
            int poss = wireLen(r,c,d);
            if (poss > 0) {
                //설치가능
                putWire(r,c,d,2);
                dfs(idx+1,cnt+1,len+poss);
                //제거 백트래킹
                putWire(r,c,d,0);
            }
        }

        //안 뽑는 경우
        dfs(idx+1, cnt,len);
    }

    static void putWire(int r, int c, int d, int v) {
        //2 -> 설치
        //0 -> 제거
        int nr = r + dr[d];
        int nc = c + dc[d];
        while (inRange(nr,nc)) {
            map[nr][nc] = v;
            nr += dr[d];
            nc += dc[d];
        }
    }

    static int wireLen(int r, int c, int d) {
        //해당 위치에서 전선 길이
        int nr = r + dr[d];
        int nc = c + dc[d];

        int len = 0; //전선길이
        while (inRange(nr,nc)) {
            if (map[nr][nc] != 0) return 0;
            nr += dr[d];
            nc += dc[d];
            len++;
        }

        return len;
    }

    static boolean inEdge(int r, int c) {
        return r == 0  || r == N-1|| c == 0|| c == N-1;
    }

    static boolean inRange(int r, int c) {
        return 0<=r && r < N && 0 <= c && c < N;
    }
}
