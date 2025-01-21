package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1592_영식이와_친구들 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = bf.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int l = Integer.parseInt(input[2]);
		int[] count = new int[n];
		throwing(count, n, m, l, 0);
		int result = 0;
		for (int i : count) {
			result += i;
		}
		System.out.println(result -1);
	}
	
	public static void throwing(int[] count, int n,int m, int l,int start) {
		//던지고 더 던질 수 있는지 판단하는 함수
		while (true) {
			count[start] += 1;
			if (count[start] == m) {
				break;
			}
			if (count[start] % 2 == 0) {
				//짝수
				if (start - l < 0) {
					start = n + start -l;
				}
				else {
					start -= l;
				}
			}
			
			else {
				if (start + l >= n) {
					start = start + l - n;
				}
				else {
					start += l;
				}
			}
		}
	}
}
