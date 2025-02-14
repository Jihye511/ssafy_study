import java.util.*;
import java.io.*;

public class Boj_17471_게리맨더링 {
    static int N;
    static boolean[][] adjMap;
    static ArrayList<ArrayList<Integer>> set1;
    static ArrayList<ArrayList<Integer>> set2;
    static int result;
    public static void main(String[] args) throws Exception {
        //선거구는 구역 적어도 하나 포함
        //각 구역 연결되어야함
        //각 구역 개수 차이 출력 -> 완탐
        //인접리스트 레츠고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  //구역 개수
        adjMap = new boolean[N+1][N+1];
        result = Integer.MAX_VALUE;

        //인구수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> popularity = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            popularity.put(i,Integer.parseInt(st.nextToken()));
        }

        //부분집합 찾고 연결되어 있는지 확인?
        for (int i = 1; i <= N; i++) { //각 지역
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            for (int j = 0; j < p; j++) {
                int v = Integer.parseInt(st.nextToken());
                adjMap[i][v] = true;
                adjMap[v][i] = true;
            }
        }

        set1 = new ArrayList<>();
        set2 = new ArrayList<>();

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i-1] = i;
        }

        getGroup(0,new boolean[N],arr);

        //돌면서 유효한 구역인지 확인
        for (int i = 0; i < set1.size() / 2; i++) {   //절반만 돌아도 어차피 같음
            if (isValid(set1.get(i)) && isValid(set2.get(i))) {
                int p1 = 0;
                for (int p : set1.get(i)) {
                    p1 += popularity.get(p);
                }
                int p2 = 0;
                for (int p : set2.get(i)) {
                    p2 += popularity.get(p);
                }

                result = Math.min(result, Math.abs(p1-p2));
                if (result == 0) {
                    break;
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }

    }

    static boolean isValid(ArrayList<Integer> arr) {
        boolean[] visited = new boolean[N+1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(arr.get(0));
        visited[arr.get(0)] = true;
        int cnt = 1;
        while (!dq.isEmpty()) {
            int curr = dq.pollFirst();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adjMap[curr][i] && arr.contains(i)) {
                    dq.add(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }

        if (cnt == arr.size()) {
            return true;
        }
        return false;
    }

    static void getGroup(int k, boolean[] sel,int[] arr) {
        if (sel.length == k) {
            //탐색 완료
            ArrayList<Integer> res1 = new ArrayList<>();
            ArrayList<Integer> res2 = new ArrayList<>();
            for (int i = 0; i < sel.length; i++) {
                if (sel[i]) {
                    res1.add(arr[i]);
                }
                else {
                    res2.add(arr[i]);
                }
            }

            if (res1.size() > 0 && res1.size() < N){
                set1.add(res1);
                set2.add(res2);
            }
            return;
        }
        sel[k] = true;
        getGroup(k+1,sel,arr);
        sel[k] = false;
        getGroup(k+1,sel,arr);
    }
}
