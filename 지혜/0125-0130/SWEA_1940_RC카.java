package 설연휴;

import java.io.*;
import java.util.StringTokenizer;


public class SWEA_1940_RC카 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int distance =0; //이동거리
            int speed = 0; //속도

            int N = Integer.parseInt(br.readLine());
            for(int i =0; i<N; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if(num ==0){
                    //그대로
                    distance += speed;
                }else if( num ==1){
                    //가속
                    int plus = Integer.parseInt(st.nextToken());
                    speed += plus;
                    distance += speed;
                }else if(num ==2){
                    //감속
                    int minus = Integer.parseInt(st.nextToken());
                    speed -= minus;
                    if(speed<0 ){
                        speed =0;
                    }
                    distance +=speed;
                }
            }
            System.out.println("#" + t + " " + distance);
        }
    }
}
