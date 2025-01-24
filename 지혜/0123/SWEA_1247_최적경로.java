package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class SWEA_1247_최적경로 {
	static int T;
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int minValue;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][2];
			visited = new boolean[N+2];
			minValue = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0; i<N+2; i++ ) {
				//회사, 집, 고객순 
				//i =0 : 회사
				//i =1 : 집
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			recursive(0,0,0);
			
			sb.append("#"+t + " " + minValue).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	//조합을 다 구하고 한번에 계산
	public static void recursive(int pre,int sum, int k) {
		//모두 방문 했을 때 return (집까지 돌아가는 거 거리 추가)
		if(sum > minValue) return;
	
			if(k==N) {
				//이동 거리 계산
//				int sum = calculate(temp)x;
//				 sum += Math.abs(map[idx-1][0] - map[1][0]) + Math.abs(map[idx-1][1]-map[1][0]);
				
				//집까지
				 sum += ( Math.abs(map[pre][0] - map[1][0]) + Math.abs(map[pre][1]-map[1][1]));
				 minValue = Math.min(minValue, sum);
				 return;
			}
			
			
			for(int i =2; i<N+2; i++) {
				if(!visited[i]) {
					visited[i] =true;
//					temp[idx] = i;
//					sum += (Math.abs(map[i][0] - map[pre][0]) +Math.abs(map[i][1] - map[pre][1]));
					recursive(i,sum + (Math.abs(map[i][0] - map[pre][0]) +Math.abs(map[i][1] - map[pre][1])), k+1);
					visited[i] =false;
		
				}
							
			}
		}
		

		
	}
//	public static int calculate(int[] temp) {
//		int sum =0;
//		for(int i =0; i<temp.length-1; i++) {
//			int num = temp[i];
//			int next = temp[i+1];
//			
//		
//			if(i ==0) {
//				//회사거리 계산
//				sum += Math.abs(map[0][0] - map[num][0]) + Math.abs(map[0][1]-map[num][0]);
//			}
//		
//			sum += (Math.abs(map[num][0] - map[next][0]) +Math.abs(map[num][1] - map[next][1]));
//
//			//마지막 값에서 집가는 거리까지 더하기
//		}
//		int last = temp[temp.length-1];
//		sum  +=(Math.abs(map[last][0] - map[1][0])+Math.abs(map[last][1] - map[1][1]));
//		
//		return sum;
//	}
