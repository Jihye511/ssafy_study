import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int N;
    static int[][] map;
    static List<int[]> cores;  
    static int maxConnected;   
    static int minLength;      
    
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            cores = new ArrayList<>();

            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            continue;
                        }
                        cores.add(new int[]{i, j});
                    }
                }
            }

            maxConnected = 0;       
            minLength = Integer.MAX_VALUE; 

            backtrack(0, 0, 0);

            System.out.println("#" + tc + " " + minLength);
        }
        sc.close();
    }


    static void backtrack(int index, int connected, int length) {
        if (index == cores.size()) {
            if (connected > maxConnected) {
                maxConnected = connected;
                minLength = length;
            } else if (connected == maxConnected) {
                if (length < minLength) {
                    minLength = length;
                }
            }
            return;
        }

        int[] core = cores.get(index);
        int r = core[0];
        int c = core[1];

        backtrack(index + 1, connected, length);

        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            int wireLength = 0;
            boolean canConnect = true;

            while (true) {
                nr += dr[d];
                nc += dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    break;
                }
                if (map[nr][nc] != 0) {
                    canConnect = false;
                    break;
                }
                wireLength++;
            }

            if (canConnect && wireLength > 0) {
                int tempR = r;
                int tempC = c;
                for (int i = 0; i < wireLength; i++) {
                    tempR += dr[d];
                    tempC += dc[d];
                    map[tempR][tempC] = 2;
                }

                backtrack(index + 1, connected + 1, length + wireLength);

                tempR = r;
                tempC = c;
                for (int i = 0; i < wireLength; i++) {
                    tempR += dr[d];
                    tempC += dc[d];
                    map[tempR][tempC] = 0; 
                }
            }
        }
    }
}
