import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int limit = sc.nextInt();
        Integer[] cake = new Integer[n];
        
        for(int i = 0; i < n; i++) {
        	cake[i] = sc.nextInt();
        }
        
        // 정렬 우선순위: 10의 배수 > 길이 
        Arrays.sort(cake, new Comparator<Integer>(){
			
			@Override
			public int compare(Integer a, Integer b) {
				if (a % 10 == 0 && b % 10 != 0) {
					return -1;
				} else if (a % 10 != 0 && b % 10 == 0)  {
					return 1;
				} else {
					return a-b;
				}
			}
		});
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
        	int l = cake[i];
        	
        	if(l == 10) {
        		cnt++;
        	}
        	else if(l > 10 && limit > 0) {
        		int slice = (l-1)/10;
        		slice = (slice > limit) ? limit : slice;
        		cnt += slice;
        		if(l - slice*10 == 10) {
        			cnt++;
        		}
        		limit -= slice;
        	}
        }
        
        System.out.println(cnt);
	}
}
