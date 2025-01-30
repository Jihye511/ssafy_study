import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int loc = 0;
            int speed = 0;
             
            for(int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if(a == 1) {
                    speed += sc.nextInt();
                } else if(a == 2) {
                    int ms = sc.nextInt();
                    if(speed < ms) {
                        speed = 0;
                    } else {
                        speed -= ms;
                    }
                }
                loc += speed;
            }
             
            System.out.println("#"+ test_case + " " + loc);
        }
    }
}

