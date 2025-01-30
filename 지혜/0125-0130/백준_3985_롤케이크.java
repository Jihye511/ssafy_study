package 설연휴;
import java.io.*;
import java.util.*;
public class 백준_3985_롤케이크 {
    static int L,N;
    static int[] cake;
    static int[] num;
    static int max = 0;
    static int max_num =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
        L = Integer.parseInt(br.readLine());
        N =Integer.parseInt(br.readLine());
        cake = new int[L+1];
        Arrays.fill(cake,0);
        num = new int[N+1];

        for(int i =1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(max<end-start){
                max = end-start;
                max_num =i;
            }
            shareCake(start,end, i);
        }
        //최대로 가져간 사람 찾기
        int m =0;
        int mNum=0;
        for(int i =1 ; i<num.length; i++){
            if(m< num[i]){
                m = num[i];
                mNum = i;
            }
        }
        System.out.println(max_num);
        System.out.println(mNum);
    }
    public static void shareCake(int start, int end, int n){
        for(int i= start; i<=end; i++){
            if(cake[i] == 0){
                cake[i] = n;
                num[n] +=1;

            }
        }

    }
}
