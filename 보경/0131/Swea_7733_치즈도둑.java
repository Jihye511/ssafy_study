import java.io.*;
import java.util.*;

public class Swea_7733_치즈도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //bfs
        //무방향 막힐때까지 탐색
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] cheese = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] d_r = new int[]{-1,1,0,0};
            int[] d_c = new int[]{0,0,-1,1};
            int count = 1;  //이거때문에 TC 1개 틀렸음... 왜지..?

            //첫째날부터 100일까지 탐색
            for (int d = 1; d <= 100; d++) {
                boolean[][] visited = new boolean[N][N];
                int temp = 0;
                Deque<int[]> dq = new ArrayDeque<>();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && cheese[i][j] > d) {
                            dq.add(new int[]{i,j});
                            while (!dq.isEmpty()) {
                                int[] crr = dq.pollFirst();
                                if (!visited[crr[0]][crr[1]]) {
                                    if (cheese[crr[0]][crr[1]] > d) {
                                        visited[crr[0]][crr[1]] = true;
                                        for (int k = 0; k < 4; k++) {
                                            int nr = crr[0] + d_r[k];
                                            int nc = crr[1] + d_c[k];
                                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                                dq.add(new int[]{nr,nc});
                                                
                                            }
                                        }
                                    }
                                }
                            }
                            temp += 1;
                        }
                    }
                }
                count = Math.max(temp,count);
            }
            System.out.printf("#%d %d\n",t,count);
        }
    }
}
