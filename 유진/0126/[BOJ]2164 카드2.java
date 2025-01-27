import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while(q.size() != 1) {
			q.poll();
			int e = q.poll();
			q.offer(e);
		}
		System.out.println(q.poll());
	}
}
