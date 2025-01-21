package algorithm_study;
import java.io.*;
import java.util.*;
public class BOJ_1592 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];
		
		int idx =0;
		int cnt=0; // 결과값
		while(true) {
			temp[idx]++;
			if(temp[idx]==M) {
				break;
				
			}
			if(temp[idx]%2==1) {
				//받은 횟수 홀수번
				idx = (idx+L)%N;
				
			}else {
				//짝수번
				idx = (idx - L + N) % N;
			}
			cnt++;
			
		}
		System.out.println(cnt);
	}

}
