package 설연휴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n =0;
            String str = br.readLine();
            int[] now = new int [str.length()];
            Arrays.fill(now,0);
            ArrayList<Integer> list = new ArrayList<>();
            int[] num = new int[str.length()];
            for(int i =0; i<str.length(); i++){
                num[i] = str.charAt(i)-'0';
                if(num[i] != now[i]){
                    list.add(i);
                }
            }

            while(true){

                int idx = list.get(0);
                int value = num[idx];
                for(int i=idx; i<str.length(); i++){
                    now[i] = value;
                }
                n++;
                list.clear();
                //비교
                for(int i=0; i<str.length(); i++){
                    if(num[i] != now[i]){
                        list.add(i);
                    }
                }
                if(list.isEmpty()) break;

            }
            StringBuilder sb = new StringBuilder();
            for(int v : now){
                sb.append(v);
            }
            System.out.println("#" +t+" " +n);
        }
    }
}
