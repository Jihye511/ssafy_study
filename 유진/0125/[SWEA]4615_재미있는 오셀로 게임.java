import java.util.Scanner;

public class Solution {
	static int[][] map; 
    static int[] score;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            score = new int[3];
            score[1] = 2;
            score[2] = 2;
             
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            map = new int[N][N];
            map[N/2-1][N/2-1] = 2;
            map[N/2][N/2] = 2;
            map[N/2-1][N/2] = 1;
            map[N/2][N/2-1] = 1;
             
            int x, y, p;
            int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
            int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
             
            for(int i = 0; i < M; i++) {
                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
                p = sc.nextInt();
                 
                map[y][x] = p; // map에 현재 플레이어의 돌 두기 
                score[p]++; // 현재 플레이어의 돌 개수++
                 
                // 8방 탐색
                for(int d = 0; d < 8; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    boolean check = false;
                     
                    // 인접 칸이 범위 내 & 다른 색 돌이 있는 경우 
                    if(inMap(ny, nx) && map[ny][nx] != 0 && map[ny][nx] != map[y][x]) {
                        ny = ny + dy[d];
                        nx = nx + dx[d];
                         
                        // 같은 방향으로 계속 탐색 
                        while(inMap(ny, nx)) {
                            // 같은 색 돌로 막혀있는 경우 
                            if(map[ny][nx] == map[y][x]) {
                                check = true;
                                break;
                            }
                            // 돌이 놓여있지 않은 경우 
                            if(map[ny][nx] == 0) {
                                break;
                            }
                            ny = ny + dy[d];
                            nx = nx + dx[d];
                        }
                         
                        //같은 색 돌로 막혀있는 경우, 사이에 있는 돌 뒤집기 + 돌 개수 갱신 
                        if(check) {
                            ny = y + dy[d];
                            nx = x + dx[d];
                             
                            while(map[ny][nx] != map[y][x]) {
                                score[p]++;
                                score[map[ny][nx]]--;
                                 
                                map[ny][nx] = map[y][x];
                                 
                                ny = ny + dy[d];
                                nx = nx + dx[d];
                            }
                        }
                    }
                }
            }
 
            System.out.println("#"+ test_case+" "+ score[1] + " " + score[2]);
        }
    }
    public static boolean inMap(int y, int x) {
        return (0 <= y && y < map.length && 0 <= x && x < map.length);
    }
}



