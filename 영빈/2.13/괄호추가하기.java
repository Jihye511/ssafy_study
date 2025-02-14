package boj;

import java.util.Scanner;

public class 괄호추가하기 {
	static int N;
	static String str;
	static int[] num;
	static char[] op;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine();
		num = new int[N/2+1];
		op = new char[N/2];
		int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                num[a++] = str.charAt(i) - '0';
            } else {
                op[b++] = str.charAt(i);
            }
        }
		
		dfs(0, num[0]);
		System.out.println(max);
		
	}
	
	static void dfs(int depth, int res) {
		if(depth == op.length) {
			max = Math.max(max, res);
			return;
		}
		
		//괄호가 없는경우
		int temp1 = cal(res, op[depth], num[depth+1]);
		dfs(depth + 1, temp1);
		
		if(depth + 1 < op.length) {//연산횟수가 남은경우
			int temp2 = cal(num[depth + 1], op[depth + 1], num[depth + 2]);
			int temp3 = cal(res, op[depth], temp2);
			dfs(depth + 2, temp3);
		}
		
		
		
		
		
			
	}

	static int cal(int a, char b, int c) {
		if(b == '+') {
			return a + c;
		}else if(b == '-') {
			return a - c;
		}else if(b == '*') {
			return  a * c;
		}
		return 0;
	}

}
