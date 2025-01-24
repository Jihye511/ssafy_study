import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n%2 == 0 || n < 1 || n > 100) {
			System.out.println("INPUT ERROR!");
			return;
		}
		int mid = n/2;
		
		for(int i = 0; i < mid; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i <= mid; i++) {
			for(int j = 0; j < mid-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 2*mid-2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
