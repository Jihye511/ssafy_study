package algo_Test;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class 마법사상어와파이어볼 {
    static int N, M, K;
    // 방향: 0: 위, 1: 오른쪽 위, 2: 오른쪽, 3: 오른쪽 아래, 4: 아래, 5: 왼쪽 아래, 6: 왼쪽, 7: 왼쪽 위
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Fireball {
        int r;
        int c;
        int m;
        int d;
        int s;
        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        Queue<Fireball> q = new ArrayDeque<>();
        
        // 초기 파이어볼 입력
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            q.add(new Fireball(r, c, m, s, d));
        }
        
        // K번의 이동
        for (int step = 0; step < K; step++) {
            // 각 셀에 도착한 파이어볼을 저장할 리스트 배열 (1-indexed)
            ArrayList<Fireball>[][] grid = new ArrayList[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    grid[i][j] = new ArrayList<>();
                }
            }
            
            // 모든 파이어볼 이동 (모듈로 연산 한 번만 적용)
            while (!q.isEmpty()) {
                Fireball fb = q.poll();
                int newR = ((fb.r - 1 + dr[fb.d] * fb.s) % N + N) % N + 1;
                int newC = ((fb.c - 1 + dc[fb.d] * fb.s) % N + N) % N + 1;
                fb.r = newR;
                fb.c = newC;
                grid[newR][newC].add(fb);
            }
            
            // 각 셀별로 파이어볼 합치기 및 분할 처리
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (grid[i][j].isEmpty()) continue;
                    // 파이어볼이 단 1개이면 그대로 다음 큐에 추가
                    if (grid[i][j].size() == 1) {
                        q.add(grid[i][j].get(0));
                    } else {
                        int sumMass = 0;
                        int sumSpeed = 0;
                        int count = grid[i][j].size();
                        boolean allEven = true;
                        boolean allOdd = true;
                        for (Fireball fb : grid[i][j]) {
                            sumMass += fb.m;
                            sumSpeed += fb.s;
                            if (fb.d % 2 == 0) {
                                allOdd = false;
                            } else {
                                allEven = false;
                            }
                        }
                        int newMass = sumMass / 5;
                        if (newMass == 0) continue;  // 질량 0이면 소멸
                        int newSpeed = sumSpeed / count;
                        int[] newDirs;
                        if (allEven || allOdd) {
                            newDirs = new int[]{0, 2, 4, 6};
                        } else {
                            newDirs = new int[]{1, 3, 5, 7};
                        }
                        // 4개의 파이어볼로 분할 생성
                        for (int d : newDirs) {
                        	q.add(new Fireball(i, j, newMass, newSpeed, d));
                        }
                    }
                }
            }
        }
        
        // 남아있는 모든 파이어볼의 질량 합산
        int ans = 0;
        while (!q.isEmpty()) {
            ans += q.poll().m;
        }
        System.out.println(ans);
    }
}
