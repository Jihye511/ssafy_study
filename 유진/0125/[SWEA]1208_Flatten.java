import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
         
        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int[] boxes = new int[100];
            int sum = 0;
            
            for(int i = 0; i < boxes.length; i++) {
            	boxes[i] = sc.nextInt();
            	sum += boxes[i];
            }
            
            Arrays.sort(boxes);
            int minDiff = sum % 100 == 0 ? 0: 1;
            
            for(int i = 0; i < n; i++) {
            	boxes[0]++;
            	boxes[boxes.length-1]--;

            	Arrays.sort(boxes);
            	if(boxes[boxes.length-1]-boxes[0] == minDiff) break;
            }
             
            System.out.println("#"+ test_case + " " + (boxes[boxes.length-1]-boxes[0]));
        }
    }
}
