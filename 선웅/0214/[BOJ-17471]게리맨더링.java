import java.util.*;

public class Main {
    public static int N;
    public static int[][] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] population = new int[N];

        for (int i = 0; i < N; i++) {
            population[i] = sc.nextInt();
        }

        graph = new int[N][];

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            graph[i] = new int[num];
            for (int j = 0; j < num; j++) {
                graph[i][j] = sc.nextInt() - 1;
            }
        }
        int gap = Integer.MAX_VALUE;
        for (int mask = 1; mask < (int) Math.pow(2, N) - 1; mask++) {
            if (check(mask)) {
                int total = 0;
                for (int i = 0; i < N; i++) {
                    if ((mask >> i) % 2 == 1) {
                        total -= population[i];
                    } else {
                        total += population[i];
                    }
                }
                total = Math.abs(total);
                gap = Math.min(gap, total);
            }
        }
        if(gap == Integer.MAX_VALUE){
            System.out.println(-1);
            sc.close();
            return;
        }
        System.out.println(gap);
        sc.close();
        return;
    }

    public static boolean check(int mask) {
        Queue<Integer> queue = new ArrayDeque<>();

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if ((mask >> i) % 2 == 1) {
                A.add(i);
            } else {
                B.add(i);
            }
        }

        boolean[] visited = new boolean[N];

        // 첫 번째 원소 방문
        queue.offer(A.get(0));
        visited[A.get(0)] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int a : graph[cur]) {
                if (A.contains(a) && !visited[a]) {
                    queue.offer(a);
                    visited[a] = true;
                }
            }
        }
        for (int a : A) {
            if (!visited[a]) {
                return false;
            }
        }

        // 다른 선거구 방문
        queue = new ArrayDeque<>();

        // 첫 번째 원소 방문
        queue.offer(B.get(0));
        visited[B.get(0)] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int b : graph[cur]) {
                if (B.contains(b) && !visited[b]) {
                    queue.offer(b);
                    visited[b] = true;
                }
            }
        }
        for (int b : B) {
            if (!visited[b]) {
                return false;
            }
        }

        return true;
    }
}