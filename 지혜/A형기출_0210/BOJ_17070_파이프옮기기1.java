package A형기출_0210;
import java.io.*;
import java.util.*;
class Node{
    int startX;
    int startY;
    int endX;
    int endY;
    public Node(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
public class BOJ_17070_파이프옮기기1 {
    static int N;
    static int[][] map;
    static int cnt =0;
    static int[] dx ={0,1,1};
    static int[] dy = {1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(1,1,1,2);
        System.out.println(cnt);


    }
    public static void bfs(int sx, int sy, int ex, int ey){

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx,sy,ex,ey));
        while(!q.isEmpty()){
            Node cur = q.poll();

            int nx;
            int ny;
            //현재 상태 가로,세로,대각선인지 확인
            if(cur.startX == cur.endX){
                //가로 - 2가지
                for(int i=0; i<2; i++){ // 뒷부분 좌표만 범위밖인지 벽이랑 만나는지 검사하면 될듯
                    nx = cur.endX + dx[i];
                    ny = cur.endY + dy[i];
                    if(nx<1 ||nx>N || ny< 1 || ny>N) continue;
                    if(map[nx][ny] ==1) continue;

                    if(i ==1 && (map[nx-1][ny] ==1 || map[nx][ny-1] ==1)) continue;
                    q.offer(new Node(cur.endX,cur.endY, nx,ny));
                    if(nx == N && ny ==N)cnt+=1;
                }

            }else if(cur.startY == cur.endY){
                //세로 - 2가지
                for(int i=1; i<3; i++){ // 뒷부분 좌표만 범위밖인지 벽이랑 만나는지 검사하면 될듯
                    nx = cur.endX + dx[i];
                    ny = cur.endY + dy[i];
                    if(nx<1 ||nx>N || ny< 1 || ny>N) continue;
                    if(map[nx][ny] ==1) continue;
                    if(i ==1 && (map[nx-1][ny] ==1 || map[nx][ny-1] ==1)) continue;
                    q.offer(new Node(cur.endX,cur.endY, nx,ny));
                    if(nx == N && ny ==N)cnt+=1;
                }
            }else{  //대각선 - 3가지
                for(int i=0; i<3; i++){ // 뒷부분 좌표만 범위밖인지 벽이랑 만나는지 검사하면 될듯
                    nx = cur.endX + dx[i];
                    ny = cur.endY + dy[i];
                    if(nx<1 ||nx>N || ny< 1 || ny>N) continue;
                    if(map[nx][ny] ==1) continue;
                    if(i ==1 && (map[nx-1][ny] ==1 || map[nx][ny-1] ==1)) continue;
                    q.offer(new Node(cur.endX,cur.endY, nx,ny));
                    if(nx == N && ny ==N)cnt+=1;
                }

            }

        }

    }

}