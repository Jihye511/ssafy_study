import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 문자열에서 공백으로 구분된 단어 뒤집기
		 * <>로 감싸진 문자열 태그는 단어가 아님
		 */
		
		String s;
		s = sc.nextLine();
		
		char[] str = s.toCharArray();
		char[] ans = s.toCharArray();
		
		int startIdx = 0;
		boolean inTag = false;
		
		for(int i = 0; i < str.length; i++) {
			
			if((str[i] == ' ' || str[i] == '<') && !inTag) {
				// [startIdx, i-1]까지의 문자열 뒤집기
				for(int j = startIdx, k = i-1; j < i; j++, k--) {
					ans[j] = str[k];
				}
				startIdx = i+1;
			}
			
			if(str[i] == '<') {
				inTag = true;
			}
			if(str[i] == '>') {
				startIdx = i+1;
				inTag = false;
			}
		}
		
		if(startIdx < str.length) {
			// startIdx ~ 끝까지 문자열 뒤집기
			for(int j = startIdx, k = str.length-1; j < str.length; j++, k--) {
				ans[j] = str[k];
			}
		}
		
		for(char c: ans) {
			System.out.print(c);
		}

	}

}
