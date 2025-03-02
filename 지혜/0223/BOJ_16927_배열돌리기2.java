import java.util.*;
import java.io.*;
public class BOJ_16927_배열돌리기2 {
    static int N,M,R;
    static int[][] map;
    static int[]dx = {1,0,-1,0};
    static int[]dy = {0,1,0,-1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int layers = Math.min(N, M) / 2;
        int origN = N;
        int origM = M;

        for (int layer = 0; layer < layers; layer++) {
            int curN = origN - 2 * layer;
            int curM = origM - 2 * layer;
            int perimeter = 2 * (curN + curM - 2);
            int rotations = R % perimeter;

            for (int r = 0; r < rotations; r++) {
                rotate(layer, layer, layer + curN - 1, layer, layer + curN - 1, layer + curM - 1, layer, layer + curM - 1);
            }
        }

        for(int[] r : map) {
            for(int v: r) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void rotate(int fr, int fc, int sr,int sc, int tr, int tc, int lr,int lc ) {

        int temp;
        int before = map[fr][fc];
        //위 -> 아래
        for(int i =fr+1; i<=sr; i++ ) {

            temp = map[i][fc];
            map[i][fc] = before;
            before = temp;
        }
        //왼 - > 오
        for(int i = sc+1; i<=tc; i++) {
            temp = map[sr][i];
            map[sr][i] = before;
            before = temp;
        }
        //아래 -> 위
        for(int i = tr-1; i>=lr; i--) {
            temp = map[i][tc];
            map[i][tc] = before;
            before = temp;
        }
        //오 - > 왼
        for(int i=lc-1; i>=fc; i--) {
            temp = map[lr][i];
            map[lr][i]=before;
            before = temp;
        }

    }
}
