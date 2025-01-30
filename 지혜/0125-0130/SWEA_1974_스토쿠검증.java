package 설연휴;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class SWEA_1974_스토쿠검증 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans=1;
            int[][] map = new int[9][9];
            for(int i =0; i<9; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j =0; j<9; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로 확인
            for(int i =0; i<9; i++){
                int[] temp = Arrays.copyOf(map[i], 9);
                Arrays.sort(temp);
                for(int j=1;j<=9; j++){
                    if(temp[j-1] != j){
                        ans = 0;
                        break;
                    }
                }
            }

            //세로 확인
            for(int i=0; i<9; i++){
                int[] temp = new int[9];
                for(int j =0; j<9; j++){
                    temp[j] = map[j][i];
                }
                Arrays.sort(temp);
                for(int j=1;j<=9; j++){
                    if(temp[j-1] != j){
                        ans = 0;
                        break;
                    }
                }
            }

            //정사각형 확인

            for(int i =0; i<9; i+=3){
                for(int j =0; j<9; j+=3){
                    if(!isValidSubGrid(map, i, j)){
                        ans =0;
                        break;
                    }
                }
            }
            System.out.println("#" +t +" " + ans);
        }
    }
    public static boolean isValidSubGrid(int[][] temp ,int startR, int startC){
        Set<Integer> seen = new HashSet<>();
        for(int i =startR ; i<startR +3; i++){
            for(int j =startC ; j<startC +3; j++){
                int num = temp[i][j];
                if(seen.contains(num)){
                    return false;
                }
                seen.add(num);

            }
        }
        return true;
    }
}