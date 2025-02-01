import java.util.*;
import java.io.*;

public class Boj_2564_경비원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int total = 2 * w + 2 * h;
        int n = Integer.parseInt(br.readLine());
        int[] pos = new int[n+1];  //위치를 저장할 배열
        for (int i =0; i < n+1; i++) {
            input = br.readLine().split(" ");
            int dir = Integer.parseInt(input[0]);
            int distance = Integer.parseInt(input[1]);
            switch(dir) {
                //북
                case 1: pos[i] = distance;
                        break;
                case 2: pos[i] = w + h + (w-distance); break;
                case 3: pos[i] = w * 2 + h + (h-distance); break;
                case 4: pos[i] = w + distance; break;
            }
        }

        //북 -> 동 -> 남 -> 서

        int dong = pos[n]; //위치는 가장 마지막에 입력

        //1. 시계방향 -> 배열 순서대로 pos - dong
        //2. 반시계방향 -> total - dong + pos
        int result = 0;
        //가까운 경로 선택
        for (int i = 0; i < n; i++) {
            int temp = Math.min(total - pos[i] + dong, total - dong + pos[i]);
            result += Math.min(Math.abs(pos[i] - dong), temp);
        }
        System.out.println(result);
    }
}
