import java.io.*;
import java.util.*;

public class BOJ_16935_배열돌리기3 {
    static int N,M,R;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<R; i++){
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    upDown();
                    break;
                case 2:
                    leftRight();
                    break;
                case 3:
                    rightTurn();
                    break;
                case 4:
                    leftTurn();
                    break;
                case 5:
                    oneToTwo();
                    break;
                case 6:
                    oneToFour();
                    break;
            }
        }



        for(int[] r : map){
            for(int v: r){
                System.out.print(v +" ");
            }
            System.out.println();
        }
    }
    public static void oneToTwo(){
        // Operation 5: Move parts in clockwise direction
        int halfN = N / 2;
        int halfM = M / 2;
        int[][] nMap = new int[N][M];

        // Top-left (new) gets Bottom-left (old)
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                nMap[i][j] = map[i + halfN][j];
            }
        }

        // Top-right (new) gets Top-left (old)
        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < M; j++) {
                nMap[i][j] = map[i][j - halfM];
            }
        }

        // Bottom-right (new) gets Top-right (old)
        for (int i = halfN; i < N; i++) {
            for (int j = halfM; j < M; j++) {
                nMap[i][j] = map[i - halfN][j];
            }
        }

        // Bottom-left (new) gets Bottom-right (old)
        for (int i = halfN; i < N; i++) {
            for (int j = 0; j < halfM; j++) {
                nMap[i][j] = map[i][j + halfM];
            }
        }

        map = nMap;
    }

    public static void oneToFour(){
        // Operation 6: Move parts in counterclockwise direction
        int halfN = N / 2;
        int halfM = M / 2;
        int[][] nMap = new int[N][M];

        // Top-left (new) gets Top-right (old)
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                nMap[i][j] = map[i][j + halfM];
            }
        }

        // Top-right (new) gets Bottom-right (old)
        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < M; j++) {
                nMap[i][j] = map[i + halfN][j];
            }
        }

        // Bottom-right (new) gets Bottom-left (old)
        for (int i = halfN; i < N; i++) {
            for (int j = halfM; j < M; j++) {
                nMap[i][j] = map[i][j - halfM];
            }
        }

        // Bottom-left (new) gets Top-left (old)
        for (int i = halfN; i < N; i++) {
            for (int j = 0; j < halfM; j++) {
                nMap[i][j] = map[i - halfN][j];
            }
        }

        map = nMap;
    }

    public static void leftTurn(){
        int[][] nMap = new int[M][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                nMap[M-1-j][i] = map[i][j];
            }
        }
        int temp = N;
        N = M;
        M = temp;
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = nMap[i][j];
            }
        }
    }
    public static void rightTurn(){
        int[][] nMap = new int[M][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                nMap[j][N - 1 - i] = map[i][j];
            }
        }
        int temp = N;
        N = M;
        M = temp;
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = nMap[i][j];
            }
        }
    }
    public static void upDown(){

        for(int i =0; i<N/2; i++){
            int[] temp = map[i];
            map[i] = map[N-1-i];
            map[N-1-i] = temp;

        }
    }
    public static void leftRight(){
        for(int i =0; i<N; i++){
            for(int j =0; j<M/2; j++){
                int temp = map[i][j];
                map[i][j] = map[i][M-1-j];
                map[i][M-1-j] =temp;
            }
        }

    }
}
