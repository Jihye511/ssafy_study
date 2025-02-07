import java.util.*;
import java.io.*;
import java.awt.*;


public class Boj_16973_직사각형_탈출 {
    static int N;
    static int M;
    static int H;
    static int W;
    static int sr,sc,fr,fc;
    static int result = Integer.MAX_VALUE;
    static int[][] map,dist;
    static ArrayList<Point> walls;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        dist = new int[N][M];
        walls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    walls.add(new Point(i,j));
                }
            }
        }

        input = br.readLine().split(" ");
        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);

        sr = Integer.parseInt(input[2])-1;
        sc = Integer.parseInt(input[3])-1;

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i],-1);
        }
        dist[sr][sc] = 0;

        fr = Integer.parseInt(input[4])-1;
        fc = Integer.parseInt(input[5])-1;

        //r + d + 직사각형 세로 범위 체크, 벽 체크

        visited = new boolean[N][M];

        bfs(sr,sc);
        System.out.println(dist[fr][fc]);

    }
    static void bfs(int r, int c) {
        Deque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(r,c));
        visited[r][c] = true;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!dq.isEmpty()) {
            Point p = dq.pollFirst();
            if (p.x == fr && p.y == fc) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];

                if(!inRange(nr,nc) || visited[nr][nc])
                    continue;

                boolean isValid = true;

                for(int j=0; j<walls.size(); j++){
                    int wallR = walls.get(j).x;
                    int wallC = walls.get(j).y;

                    if(wallR<nr+H && wallC<nc+W && wallR>=nr && wallC>=nc){
                        isValid = false;
                        break;
                    }
                }
                if(!isValid) {
                    continue;
                }

                dist[nr][nc] = dist[p.x][p.y] + 1;
                dq.add(new Point(nr, nc));
                visited[nr][nc] = true;
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && (r + H) <= N && (c + W) <= M;
    }
}
