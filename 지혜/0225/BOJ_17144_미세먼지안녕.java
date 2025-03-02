package study;
import java.io.*;
import java.util.*;

public class BOJ_17144_미세먼지안녕 {
	static int R,C,T;
	static int [][] map;
	static int[] dx = {0,-1,0,1,0,1,0,-1};
	static int[] dy = {1,0,-1,0,1,0,-1,0};
	static int[] air = new int[2];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i =0; i<R; i++) {
			Arrays.fill(map[i], 0);
		}
		int idx=0;
		for(int i =0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<C; j++) {
				map [i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==-1) {
					air[idx] = i;
					
					idx++;
				}
			}
		}
		while(T-->0) {
			
			//1초 미세먼지 확산
			extensionArea();
			//1초 공기청정기 가동
			playAir();	
		}
		
		int sum=0;
		for(int[] r : map) {
			for(int v : r) {
				sum += v;
			}
		}
		System.out.println(sum +2);
	}
	public static void playAir() {
		//윗판
		int x = air[0];

		int nx = air[0];
		int ny = 1;
		int i=0;
		int next =0;
		
		int before = map[x][1];
		map[x][1] = 0;
		while(true) {
			nx += dx[i];
			ny += dy[i];
			if(nx ==x && ny ==0) break;
			if(nx < 0 || nx>=R || ny< 0 || ny>=C) {
				nx -=dx[i];
				ny -=dy[i];
				i++;
				continue;
			}
			next = map[nx][ny];
			map[nx][ny] = before;
			before = next;
		}
		
		//아래판
		x = air[1];
		nx = air[1];
		ny =1;
		i = 4;
		next = 0;
		before = map[x][1];
		map[x][1] = 0;
		while(true) {
			nx += dx[i];
			ny += dy[i];
			if(nx ==x && ny ==0) break;
			if(nx < 0 || nx>=R || ny< 0 || ny>=C) {
				nx -=dx[i];
				ny -=dy[i];
				i++;
				continue;
			}
			next = map[nx][ny];
			map[nx][ny] = before;
			before = next;
		}
	}
	public static void extensionArea() {
		Queue<int[]> q = new LinkedList<>();
		for(int i =0; i<R; i++) {
			for(int j =0; j<C; j++) {
				if(map[i][j]>0) q.offer(new int[] {i,j,map[i][j]});
			}
		}
		int size = q.size();
		int cnt=0;
		for(int i =0; i<size; i++) {
			int[] cur = q.poll();
			 cnt=0;
			int a =cur[2] / 5; //퍼지는 양
		
			for(int d =0; d<4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
				if( map[nx][ny] ==-1) continue;
				
				map[nx][ny] += a;
				cnt++;
			}
			map[cur[0]][cur[1]] -=  a *cnt;
		}	
	}
}
