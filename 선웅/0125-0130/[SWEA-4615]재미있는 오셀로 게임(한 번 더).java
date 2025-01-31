import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 보드 한 변의 길이(4, 6, 8)
            int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수

            // 보드를 1-based index로 관리하기 위해 N+1 크기로 생성
            int[][] board = new int[N + 1][N + 1];

            // 보드 중앙 초기화
            // 예: N=4 -> 가운데는 (2,2), (2,3), (3,2), (3,3)
            int mid = N / 2;
            // 백돌
            board[mid][mid] = 2;
            board[mid + 1][mid + 1] = 2;
            // 흑돌
            board[mid][mid + 1] = 1;
            board[mid + 1][mid] = 1;

            // M번 돌을 놓는다
            for (int i = 0; i < M; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int color = sc.nextInt(); // 1=흑, 2=백
                placeStone(board, r, c, color);
            }

            // 최종 흑돌, 백돌 세기
            int blackCount = 0;
            int whiteCount = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (board[i][j] == 1) blackCount++;
                    else if (board[i][j] == 2) whiteCount++;
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + blackCount + " " + whiteCount);
        }

        sc.close();
    }

    // 돌을 놓고 주변 적 돌을 뒤집는 함수
    private static void placeStone(int[][] board, int r, int c, int color) {
        board[r][c] = color;
        // 8방향 탐색하며 뒤집기
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        for (int[] d : directions) {
            flipStones(board, r, c, color, d[0], d[1]);
        }
    }

    // 특정 방향으로 돌을 뒤집는 함수
    private static void flipStones(int[][] board, int r, int c, int color, int dr, int dc) {
        int N = board.length - 1; // 1-based 인덱스 최대치
        int nr = r + dr;
        int nc = c + dc;
        // 한 칸 이동한 곳이 보드 범위 밖이거나, 빈칸이거나, 같은 색이면 뒤집을 수 없음
        if (!isValid(nr, nc, N) || board[nr][nc] == 0 || board[nr][nc] == color) {
            return;
        }
        // 반대 색을 만나면 더 진행하면서 같은 색 돌이 나오는지 확인
        List<int[]> flips = new ArrayList<>();
        while (true) {
            if (!isValid(nr, nc, N) || board[nr][nc] == 0) {
                return; // 빈칸이거나 범위 밖이면 뒤집기 불가
            }
            if (board[nr][nc] == color) {
                // 같은 색을 만나면 그 동안의 반대 색 돌 뒤집기
                for (int[] pos : flips) {
                    board[pos[0]][pos[1]] = color;
                }
                return;
            } else {
                // 반대 색을 만나면 뒤집을 후보 목록에 추가 후 계속 전진
                flips.add(new int[]{nr, nc});
            }
            nr += dr;
            nc += dc;
        }
    }

    // 보드 내부인지 확인
    private static boolean isValid(int r, int c, int N) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }
}
