import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 리스트로 해결해야 할듯
        List<Fireball> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 이 문제는 (1,1)부터 시작함
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Fireball(r, c, m, s, d));
        }

        for (int step = 0; step < K; step++) {
            ArrayList<Fireball>[][] board = new ArrayList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = new ArrayList<>();
                }
            }

            for (Fireball fb : list) {
                int nr = (fb.r + dr[fb.d] * fb.s) % N;
                int nc = (fb.c + dc[fb.d] * fb.s) % N;
                if (nr < 0)
                    nr += N;
                if (nc < 0)
                    nc += N;
                board[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
            }

            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int size = board[i][j].size();
                    if (size == 0) {
                        continue;
                    }
                    if (size == 1) {
                        list.add(board[i][j].get(0));
                    } else {
                        int sumM = 0, sumS = 0;
                        boolean allEven = true, allOdd = true;
                        for (Fireball fb : board[i][j]) {
                            sumM += fb.m;
                            sumS += fb.s;
                            if (fb.d % 2 == 0) {
                                allOdd = false;
                            } else {
                                allEven = false;
                            }
                        }
                        int newM = sumM / 5;
                        if (newM == 0)
                            continue;
                        int newS = sumS / size;
                        int[] newDirs = (allEven || allOdd) ? new int[] { 0, 2, 4, 6 } : new int[] { 1, 3, 5, 7 };
                        for (int d : newDirs) {
                            list.add(new Fireball(i, j, newM, newS, d));
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (Fireball fb : list) {
            answer += fb.m;
        }
        System.out.println(answer);
    }
}
