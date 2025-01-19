import java.util.Scanner;

public class boj17135 {
    static int[][] map = new int[16][15];
    static int[][] mapsync = new int[16][15];
    static int N, M, D;
    static int kill = 0;
    static int max_kill = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < M; j++) {
            map[N][j] = 0;
        }

        dfs(0);
        System.out.println(max_kill);

        sc.close();
    }

    public static void dfs(int archer) {

        if (archer < 3) // 배치된 궁수가 3명 이하일때
        {
            for (int i = 0; i < M; i++) {

                if (map[N][i] != 1) {
                    map[N][i] = 1;
                    dfs(archer + 1);
                    map[N][i] = 0;
                }
            }
        }

        if (archer == 3) // 궁수를 다 배치했다면
        {
            while (isenemy()) {
                copyMap(mapsync, map);
                for (int i = 0; i < M; i++) // 한번씩 사격
                {
                    if (map[N][i] == 1) // i위치에 있는궁수가
                    {
                        if (isattack(i)) // 공격할 수 있는 사정거리에 적이 있다면
                        {
                            attack(i); // 공격
                        }
                    }
                }
                copyMap(map, mapsync); // 동기화
                forward();
            }
            max_kill = Math.max(kill, max_kill);
            kill = 0;
            return;
        }
    }

    public static void copyMap(int[][] target, int[][] source) {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                target[i][j] = source[i][j];
            }
        }
    }

    public static boolean isattack(int position) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) // 적 병사가 있을때
                {
                    if (Math.abs(i - N) + Math.abs(j - position) <= D) // 거리안에 있다면
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void attack(int position) {
        int[][] dist = new int[15][15];
        int min = 0;

        for (int i = 0; i < N; i++) // dist 배열 초기화
        {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) // dist 배열로 적의 거리 계산
        {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    dist[i][j] = Math.abs(i - N) + Math.abs(j - position);
                }
            }
        }

        min = min_dist(dist); // 가장 가까운 거리

        for (int j = 0; j < M; j++) // 행렬의 왼쪽부터 탐색
        {
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 1) // 적 병사가 있을때
                {
                    if (dist[i][j] <= D && dist[i][j] == min) // 거리안에 있고 거리가 최솟값이라면
                    {
                        if (mapsync[i][j] == 0) // 다른궁수로부터 이미 사격받았다면
                        {
                            return; // 킬 수를 올리지않음
                        }
                        mapsync[i][j] = 0; // 사살처리
                        kill++; // 사살
                        return;

                    }
                }
            }
        }
        return;
    }

    public static boolean isenemy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void forward() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    if (i + 1 != N) {
                        map[i + 1][j] = 1;
                    }
                }
            }
        }
        return;
    }

    public static int min_dist(int[][] dist) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                min = Math.min(min, dist[i][j]);
            }
        }
        return min;
    }
}
