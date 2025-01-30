package 설연휴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1244_스위치켜고끄기 {
    static int[] lights;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n= Integer.parseInt(br.readLine());
        lights = new int[n+1];


        st = new StringTokenizer(br.readLine());
        for (int i =1; i<=n; i++){
            lights[i] = Integer.parseInt(st.nextToken());
        }

        //학생수
        int student = Integer.parseInt(br.readLine());

        for (int i =0; i<student; i++){

            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if(sex ==1){
                boy(number);
            }
            else if(sex ==2){
                girl(number);
            }
        }
        //=출력
        for(int i =1; i< lights.length; i ++){
            System.out.print(lights[i] + " ");
            if(i%20 == 0){
                System.out.println();
            }
        }
    }
    public static void boy(int num){
        int index = num;
        while(index <lights.length) {
            if (lights[index] == 0) {
                lights[index] = 1;

            }else if(lights[index]==1) {
                lights[index] = 0;
            }
            index+=num;
        }

    }

    public static void girl(int num){
        if (lights[num] == 0) {
            lights[num] = 1;

        }else if(lights[num]==1) {
            lights[num] = 0;
        }
        //대칭 스위치 반대로 변경
        int count =1;
        while ((num-count)> 0 && (num + count)<lights.length){
            if(lights[num+count] == lights[num -count]){
                if (lights[num+ count] ==0){
                    lights[num +count] =1;
                    lights[num - count] =1;
                }
                else if (lights[num+ count] ==1){
                    lights[num +count] =0;
                    lights[num - count] =0;
                }
                count++;

            }
            else
                break;
        }
    }
}
