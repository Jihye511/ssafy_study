import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Boj_7569_토마토 {
    static int M;
    static int N;
    static int H;
    static int[][][] tmt;
    static int notIk;  //익지 않은 토마토 개수 저장
    
    public static void main(String[] args) throws Exception {
        //3차원 bfs
        //1 : 익 , 0 : 익지않음 -1 : 토마토 없음
        //M:열크기 N : 행 H : 높이?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tmt = new int[H][N][M];
        //토마토 입력
        Deque<int[]> ik = new ArrayDeque<>(); //이미 익은 토마토 위치 저장
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int value =  Integer.parseInt(st.nextToken());
                    tmt[i][j][k] = value;
                    if (value == 1) {
                        ik.add(new int[]{i,j,k});
                    }

                    if (value == 0) {
                        notIk += 1;
                    }
                }
            }
        }

        int day = bfs(ik);
        if (notIk == 0) {
            System.out.println(day-1);
        }
        else {
            System.out.println(-1);
        }

    }

    static int bfs(Deque<int[]> dq) {
        //하루마다 익은 토마토 순회 이후 +1
        boolean[][][] visited = new boolean[H][N][M];

        int[] dd = {0,0,0,0,-1,1};
        int[] dr = {-1,1,0,0,0,0};
        int[] dc = {0,0,-1,1,0,0};

        int day = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            //각 날짜에 대한 토마토들 탐색
            for (int i = 0; i < size; i++) {
                int[] curr = dq.pollFirst();
                visited[curr[0]][curr[1]][curr[2]] = true;
                for (int d =0; d < 6; d++) {
                    int nd = curr[0] + dd[d];
                    int nr = curr[1] + dr[d];
                    int nc = curr[2] + dc[d];
                    if (inRange(nd, nr, nc) && !visited[nd][nr][nc] && tmt[nd][nr][nc] == 0) {
                        notIk -= 1;
                        visited[nd][nr][nc] = true;
                        tmt[nd][nr][nc] = 1;
                        dq.add(new int[] {nd,nr,nc});
                    }
                }
            }
            ++day;
        }
        return day;
    }

    static boolean inRange(int d, int r, int c) {
        return d >= 0 && d < H && r >= 0 && r < N && c >= 0 && c < M;
    }


}
