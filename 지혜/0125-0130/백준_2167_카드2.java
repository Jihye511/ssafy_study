package 설연휴;

import java.io.*;
import java.util.*;
public class 백준_2167_카드2{
    static int N;
    static int result;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            q.offer(i+1);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(q.isEmpty()){
                result = cur;
                break;
            }
            int next = q.poll();
            q.offer(next);
            result = next;
        }
        System.out.println(result);
    }

}