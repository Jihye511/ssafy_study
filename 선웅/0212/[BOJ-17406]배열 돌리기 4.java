import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static boolean[] visited;
    static int N, M, K;
    static int[] perm;
    static int[][] arr;
    static int[] r, c, s;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        r = new int[K];
        c = new int[K];
        s = new int[K];

        for (int i = 0; i < K; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[K];
        perm = new int[K];
        permutation(0);
        System.out.println(min);
        br.close();
    }

    public static void permutation(int index) {
        if (index == K) {
            simulation();
        }
        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            perm[index] = i;
            permutation(index + 1);
            visited[i] = false;
        }
    }

    public static void simulation() {
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int[][] simArr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                simArr[i][j] = arr[i][j];
            }
        }
        for (int i : perm) {
            for (int layer = 1; layer <= s[i]; layer++) {
                int startX = r[i] - layer;
                int startY = c[i] - layer;
                int endX = r[i] + layer;
                int endY = c[i] + layer;
            
                int temp = simArr[startX][startY];  // 시작점 값 저장
            
                // 왼쪽 열 위로 이동
                for (int x = startX; x < endX; x++) {
                    simArr[x][startY] = simArr[x + 1][startY];
                }
                // 아래쪽 행 왼쪽으로 이동
                for (int y = startY; y < endY; y++) {
                    simArr[endX][y] = simArr[endX][y + 1];
                }
                // 오른쪽 열 아래로 이동
                for (int x = endX; x > startX; x--) {
                    simArr[x][endY] = simArr[x - 1][endY];
                }
                // 위쪽 행 오른쪽으로 이동
                for (int y = endY; y > startY; y--) {
                    simArr[startX][y] = simArr[startX][y - 1];
                }
            
                // 마지막 값 복구
                simArr[startX][startY + 1] = temp;
            }
            
        }
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += simArr[i][j];
            }
            min = Math.min(min, sum);
        }

    }
}