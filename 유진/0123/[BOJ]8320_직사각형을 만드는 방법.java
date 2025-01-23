import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for(int a = 1; a <= Math.sqrt(n); a++) {
			for(int b = 1; b <= n; b++) {
				if(a <= b && a * b <= n) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
}
