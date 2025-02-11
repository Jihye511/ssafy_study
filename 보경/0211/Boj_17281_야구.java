import java.util.*;
import java.io.*;

public class Boj_17281_야구 {
    static int N;
    static int result;
    static ArrayList<int[]> turns;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //4번타자는 첫번째 선수로 고정
        //입력값 : 각 이닝에서 각 선수가 얻는 득점
        N = Integer.parseInt(br.readLine());

        int[][] scores = new int[N][10];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플레이어 순서 담는 배열(1번제외)
        int[] arr = new int[8];
        for (int i = 2; i <= 9; i++) {
            arr[i-2] = i;
        }
        turns = new ArrayList<>();
        getTurns(arr,new int[8],0,new boolean[9]);
        result = 0;

        for (int i = 0; i < turns.size(); i++) {
            int game = 0; //이닝
            int temp = 0; //각 경우의 수에 대한 획득 점수
            int p = 0;  //타순
            while (game < N) {  //각 이닝
                int first = 0;
                int second = 0;
                int third = 0;  //각 베이스 비어있는 상태
                int out = 0;
                //게임 진행
                int player = -1; //현재 타석에 있는 플레이어 번호
                while (out < 3) {
                    if (p%9 == 3) {
                        //1번타자 고정
                        player = 1;
                    }
                    else {
                        if (p%9 > 3) {  //한칸씩 땡겼기때문에 보정해야함...
                            player = turns.get(i)[p%9-1];
                        }
                        else {
                            player = turns.get(i)[p%9];

                        }
                    }
                    p++;

                    int hit = scores[game][player];

                    if (hit == 0) {
                        out++;
                    }
                    else if (hit == 1) {
                        //안타
                        temp += third;
                        third = second;
                        second = first;
                        first = 1;
                    }
                    else if (hit == 2) {
                        //2루타
                        temp += (third + second);
                        third = first;
                        second = 1;
                        first = 0;
                    }

                    else if (hit == 3) {
                        //3루타
                        temp += (third + second + first);
                        third = 1;
                        second = 0;
                        first = 0;
                    }

                    else if (hit == 4) {
                        //홈런
                        temp += (first + second + third + 1);
                        third = 0;
                        second = 0;
                        first = 0;
                    }
                }
                game += 1;  //다음 이닝
            }
            result = Math.max(result,temp);
        }
        System.out.println(result);
    }

    //순열
    static void getTurns(int arr[],int[] sel, int depth,boolean[] visited) {
        if (depth == 8) {
            turns.add(sel.clone());
//            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                sel[depth] = arr[i-1];
                visited[i] = true;
                getTurns(arr,sel,depth + 1, visited);
                visited[i] = false;
            }
        }
    }
}
