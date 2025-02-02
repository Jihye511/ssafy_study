import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] box;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용하여 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수

        box = new int[N][M];
        Queue<Point> queue = new LinkedList<>();

        // 박스 정보 입력 및 초기 ripe tomato (1)을 queue에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        // BFS를 통해 토마토가 익는 날짜를 기록
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                // 범위를 벗어나면 continue
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                // 토마토가 없거나 이미 익은 경우 continue
                if (box[nx][ny] != 0)
                    continue;
                // 현재 토마토의 날짜 + 1을 저장 (익은 날짜 기록)
                box[nx][ny] = box[p.x][p.y] + 1;
                queue.offer(new Point(nx, ny));
            }
        }

        int maxDays = 0;
        // 박스를 순회하면서 익지 않은 토마토(0)가 있는지 확인하고, 최대 날짜를 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) { // 익지 않은 토마토가 있다면 모두 익지는 못하는 상황
                    System.out.println(-1);
                    return;
                }
                maxDays = Math.max(maxDays, box[i][j]);
            }
        }
        // 처음부터 모든 토마토가 익어있었다면 1이 기록되어 있으므로 -1을 해준다.
        System.out.println(maxDays - 1);
    }
}

// 좌표 정보를 저장하기 위한 클래스
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
