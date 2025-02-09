import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ans, m;
	static boolean[] v;
	static ArrayList<Point> chickenLst, homeLst;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		chickenLst = new ArrayList<>();
		homeLst = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					homeLst.add(new Point(j, i));
				} else if(num == 2) {
					chickenLst.add(new Point(j, i));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		v = new boolean[chickenLst.size()];
		
		combination(new int[m], 0, 0);
		
		System.out.println(ans);
	}
	
	public static void combination(int[] res, int start, int idx) {
		if(idx == m) {
			ans = Math.min(ans, calcDist(res));
			return;
		}
		
		for(int i = start; i < chickenLst.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				res[idx] = i;
				combination(res, i+1, idx+1);
				v[i] = false;
			}
		}
	}
	
	static int calcDist(int[] chickenIdxArr) {
		int sum = 0;
		for(Point home: homeLst) {
			int dist = Integer.MAX_VALUE;
			for(int idx: chickenIdxArr) {
				Point chicken = chickenLst.get(idx);
				dist = Math.min(dist, Math.abs(home.x-chicken.x)+Math.abs(home.y - chicken.y));
			}
			sum += dist;
		}
		return sum;
	}
}
