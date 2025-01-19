import java.io.*;
import java.util.*;
public class 백준_17136_색종이붙이기 {
    static int[][] map;
    //색종이 얼마나 필요한지 체크
    static int [] paper={0,5,5,5,5,5};
    static int res= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        map = new int[10][10];
        for(int i =0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<10; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        //탐색
        dfs(0,0,0);
        if(res == Integer.MAX_VALUE){
            res =-1;
        }
        System.out.println(res);

    }
    public static void dfs(int x, int y, int cnt) {
        if(x >= 10) {  // 종료 조건 수정
            res = Math.min(cnt, res);
            return;
        }

        if(cnt >= res) return;

        if(y >= 10) {  // 다음 행으로 이동
            dfs(x+1, 0, cnt);
            return;
        }

        if(map[x][y] == 1) {
            for(int i = 5; i >= 1; i--) {  // 반복문 조건 수정
                if(paper[i] > 0 && checkSticky(x, y, i)) {
                    attach(x, y, i, 0);
                    paper[i]--;
                    dfs(x, y+1, cnt+1);
                    attach(x, y, i, 1);
                    paper[i]++;
                }
            }
        } else {
            dfs(x, y+1, cnt);
        }
    }

    public static void attach(int x, int y, int size, int state){
        for(int i =x; i<x+size; i++){
            for(int j =y; j<y +size; j++){
                map[i][j] = state;
            }
        }
    }

    public static boolean checkSticky(int x, int y,int size){
        for(int i =x; i<x+size; i++){
            for(int j =y; j<y +size; j++){
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }

                if(map[i][j] !=1){
                    return false;
                }
            }
        }
        return true;
    }
}
