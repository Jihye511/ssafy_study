package A형기출_0210;

import javax.accessibility.AccessibleKeyBinding;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_17281_야구 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] seq;
    static int maxScore = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map= new int[N][9];
        visited = new boolean[9];
        seq = new int[9];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[3] = true;
        seq[3] =0;
        //순서 부여하고 바로 게임시작
        dfs(1);
        System.out.println(maxScore);

    }
    public static void play(int[] num){
        int idx =0;
        int player;
        int score =0;

        for(int i =0; i<N; i++){
            int out =0;
            int[] check = new int[3]; //루에 사람잇는지 확인
//            System.out.println();
            while(out<3){// seq순서대로 게임진행 3아웃까지

                //현재 사용자 업데이트
                idx = idx%9;
                player = num[idx]; //현재 차례 선수 번호
                int nowPlayer = map[i][player]; // 그 선수의 결과
//                System.out.print(player);
                if(nowPlayer ==0) out++;
                else if(nowPlayer ==4){
                    //홈런
                    score += check[0] + check[1] + check[2]+1;
                    Arrays.fill(check,0);
                }else if(nowPlayer ==3){
                        score += check[0] + check[1]+ check[2];
                        Arrays.fill(check,0);
                        check[2]=1;
                }
                else if(nowPlayer ==2){
                    score += check[1]+ check[2];
                    check[2]=check[0];
                    check[1]=1;
                    check[0]=0;
                }else if(nowPlayer==1){
                    score += check[2];
                    check[2] = check[1];
                    check[1] = check[0];
                    check[0] = 1;
                }
                idx++;
            }
        }
        maxScore = Math.max(score,maxScore);
    }

    public static void dfs(int depth){
        if(depth ==9){
            play(seq);
            return;
        }
            for(int i =0; i<9; i++){
                if(visited[i]) continue;
                visited[i] =true;
                seq[i] = depth;
                dfs(depth+1);
                visited[i]=false;
        }

    }



}
