import java.io.*;
import java.util.*;

public class 백준_17135_캐슬디펜스 {
    static int N, M, D;
    static int[][] map;
    static int maxKill = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 배치 가능한 모든 경우의 수를 구하여 시뮬레이션
        combination(new int[3], 0, 0);
        System.out.println(maxKill);
    }

    // 궁수 위치 조합 만들기
    static void combination(int[] archers, int idx, int start) {
        if (idx == 3) {
            simulate(archers); // 궁수 위치 확정되면 시뮬레이션 실행
            return;
        }
        for (int i = start; i < M; i++) {
            archers[idx] = i;
            combination(archers, idx + 1, i + 1);
        }
    }

    // 시뮬레이션 실행
    static void simulate(int[] archers) {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }

        int killCount = 0;

        // N턴 동안 진행
        for (int turn = 0; turn < N; turn++) {
            // 각 턴마다 궁수들이 공격할 적의 위치를 저장
            Set<Pair> targets = new HashSet<>();

            // 각 궁수별로 가장 가까운 적을 찾음
            for (int archer : archers) {
                int[] target = findTarget(tempMap, N, archer);
                if (target != null) {
                    targets.add(new Pair(target[0], target[1]));
                }
            }

            // 찾은 적들을 한꺼번에 처리
            for (Pair target : targets) {
                if (tempMap[target.x][target.y] == 1) {
                    tempMap[target.x][target.y] = 0;
                    killCount++;
                }
            }

            // 적군 이동
            moveEnemies(tempMap);
        }

        maxKill = Math.max(maxKill, killCount);
    }

    // 좌표 저장을 위한 클래스
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // 궁수가 공격할 적 찾기
    static int[] findTarget(int[][] tempMap, int row, int col) {
        int[] target = null;
        int minDist = Integer.MAX_VALUE;

        // 맵에서 적이 있는 위치를 찾아 거리 계산
        for (int i = 0; i < N; i++) {  // N-1행까지만 확인 (성이 있는 행은 제외)
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 1) {
                    int dist = Math.abs(N - i) + Math.abs(col - j);  // 궁수는 N행에 있음
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && j < (target == null ? M : target[1]))) {
                            target = new int[]{i, j};
                            minDist = dist;
                        }
                    }
                }
            }
        }
        return target;
    }

    // 적 이동
    static void moveEnemies(int[][] tempMap) {
        for (int i = N - 1; i > 0; i--) {
            System.arraycopy(tempMap[i - 1], 0, tempMap[i], 0, M); // 깊은 복사
        }
        Arrays.fill(tempMap[0], 0); // 맨 위 행 초기화
    }
}
