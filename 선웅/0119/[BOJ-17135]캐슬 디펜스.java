import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] board;        // 게임 보드
    static int answer = 0;       // 적을 최대 몇 명 제거할 수 있는지 저장하는 변수
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        
        board = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        // 궁수를 배치할 수 있는 모든 위치 시뮬레이션
        for(int c1 = 0; c1 < M - 2; c1++){
            for(int c2 = c1 + 1; c2 < M - 1; c2++){
                for(int c3 = c2 + 1; c3 < M; c3++){
                    // 각 조합 별로 나온 적 처치 수
                    int killCount = simulate(new int[]{c1, c2, c3});
                    // 최댓값을 정답으로 저장
                    answer = Math.max(answer, killCount);
                }
            }
        }
        
        System.out.println(answer);

        sc.close();
    }
    
    /**
     * 궁수 3명 위치(archers[])가 주어졌을 때 게임을 시뮬레이션하고, 제거한 적의 수를 반환
     * @param archers
     * @return
     */
    static int simulate(int[] archers) {
        // 보드 복사 (원본 보드를 유지하기 위해)
        int[][] copyBoard = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copyBoard[i][j] = board[i][j];
            }
        }
        
        int count = 0; // 제거한 적 수
        
        // N번의 턴(맨 위의 적이 최대 N번만큼 내려올 수 있으므로)
        for(int turn = 0; turn < N; turn++){
            // 이번 턴에 궁수들이 공격할 적 위치를 찾아서 저장(중복 제거를 위해 Set 사용)
            Set<int[]> enemiesToKill = new HashSet<>();
            
            for(int archer = 0; archer < 3; archer++){
                int col = archers[archer];
                
                // 적 찾기(궁수 위치는 N+1번째 줄, col열)
                int[] enemy = findEnemy(copyBoard, N, col);
                if(enemy != null) {
                    enemiesToKill.add(enemy); // 중복 방지
                }
            }
            
            // 찾은 적 제거하기
            for(int[] e : enemiesToKill){
                if(copyBoard[e[0]][e[1]] == 1){
                    copyBoard[e[0]][e[1]] = 0;
                    count++;
                }
            }
            
            // 적들을 한 칸 아래로 이동하기
            moveDown(copyBoard);
        }
        
        return count;
    }
    
    /**
     * 궁수의 위치에서 거리 D 이하인 적 중 가장 가까운 적을 찾는다.
     * 같은 거리 내 여러 명이면 더 왼쪽인 적 선택
     * @param map
     * @param archerRow
     * @param archerCol
     * @return
     */
    static int[] findEnemy(int[][] map, int archerRow, int archerCol){
        // 가까운 적부터 찾기(거리 1부터 거리d순서로)
        for(int d = 1; d <= D; d++){
            
            for(int colShift = -d+1; colShift < d; colShift++){
                int row = archerRow - (d - Math.abs(colShift));
                int col = archerCol + colShift;
                
                // 범위 확인
                if(row < 0 || col < 0 || col >= M) continue;
                
                // 적이 있으면 적의 위치 반환
                if(map[row][col] == 1) {
                    return new int[]{row, col};
                }
            }
            
        }
        
        return null;
    }
    
   /**
    * 보드를 한 칸 아래로 이동
    * @param map
    */
    static void moveDown(int[][] map) {
        // N-1행부터 1행까지를 아래로 복사
        for(int row = N-1; row > 0; row--){
            for(int col = 0; col < M; col++){
                map[row][col] = map[row-1][col];
            }
        }
        // 맨 윗줄은 0
        for(int col = 0; col < M; col++){
            map[0][col] = 0;
        }
    }
}
