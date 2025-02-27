import java.io.*;
import java.util.*;
class Snake{
    int headX;
    int headY;
    Deque<int[]> body;
    int direction;
    Snake(int headX, int headY,int direction) {
        this.headX = headX;
        this.headY = headY;
        this.body = new LinkedList<>();
        this.body.add(new int[]{headX, headY});
        this.direction =direction;
    }
}
public class  BOJ_3190_뱀 {
    static int N,K,L;
    static int[][] map;
    static int[] sec;
    static char[] dir;
    static Snake snake;
    static int[] dx= {0,1,0,-1};//오 하 왼 상
    static int[] dy= {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i =0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = 1;

        }
        L = Integer.parseInt(br.readLine());
        sec = new int[L];
        dir= new char[L];
        for(int i =0; i<L ; i++) {
            String str = br.readLine();
            String[] s= str.split(" ");

            int n = Integer.parseInt(s[0]);
            char d = s[1].charAt(0);

            sec[i] = n;
            dir[i] = d;
        }

        map[0][0] = -1; //처음뱀 위치
        snake = new Snake(0,0,0);
        int time = 0;
        int dirIndex =0;
        while(true) {
            time++;
            //벽이나 자기 자신의 몸과 부딪히면 게임 끝
            //머리 방향 direction으로 한 칸
            int nx = snake.headX +dx[snake.direction];
            int ny = snake.headY +dy[snake.direction];
            //벽 충돌 or 몸 충돌하면 리턴
            if(nx <0 || nx>=N || ny<0 || ny>=N || map[nx][ny] ==-1) break;

            snake.headX= nx;
            snake.headY= ny;
            snake.body.addFirst(new int[]{nx,ny});

            if(map[nx][ny] !=1) {
                int[] tail = snake.body.removeLast();
                map[tail[0]][tail[1]] =0;
            }
            map[nx][ny]=-1;
            // 방향 전환 (현재 시간이 방향 전환 시간과 일치하면)
            if (dirIndex < L && time == sec[dirIndex]) {
                char d = dir[dirIndex];
                if (d == 'L') {
                    snake.direction = (snake.direction - 1 + 4) % 4;
                } else if (d == 'D') {
                    snake.direction = (snake.direction + 1) % 4;
                }
                dirIndex++;
            }
        }
        System.out.println(time);
    }
}
