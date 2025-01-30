package 설연휴;

import java.io.*;
import java.util.*;

public class 백준_2999_비밀이메일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        int len = input.length();
        int r =0 , c=0;
        for(int i =1; i<=Math.sqrt(len); i++){
            if(len % i ==0){

                r =i;
                c = len/i;
            }
        }
        char[][] arr = new char[r][c];
        int cnt =0;
        for(int i =0; i<c; i++){
            for(int j =0; j<r; j++){
                arr[j][i] = input.charAt(cnt++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
    }

}