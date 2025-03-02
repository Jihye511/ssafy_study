import java.util.*;
import java.io.*;
public class BOJ_16943_숫자재배치 {
    static int max = -1;
    static int[] num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split(" ");

        num = new int[split[0].length()];
        for(int i =0; i<split[0].length(); i++){
            num[i] = split[0].charAt(i) - '0';
        }

        int B = Integer.parseInt(split[1]);
        boolean[] v = new boolean[split[0].length()];
        dfs(v, 0,"",B,split[0].length());
        System.out.println(max);

    }
    public static void dfs(boolean[] v,int idx, String s, int B, int size){
        if(idx ==size){
            int C = Integer.parseInt(s);
            if(C < B){
                max = Math.max(max, C);
            }
            return;
        }

        for(int i =0; i<size; i++){
            if(!v[i]){
                if (s.isEmpty() && num[i] == 0) continue;
                v[i] =true;
                dfs(v,idx+1, s +num[i] , B, size);
                v[i] =false;
            }
        }


    }
}
