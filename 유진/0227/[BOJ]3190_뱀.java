import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] map, turnInfo;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = -1;
		}
		
		int L = Integer.parseInt(br.readLine());
		turnInfo = new int[L][2];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = st.nextToken().charAt(0) == 'D' ? 1 : -1;
			turnInfo[i][0] = s;
			turnInfo[i][1] = d;
		}
		
		map[0][0] = 1;
		int[] head = new int[] {0,0};
		int[] tail = new int[] {0,0};
		int d = 1; 
		int turnCounter = 0;
		int time = 0;
		
		while(true) {
			time++;
			
			int ny = head[0] + dy[d];
			int nx = head[1] + dx[d];
			
			if(!inMap(ny, nx) || map[ny][nx] > 0) {
				break;
			} else {
				if(map[ny][nx] != -1) {
					map[ny][nx] = time+1;
					head = new int[] {ny, nx};
					
					for(int i = 0; i < 4; i++) {
						int ay = tail[0] + dy[i];
						int ax = tail[1] + dx[i];
						if(inMap(ay, ax) && map[ay][ax] == map[tail[0]][tail[1]]+1) {
							map[tail[0]][tail[1]] = 0;
							tail = new int[] {ay, ax};
							break;
						}
					}
					
				} else {
					map[ny][nx] = time+1;
					head = new int[] {ny, nx};
				}
			}
			
			if(turnCounter < L && time == turnInfo[turnCounter][0]) {
				d = (d+turnInfo[turnCounter][1]+4)%4;
				turnCounter++;
			}
		}
		
		System.out.println(time);
	}
	static boolean inMap(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
