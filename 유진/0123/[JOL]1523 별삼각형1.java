import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n < 1 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
		case 1:
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for(int i = 0; i < n; i++) {
				for(int j = 1; j < n-i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				for(int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}	
	}
}
