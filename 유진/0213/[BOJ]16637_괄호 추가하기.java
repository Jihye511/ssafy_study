import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Character> ops = new ArrayList<>();
	static ArrayList<Integer> nums = new ArrayList<>();
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		
		for(int i = 0; i < n/2+1; i++) {
			nums.add(s.charAt(i*2)-'0') ;
		}
		for(int i = 0; i < n/2; i++) {
			ops.add(s.charAt(i*2+1));
		}
		
		ArrayList<Integer> op = new ArrayList<>();
		selectOp(0, op);
		System.out.println(ans);
	}
	
	// 괄호 연산할 연산자 인덱스 선택
	// 중첩 괄호 X: 이웃한 연산자 선택 불가 
	static void selectOp(int start, ArrayList<Integer> op) {
		calcEx(op);
		if(start > ops.size()-1) return;
		
		for(int i = start; i < ops.size(); i++) {
			if(op.isEmpty() || op.get(op.size()-1) != i-1) {
				op.add(i);
				selectOp(i+1, op);
				op.remove(op.size()-1);
			}
		}
	}
	
	static void calcEx(ArrayList<Integer> op) {
		ArrayList<Character> newOps = new ArrayList<>(ops);
		ArrayList<Integer> newNums = new ArrayList<>(nums);
		// 선택한 연산자 먼저 계산
		for(int idx: op) {
			int res = calc(newNums.get(idx), newNums.get(idx+1), newOps.get(idx));
			newNums.set(idx+1, res);
		}
		// 사용한 연산자 및 숫자 삭제 
		for(int i = op.size()-1; i >= 0;  i--) {
			int idx = op.get(i);
			newOps.remove(idx);
			newNums.remove(idx);
		}
		//나머지 연산 순서대로 
		for(int idx = 0; idx < newOps.size(); idx++) {
			int res = calc(newNums.get(idx), newNums.get(idx+1), newOps.get(idx));
			newNums.set(idx+1, res);
		}
		
		ans = Math.max(ans, newNums.get(newNums.size()-1));
	}
	
	static int calc(int a, int b, char c) {
		switch(c) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		default:
			return 0;
		}
	}
}
