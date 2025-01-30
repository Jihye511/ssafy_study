package 설연휴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정올_1707_달팽이사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int num =1;
        int top=0, bottom =n-1, left =0, right =n-1;
        while(num<=n*n){
            //위쪽
            for(int i =left; i<=right; i++){
                map[top][i] = num++;
            }
            top++;

            //오른쪽 열
            for(int i =top; i<=bottom; i++){
                map[i][right] = num++;
            }
            right--;

            //아래쪽 행 채우기
            for(int i =right; i>=left; i--){
                map[bottom][i] = num++;
            }
            bottom--;

            //왼쪽 열
            for(int i =bottom; i>=top; i--){
                map[i][left]= num++;
            }
            left++;
        }

        for(int [] temp :map){
            for(int v : temp){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}