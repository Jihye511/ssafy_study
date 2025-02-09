import java.util.*;
import java.io.*;
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BOJ_15686_치킨배달 {
    static int n,m;
    static int dist=Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Pair> chicken = new ArrayList<>();
    static ArrayList<Pair> house = new ArrayList<>();
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i =0; i<n; i++){
            st =new StringTokenizer(br.readLine());
            for(int j =0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1) {
                    house.add(new Pair(i,j));
                }
                else if(map[i][j]==2){
                    chicken.add(new Pair(i,j));
                }
            }
        }
        check = new boolean[chicken.size()];
        findChicken(0,0);
        //치킨집 n개 만큼 뽑고
        //그 치킨집 최소 거리 구해서 저장
        System.out.println(dist);

    }
    public static void findChicken(int start,int depth){
        if(depth == m){
            int hap=0;
            //거리 계산
            for(int i =0; i<house.size(); i++){
                Pair cur = house.get(i);
                int curX = cur.x;
                int curY = cur.y;
                int sum = Integer.MAX_VALUE; // 현재 집에서 치킨집까지 거리
                for(int j =0; j<chicken.size(); j++){
                    if(check[j]){
                        Pair chick = chicken.get(j);
                        int temp = Math.abs(curX-chick.x) + Math.abs(curY-chick.y);
                        sum = Math.min(sum,temp);
                    }
                }
                hap += sum;
            }
            dist = Math.min(dist,hap);
            return;
        }

        for(int i =start; i<chicken.size(); i++){
            if(!check[i]){
                check[i] = true;
                findChicken(i+1,depth+1);
                check[i] =false;
            }
        }
    }

}
