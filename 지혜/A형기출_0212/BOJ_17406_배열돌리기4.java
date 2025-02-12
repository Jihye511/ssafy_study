package A형기출_0210;
import java.io.*;
import java.util.*;

public class BOJ_17406_배열돌리기4 {
    static int N, M, K;
    static int[][] map;
    static int[][] turn;
    static boolean[] visited;
    static int[] seq;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        turn = new int[K][3];
        visited = new boolean[K];
        seq = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                turn[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 순열 생성
        generateList(0);
        System.out.println(minValue);
    }

    public static int getArrayValue(int[][] temp) {
        int minHap = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            int sum = 0;
            for (int j = 0; j < temp[0].length; j++) {
                sum += temp[i][j];
            }
            minHap = Math.min(minHap, sum);
        }
        return minHap;
    }

    public static void generateList(int idx) {
        if (idx == K) {
            int[][] temp = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, temp[i], 0, map[i].length);
            }

            // 순서대로 회전
            for (int i = 0; i < K; i++) {
                turnArray(seq[i], temp);
            }

            // 최솟값 갱신
            minValue = Math.min(minValue, getArrayValue(temp));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[idx] = i;
                generateList(idx + 1);
                visited[i] = false;
            }
        }
    }

    public static void turnArray(int idx, int[][] temp) {
        int r = turn[idx][0] - 1;
        int c = turn[idx][1] - 1;
        int s = turn[idx][2];

        for (int layer = 1; layer <= s; layer++) {
            int startX = r - layer, startY = c - layer;
            int endX = r + layer, endY = c + layer;

            int tempValue = temp[startX][startY]; // 시작 위치 값 저장

            // 왼쪽 세로 (위쪽으로 이동)
            for (int x = startX; x < endX; x++) {
                temp[x][startY] = temp[x + 1][startY];
            }
            // 아래쪽 가로 (왼쪽으로 이동)
            for (int y = startY; y < endY; y++) {
                temp[endX][y] = temp[endX][y + 1];
            }
            // 오른쪽 세로 (아래쪽으로 이동)
            for (int x = endX; x > startX; x--) {
                temp[x][endY] = temp[x - 1][endY];
            }
            // 위쪽 가로 (오른쪽으로 이동)
            for (int y = endY; y > startY + 1; y--) {
                temp[startX][y] = temp[startX][y - 1];
            }

            temp[startX][startY + 1] = tempValue;
        }
    }
}
