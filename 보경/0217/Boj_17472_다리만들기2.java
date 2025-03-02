import java.util.*;
import java.io.*;

public class Boj_17472_다리만들기2 {
    static ArrayList<ArrayList<int[]>> islands;
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<ArrayList<Island>> adjList;
    public static class Island implements Comparable<Island> {
        int v;  //섬 숫자
        int cost;

        public Island(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Island o) {
            return Integer.compare(this.cost,o.cost);
        }
    }

    //다리방향 유지, 길이 2이상
    //섬 각각의 위치 찾기
    //prim
    //도달할 수 있는지 확인 한 방향으로 쭉
    //가장 외각에 있는 점에서는 가로 세로 모두 가능, 가로 -> 세로방향만 가능 ,세로-> 가로
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //섬 덩어리 찾기
        int[] dr = new int[]{0,0,1,-1};
        int[] dc = new int[]{1,-1,0,0};

        int[][] numbering = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(numbering[i], -1);
        }

        islands = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && numbering[i][j] == -1){
                    ArrayList<int[]> island = new ArrayList<>();
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.add(new int[]{i,j});
                    island.add(new int[]{i,j});
                    numbering[i][j] = num;
                    while (!dq.isEmpty()) {
                        int[] curr = dq.pollFirst();
                        for (int d = 0; d < 4; d++) {
                            int nr = curr[0] + dr[d];
                            int nc = curr[1] + dc[d];
                            if (inRange(nr,nc) && numbering[nr][nc] == -1 && map[nr][nc] == 1) {
                                island.add(new int[]{nr,nc});
                                numbering[nr][nc] = num;
                                dq.add(new int[]{nr,nc});
                            }
                        }
                    }
                    islands.add(island);
                    num++;
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(numbering[i]));
//        }

        //인접리스트 초기화
        adjList = new ArrayList<>();
        for (int i = 0; i < islands.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        //인접섬 찾기
        //adjList
        //bfs 단 길이 2이상
        dr = new int[] {-1,0,1,0};
        dc = new int[] {0,1,0,-1};
        for (int i = 0; i < islands.size(); i++) {  //섬 개수만큼 반복
            int size = islands.get(i).size(); //땅 개수
            for (int j = 0; j < size; j++) {
                //각각의 땅으로부터 탐색 시작
                int[] curr= islands.get(i).get(j);
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    if (inRange(nr,nc) && map[nr][nc] == 0) {
                        //그 방향으로 탐색시작
                        int dist = 1;
                        while(true){
                            //끝에 도달하거나, 섬에 도달할 때까지
                            nr = curr[0] + dr[d] * dist;
                            nc = curr[1] + dc[d] * dist;
                            if (!inRange(nr,nc)) break;
                            if (map[nr][nc] == 1) {
                                if (numbering[nr][nc] == numbering[curr[0]][curr[1]]) {
                                    break;
                                }
                                //다른 섬 도달
                                if (dist > 2) {
                                    adjList.get(i).add(new Island(numbering[nr][nc],dist-1));
                                }
                                break;
                            }
                            dist++;
                        }
                    }
                }
            }
        }

        //prim
        int[] dist = new int[adjList.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] visited = new boolean[adjList.size()];
        PriorityQueue<Island> pq = new PriorityQueue<>();
        pq.add(new Island(0,0));

        while (!pq.isEmpty()) {
            Island curr = pq.poll();
            int nv = curr.v;
            if (visited[nv]) continue;
            visited[nv] = true;

            //nv와 연결된 정점 탐색
            for (Island island : adjList.get(nv)) {
                if (!visited[island.v] && dist[island.v] > island.cost) {
                    pq.add(island);
                    dist[island.v] = island.cost;
                }
            }
        }

//        System.out.println(Arrays.toString(dist));
        //디버깅
//        for (int i = 0; i < adjList.size(); i++) {
//            System.out.print("노드 " + i + " -> ");
//            if (adjList.get(i).isEmpty()) {
//                System.out.println("[]");
//            } else {
//                for (Island island : adjList.get(i)) {
//                    System.out.println(island.v + " " + island.cost + " "); // toString() 자동 호출됨
//                }
//                System.out.println();
//            }
//        }
        int result = 0;
        for (int i : dist) {
            if (i == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            result += i;
        }

        System.out.println(result);



    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
