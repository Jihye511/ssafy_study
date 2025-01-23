import java.io.BufferedReader;
import java.io.*;
import java.util.*;


public class 정올_1523 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if(n>100 ||m<1 ||m>3  ){
            System.out.println("INPUT ERROR!");
        }
        else if(m ==1){
            for(int i=1; i<=n; i++){
                for(int j =1; j<=i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }else if(m ==2){
            for(int i=1; i<=n; i++){
                for(int j =n; j>=i; j--){
                    System.out.print("*");
                }
                System.out.println();
            }
        }else if(m ==3){
            for(int i =1; i<=n; i++){
                for(int j =n-i; j>0; j--){
                    System.out.print(" ");
                }
                for(int j =1; j<=i*2-1; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
