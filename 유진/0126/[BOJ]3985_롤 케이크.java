import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] cake = new int[n+1];
        
        int p = sc.nextInt();
        
        int expect = 0;
        int eIdx = 0;
        int real = 0;
        int rIdx = 0;
        
        for(int i = 1; i < p+1; i++) {
        	int s = sc.nextInt();
        	int e = sc.nextInt();
        	
        	if(expect < e-s+1) {
        		expect = e-s+1;
        		eIdx = i;
        	}
        	
        	int cnt = 0;
        	for(int j = s; j <= e; j++) {
        		if(cake[j] == 0) {
        			cake[j] = i;
        			cnt++;
        		}
        	}
        	if(real < cnt) {
        		real = cnt;
        		rIdx = i;
        	}
        	
        }
         
        System.out.println(eIdx);
        System.out.println(rIdx);
	}
}
