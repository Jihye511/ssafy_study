import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			if(sc.nextInt() == 1) {
				int num = sc.nextInt();
				for(int j = num; j <= n; j += num) {
					arr[j] = (arr[j]+1)%2;
				}
			} else {
				int num = sc.nextInt();
				arr[num] = (arr[num]+1)%2;
				int maxStep = Math.min(num-1, n-num);
				for(int j = 1; j <= maxStep; j++) {
					if(arr[num-j] == arr[num+j]) {
						arr[num-j] = (arr[num-j]+1)%2;
						arr[num+j] = (arr[num+j]+1)%2;
					} else {
						break;
					}
				}
			}
		}
		
		int idx = 1;
		for(int r = 0; r <= n/20; r++) {
			for(int c = 0; c < 20; c++) {
				System.out.print(arr[idx]+" ");
				idx++;
				if(idx == n+1) return;
			}
			System.out.println();
		}
	}
}
