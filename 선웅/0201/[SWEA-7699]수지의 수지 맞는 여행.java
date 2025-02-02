import java.util.*;

public class Solution {
    static class Node {
        String alphabets;
        int r;
        int c;
        int distance;

        public Node(String alphabets, int r, int c, int distance) {
            this.alphabets = alphabets;
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        // test case만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            char[][] island = new char[R][C];
            for (int i = 0; i < R; i++) {
                String line = sc.next();
                for (int j = 0; j < C; j++) {
                    island[i][j] = line.charAt(j);
                }
            }
            System.out.println("#" + test_case + " " + bfs(island, R, C));
        }
        sc.close();
    }

    public static int bfs(char[][] island, int R, int C) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(island[0][0] + "", 0, 0, 1));
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        while (true){
            Node cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    boolean stop = false;
                    for(char c: cur.alphabets.toCharArray()){
                        if(c == island[nr][nc]){
                            stop = true;
                        }
                    }
                    if(stop){
                        continue;
                    }
                    queue.offer(new Node(cur.alphabets + island[nr][nc], nr, nc, cur.distance + 1));
                }
            }
            if(queue.isEmpty()){
                return cur.distance;
            }
        }
    }
}