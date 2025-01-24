import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n%2 == 0 || n < 1 || n > 100 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		int mid = n/2+1;
		switch(m) {
		case 1:
			for(int i = 1; i <= mid; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i = 1; i < mid; i++) {
				for(int j = 0; j < mid-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i = 1; i <= mid; i++) {
				for(int j = 0; j < mid-i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i = 1; i < mid; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < mid-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for(int i = 0; i < mid-1; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < n-2*i; j++) {
					System.out.print("*");
				}
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
			for(int i = 0; i < mid; i++) {
				for(int j = 0; j < (n-2*i-1)/2; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i*2+1; j++) {
					System.out.print("*");
				}
				for(int j = 0; j < (n-2*i-1)/2; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
			break;
		case 4:
			for(int i = 0; i < mid-1; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < n/2+1-i; j++) {
					System.out.print("*");
				}
				for(int j = 0; j < n/2; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
			for(int i = 0; i < mid; i++) {
				for(int j = 0; j < n/2; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i+1; j++) {
					System.out.print("*");
				}
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
			break;
		}	
	}
}
