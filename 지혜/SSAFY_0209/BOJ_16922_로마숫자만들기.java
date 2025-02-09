package SSAFY_0209;
import java.util.*;
import java.io.*;
public class BOJ_16922_로마숫자만들기 {
    static int n;
    static int[] num = {1,5,10,50};
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[4];
        dfs(0,0,0);
        System.out.println(set.size());
    }
    public static void dfs(int start,int depth,int v){
        if(depth ==n){
            set.add(v);
            return;
        }
        for(int i =start; i<4; i++){

            dfs(i,depth+1, v+num[i]);
        }
    }

}
