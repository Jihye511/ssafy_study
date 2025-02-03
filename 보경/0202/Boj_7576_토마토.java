import java.util.*;
import java.io.*;
public class Boj_7576_토마토 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //토마토 없을 수도 있음
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        //1 : 익음, 0 : 익지 않음 -1 : 없음
        int[][] tmt = new int[N][M];
        int tmtcount = 0;
        int ik = 0;
        int task = 0;
        //bfs
        Deque<int[][]> dq = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tmt[i][j] = Integer.parseInt(st.nextToken());
                if (tmt[i][j] == 1) {
                    tmtcount += 1;
                    ik += 1;
                    dq.add(new int[][]{{i,j}});
                }
                else if (tmt[i][j] == 0) {
                    task += 1;
                    tmtcount += 1;
                }
            }
        }

        if (tmtcount == ik) {
            System.out.println(0);
            return;
        }

        int day = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!dq.isEmpty()) {
            int len = dq.size();
            for (int i = 0; i < len; i++){
                int[][] curr = dq.pollFirst();
                int r = curr[0][0];
                int c = curr[0][1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (inRange(nr,nc,N,M) && tmt[nr][nc] == 0) {
                        tmt[nr][nc] = 1;
                        task--;
                        dq.add(new int[][]{{nr,nc}});
                    }
                }
            }
            if (dq.size() > 0) {
                day++;
            }
        }

        if (task > 0) {
            System.out.println(-1);
        }

        else {
            System.out.println(day);
        }

    }

    static boolean inRange(int r, int c, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
