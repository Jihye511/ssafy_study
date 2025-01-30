package 설연휴;

import java.io.*;

public class SWEA_5432_쇠막대기자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t =1; t<=T ; t++){
            int cnt=0; //잘린 조각 개수
            int n = 0; //현재 막대 개수
            String str = br.readLine();

            for(int i =0; i<str.length(); i++){
                char c = str.charAt(i);

                if(c =='('){
                    n++;
                }else{
                    n--;
                    if(str.charAt(i-1)=='('){
                        cnt +=n;
                    }else{
                        cnt+=1;
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}