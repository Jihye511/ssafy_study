import java.util.*;
import java.io.*;
import java.awt.*;
class Home {
	int a,b;
	Home(int a, int b) {
		this.a = a;
		this.b = b;
	}
} 

public class Boj_15686_치킨배달 {
	static ArrayList<Point> ch;
	static ArrayList<Point[]> selected;
	static int result;
	
	public static void main(String[] args) throws IOException{
		//1은 집 2는 치킨
		//치킨 거리 가장 작게 
		//집 근처에 치킨
		//완탐? + 프루닝?
		//우선순위큐
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		ArrayList<Integer[]> homes = new ArrayList<Integer[]>();
		ch = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int p = Integer.parseInt(st.nextToken());
				if (p == 1) {
					homes.add(new Integer[]{i,j});
				}
				if (p == 2) {
					ch.add(new Point(i,j));
				}
			}
		}
		selected = new ArrayList<Point[]>();
		
		//치킨집 고르기
		comb(M,new Point[M],0,0);
		Home home = new Home(0,0);
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < selected.size(); i++) {
			int temp = 0;  //각 배치에 대한 치킨 거리 합
			//각 집에 대한 치킨 거리 계산
			for (int j = 0; j < homes.size(); j++) {
				if (temp > result) {
					break;
				}
				home = new Home(homes.get(j)[0],homes.get(j)[1]);
				PriorityQueue<Point> pq = create(selected.get(i), home);
				Point p = pq.peek();
				temp += Math.abs(p.x - home.a) + Math.abs(p.y - home.b);
			}
			result = Math.min(result, temp);
		}
		System.out.println(result);
 	}
	
	static void comb(int M,Point[] sel, int k,int idx) {
		//끝
		if (k == M) {
			selected.add(Arrays.copyOf(sel, M));
			return;
		}
		if (idx == ch.size()) {
			return;
		}
		
		//반복
		//뽑거나
		sel[k] = ch.get(idx);
		comb(M,sel, k+1,idx+1);
		
		//안뽑거나
		comb(M,sel,k,idx+1);
	}
	
	private static PriorityQueue<Point> create(Point[] points, Home home) {
		PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p-> 
			Math.abs(p.x - home.a) + Math.abs(p.y - home.b)
				));
		pq.addAll(Arrays.asList(points));
		return pq;
	}
}
