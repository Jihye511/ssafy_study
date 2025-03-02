import java.io.*;
import java.util.*;
class Point{
    int x,y;
    int m;
    int s;
    int d;
    public Point(int x,int y, int m, int s, int d){
        this.x = x;
        this.y = y;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
public class BOJ_20056_마법사상어와파이어볼 {
    static int N,M,K;
//    static int[][] map;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static ArrayList<Point>[][] map;
    static ArrayList<Point> points = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            points.add(new Point(x,y,m,s,d));
        }

        while(K-->0){
            movePoint();
            fire();
        }
        int result =0;
        for(Point cur :points){
            result += cur.m;
        }
        System.out.println(result);
    }
    public static void movePoint(){
        //초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j].clear();
            }
        }
        for(Point cur : points){
            int nx = (cur.x + N + dx[cur.d] * (cur.s %N)) %N; //음수처리까쥐
            int ny = (cur.y + N + dy[cur.d] * (cur.s %N)) %N;
            cur.x = nx;
            cur.y = ny;

            map[cur.x][cur.y].add(cur);
        }
    }
    public static void fire(){
        ArrayList<Point> newPoints = new ArrayList<>();

        for(int x =0; x<N; x++){
            for(int y =0; y<N; y++){
                if (map[x][y].size() < 2) {
                    if (!map[x][y].isEmpty()) {
                        newPoints.addAll(map[x][y]);
                    }
                    continue;
                }

                //블 두개 이상
                int ms  =0;
                int ss =0;
                int odd =0, even =0;
                int size = map[x][y].size();

                for(Point cur : map[x][y]){
                    ms +=cur.m;
                    ss +=cur.s;
                    if(cur.d % 2 ==1) odd++; //홀수면
                    else even++;

                    points.remove(cur);
                }
                map[x][y].clear();
                int newms = ms / 5;
                if(newms ==0) continue;
                int newss = ss/size;
                //방향 짝홀 확인
                if(odd == size || even ==size){
                    for(int i =0; i<8; i+=2){
                        newPoints.add(new Point(x,y,newms,newss,i));
                    }
                }else{
                    for(int i =1; i<8; i+=2){
                        newPoints.add(new Point(x,y,newms,newss,i));
                    }
                }
            }
            points = newPoints;
        }
    }

}
