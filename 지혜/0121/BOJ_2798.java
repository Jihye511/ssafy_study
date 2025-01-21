package algorithm_study;
import java.io.*;
import java.util.*;
public class BOJ_2798 {
	static int N,M;
	static int[]num;
	static int maxValue=0;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		sumNum(0,0,0);
		System.out.println(maxValue);
		
	}
	public static void sumNum(int idx,int hap, int depth) {
		if(depth ==3 || idx==N) {
			//M이랑비교 & 젤 큰 값
			if(hap<=M && depth==3) {
				maxValue =Math.max(hap, maxValue);
			}
			return;
		}
		sumNum(idx+1, hap+num[idx],depth+1); //현재값 더하기
		sumNum(idx+1, hap,depth); //현재값 지나침
	}
}
