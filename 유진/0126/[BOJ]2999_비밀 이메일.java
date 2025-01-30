import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int h = 0, w = 0;
		for(int i = (int)Math.sqrt(len); i >= 1; i--) {
			if(len % i == 0) {
				h = i;
				w = len/i;
				break;
			}
		}
		
		char[][] matrix = new char[h][w];
		int idx = 0;
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				matrix[j][i] = str.charAt(idx);
				idx++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				sb.append(matrix[i][j]);
			}
		}

		System.out.println(sb);
	}
}
