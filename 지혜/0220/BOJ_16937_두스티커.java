import java.io.*;
import java.util.*;
public class BOJ_16937_두스티커 {
    static int H,W,N;
    static int[] temp = new int[2];
    static int max = 0;
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        for(int i =0;i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int r= Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(Math.max(r, c) > Math.max(H, W) || Math.min(r,c) > Math.min(H, W)) continue;
            if (r > c) { // 항상 r이 작은 값이 되도록 정렬
                int temp = r;
                r = c;
                c = temp;
            }
                list.add(new int[] {r,c});
        }
        visited = new boolean[list.size()];
        //뽑기
        dfs(0,0);

        System.out.println(max);
    }
    public static boolean checkSize(int[] sticker) {
        //길이 조합 합으로 map의 변 길이 안에 다 있음 ok
        int[] first = list.get(sticker[0]);
        int[] second = list.get(sticker[1]);
        int r1 = first[0];
        int r2 = second[0];
        int c1 = first[1];
        int c2 = second[1];

        // 1. 첫 번째 스티커 가로, 두 번째 스티커 가로
        if (r1 + r2 <= H && Math.max(c1, c2) <= W) return true;
        if (r1 + r2 <= W && Math.max(c1, c2) <= H) return true;

        // 2. 첫 번째 스티커 세로, 두 번째 스티커 세로
        if (c1 + c2 <= W && Math.max(r1, r2) <= H) return true;
        if (c1 + c2 <= H && Math.max(r1, r2) <= W) return true;

        // 3. 첫 번째 스티커 가로, 두 번째 스티커 세로 (회전)
        if (r1 + c2 <= H && Math.max(c1, r2) <= W) return true;
        if (r1 + c2 <= W && Math.max(c1, r2) <= H) return true;

        // 4. 첫 번째 스티커 세로, 두 번째 스티커 가로 (회전)
        if (c1 + r2 <= W && Math.max(r1, c2) <= H) return true;
        if (c1 + r2 <= H && Math.max(r1, c2) <= W) return true;

        return false;
    }

    public static void dfs(int depth, int idx) {
        if(depth == 2) {
            if(checkSize(new int[]{temp[0], temp[1]})) {
                int[] cur1 = list.get(temp[0]);
                int[] cur2 = list.get(temp[1]);

                int size = (cur1[0] * cur1[1]) + (cur2[0] * cur2[1]);

                max = Math.max(max, size);
            }
            return;
        }


        for(int i =idx; i<list.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[depth] = i;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

}
