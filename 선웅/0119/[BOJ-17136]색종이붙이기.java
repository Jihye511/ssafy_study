import java.util.Scanner;

public class Main {
    // 10x10 보드판
    static int[][] board = new int[10][10];
    // 종이 개수 (0번째는 제외)
    static int[] paper = {0, 5, 5, 5, 5, 5}; 
    

    static int answer = Integer.MAX_VALUE; // 최소 색종이 개수를 저장할 변수 (처음엔 최대값으로로)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // DFS 시작
        dfs(0, 0, 0);

        // 결과 출력
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    /**
     * (row, col) 위치부터 탐색
     * 지금까지 사용한 색종이 개수 = usedCount
     */
    static void dfs(int row, int col, int usedCount) {
        // 만약 현재까지 사용한 색종이 수가 이미 answer 이상이면 백트래킹
        if (usedCount >= answer) return;

        // 열이 범위를 넘어가면 다음 행으로 넘어감
        if (col == 10) {
            dfs(row + 1, 0, usedCount);
            return;
        }

        // 행이 범위를 넘어가면 즉, 모든 칸을 확인했다면 answer 갱신 후 종료
        if (row == 10) {
            answer = Math.min(answer, usedCount);
            return;
        }

        // 만약 현재 칸이 0이면, 색종이 붙일 필요 없으므로 다음 칸으로 이동
        if (board[row][col] == 0) {
            dfs(row, col + 1, usedCount);
        } else {
            // 현재 칸이 1이면, 큰 색종이부터 작은 색종이까지 모두 시도
            for (int size = 5; size >= 1; size--) {
                // 해당 size 색종이가 남아 있고, (row, col)에 놓을 수 있다면
                if (paper[size] > 0 && canAttach(row, col, size)) {
                    // 색종이를 놓는다. 즉, 해당 영역을 0으로 덮는다
                    attach(row, col, size, 0);
                    paper[size]--;

                    // 다음 칸 탐색
                    dfs(row, col + 1, usedCount + 1);

                    // 백트래킹 - 복원
                    attach(row, col, size, 1);
                    paper[size]++;
                }
            }
        }
    }

    /**
     * (r, c) 위치부터 size×size 범위를 val로 덮거나 되돌린다.
     * - val이 0이면 색종이를 놓는 것(1->0으로 바꾸기)
     * - val이 1이면 원상태로 되돌리기(0->1로 복원)
     */
    static void attach(int r, int c, int size, int val) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = val;
            }
        }
    }

    /**
     * (r, c)에 size×size 색종이를 놓을 수 있는지 확인
     */
    static boolean canAttach(int r, int c, int size) {
        // 보드를 벗어나는지 확인
        if (r + size > 10 || c + size > 10) {
            return false;
        }
        // 모두 1인지 확인
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
