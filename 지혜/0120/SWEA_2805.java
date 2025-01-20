package algorithm_study;
import java.io.*;
import java.util.*;

public class SWEA_2805 {
	static int T,n;
	static int[][] map;
	static int sum;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T =Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
			sum=0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for(int i =0; i<n; i++) {
				String input = br.readLine();
				for(int j =0; j<n; j++) {
					int  num = input.charAt(j)-'0';
					map[i][j] = num;
				}
			}
			//0~ 중간까지
			for(int i =0; i<=n/2; i++) {
				for(int j =n/2-i; j<=n/2+i; j++) {
					sum += map[i][j];
				}
			}
			int temp=0;
			//중간+1 ~ 끝까지
			for(int i =n-1; i>n/2; i--) {
				for(int j =n/2 -temp; j<=n/2 + temp; j++) {
					sum += map[i][j];
					
				}
				temp++;
			}
			
			System.out.println("#"+t +" "+ sum);
		}
	}
}
