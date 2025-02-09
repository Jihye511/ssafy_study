import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc {
	int x, y, h;
	
	Loc(int x, int y, int h){
		this.x = x;
		this.y = y;
		this.h = h;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Loc) {
			Loc l = (Loc)obj;
			return this.x == l.x && this.y == l.y && this.h == l.h;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y, h);
	}
}
public class Main {
	static int N, M, H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		Queue<Loc> q = new LinkedList<>();
		int[][][] t = new int[H][N][M];
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					t[k][i][j] = Integer.parseInt(st.nextToken());
					if(t[k][i][j] == 1) {
						q.offer(new Loc(j, i, k));
					}
				}
			}
		}

		int[] dy = {-1, 0, 1, 0, 0, 0};
		int[] dx = {0, 1, 0, -1, 0, 0};
		int[] dh = {0, 0, 0, 0, 1, -1};
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i = 0; i < 6; i++) {
				int ny = l.y + dy[i];
				int nx = l.x + dx[i];
				int nh = l.h + dh[i];
				
				Loc curr = new Loc(nx, ny, nh);
				if(inMap(ny, nx, nh) && t[nh][ny][nx] != -1) {
					if(t[nh][ny][nx] == 0 || t[l.h][l.y][l.x]+1 < t[nh][ny][nx]) {
						q.offer(curr);
						t[nh][ny][nx] = t[l.h][l.y][l.x]+1;
					}
				}
			}
		}
		
		int ans = 0;
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(t[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
					ans = Math.max(ans, t[k][i][j]);
				}
			}
		}
		System.out.println(ans-1);
		
	}
	static boolean inMap(int y, int x, int h) {
		return 0 <= y && y < N && 0 <= x && x < M && 0 <= h && h < H;
	}
}
