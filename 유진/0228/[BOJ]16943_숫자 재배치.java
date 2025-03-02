import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] aArr, sel;
	static int ans, b, N;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		N = a.length();
		aArr = new int[N];
	
		for(int i = 0; i < N; i++) {
			aArr[i] = a.charAt(i)-'0';
		}
		
		ans = -1;
		sel = new int[N];
		v = new boolean[N];
		
		permutation(0);
		
		System.out.println(ans);
	}
	static void permutation(int k) {
		if(k == N) {
			int temp = 0;
			for(int i = 0; i < N; i++) {
				temp += sel[N-1-i] * Math.pow(10, i);
			}
			if(temp < b) {
				ans = Math.max(ans, temp);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(k == 0 && aArr[i] == 0) {
				continue;
			}
			if(!v[i]) {
				sel[k] = aArr[i];
				v[i] = true;
				permutation(k+1);
				v[i] = false;
			}
		}
	}
}
