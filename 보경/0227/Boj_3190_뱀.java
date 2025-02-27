import java.util.*;
import java.io.*;

public class Boj_3190_뱀 {
    static int[][] map;
    static int N,K;
    static HashMap<Character, Character[]> directions;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine()); //사과개수

        //사과 -> 길이++
        //벽, 몸 -> 종료
        //처음 위치 : 맨 위 맨 좌측 몸 길이 : 1 방향 : 오른쪽

        //초마다 이동
        //1. 몸길이 ++ 머리 이동
        //2. 사과 -> 그대로
        //3. 사과 X -> 꼬리 비움
        //최대 초 계산

        //1 : 뱀 몸
        //2 : 사과
        //0 : 빈 칸
        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 2;
        }

        //현재 바라보는 방향에 대한 왼쪽 오른쪽
        directions = new HashMap<>();
        directions.put('N',new Character[]{'W','E'});  //서, 동
        directions.put('S', new Character[]{'E','W'});  //동, 서
        directions.put('E', new Character[]{'N','S'});  //북, 남
        directions.put('W', new Character[]{'S','N'});  //남, 북

        //초, 방향 저장
        Deque<int[]> turn = new ArrayDeque<>();
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0) == 'L' ? 0 : 1;   //0은 왼, 1은 오른쪽
            turn.add(new int[] {time,d});
        }

        //동서남북 좌표 저장
        HashMap<Character, int[]> dir = new HashMap<>();
        dir.put('N', new int[] {-1,0});
        dir.put('S', new int[] {1,0});
        dir.put('E', new int[] {0,1});
        dir.put('W', new int[] {0,-1});


        int nr = 0;
        int nc = 0;
        Deque<int[]> snake = new ArrayDeque<>(); //뱀 좌표 저장
        snake.add(new int[] {0,0});
        map[0][0] = 1;
        char currD = 'E';

        int time = 1;
        while (true) {

            int[] move = dir.get(currD);
            nr = nr + move[0];
            nc = nc + move[1];
            if (!inRange(nr,nc) || map[nr][nc] == 1) {
                break;
            }

            if (map[nr][nc] == 2) {
                //사과
                map[nr][nc] = 1;
                snake.add(new int[] {nr,nc});
            }

            else {
                map[nr][nc] = 1;
                snake.add(new int[] {nr,nc});
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }
            //방향 변환 시각인지 확인
            if (!turn.isEmpty() && turn.peek()[0] == time) {
                int changed = turn.pollFirst()[1];
                currD = directions.get(currD)[changed];
            }

            time++;

        }

        System.out.println(time);

    }

    static boolean inRange(int r, int c) {
        return 0<= r && r < N && 0<=c && c < N;
    }
}
