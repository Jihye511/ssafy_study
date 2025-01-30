package 설연휴;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class SWEA_1208_Flatten {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t =1; t<=10; t++){

            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] box = new int[100];

            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(box);
            while (dump-- > 0) {
                if(box[99] - box[0] <=1) break;
                //젤높은거에서 낮은거로 옮기기

                box[99]--;
                box[0] ++;
                Arrays.sort(box);
            }
            System.out.println("#"+t +" " + (box[99]-box[0]));
        }
    }

}