package A형기출_0210;

import java.io.*;
import java.util.*;

public class BOJ_17471_게리맨더링 {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] adjList;
    static boolean[] selected;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        population = new int[N + 1];
        adjList = new ArrayList[N + 1];
        selected = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());
                adjList[i].add(next);
                adjList[next].add(i);
            }
        }

        // 부분 집합을 이용하여 선거구 나누기
        dfs(1);


        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    static void dfs(int idx) {
        if (idx > N) {
            // 최소 한 개씩 나눠졌는지 확인
            if (isDivided()) {
                int diff = calculatePopulationDifference();
                minDifference = Math.min(minDifference, diff);
            }
            return;
        }

        // A구역에 포함
        selected[idx] = true;
        dfs(idx + 1);

        // B구역에 포함
        selected[idx] = false;
        dfs(idx + 1);
    }

    static boolean isDivided() {
        boolean[] visited = new boolean[N + 1];
        int areaA = -1, areaB = -1;

        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                areaA = i;
            } else {
                areaB = i;
            }
        }

        if (areaA == -1 || areaB == -1) return false;

        return bfs(areaA, true, visited) && bfs(areaB, false, visited);
    }

    static boolean bfs(int start, boolean isA, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            for (int next : adjList[cur]) {
                if (!visited[next] && selected[next] == isA) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        int expectedCount = 0;
        for (int i = 1; i <= N; i++) {
            if (selected[i] == isA) expectedCount++;
        }

        return count == expectedCount;
    }

    static int calculatePopulationDifference() {
        int sumA = 0, sumB = 0;

        for (int i = 1; i <= N; i++) {
            if (selected[i]) sumA += population[i];
            else sumB += population[i];
        }

        return Math.abs(sumA - sumB);
    }
}
