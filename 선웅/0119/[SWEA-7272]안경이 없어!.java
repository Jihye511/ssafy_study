import java.util.*;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        sc.nextLine();
        
        // 알파벳의 구멍의 개수를 저장할 해쉬맵 변수 선언
        Map<Character, Integer> holeMap = new HashMap<>();
        
        // 구멍의 개수가 0개인 알파벳
        for (char c : "CEFGHIJKLMNSTUVWXYZ".toCharArray()) {
            holeMap.put(c, 0);
        }
         
        // 구멍의 개수가 1개인 알파벳
        for (char c : "ADOPQR".toCharArray()) {
            holeMap.put(c, 1);
        }
        
        // 구멍의 개수가 2개인 알파벳
        holeMap.put('B', 2);

        // test case만큼 반복
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 두 문자열을 받음
            String[] input = sc.nextLine().split(" ");
            String str1 = input[0];
            String str2 = input[1];
             
            // 먼저 문자열의 길이 비교
            if(str1.length() != str2.length()) {
                System.out.println("#" + test_case + " DIFF");
                continue;
            }
            
            boolean isSame = true;
            // 순서대로 알파벳의 개수가 같은지 확인
            for(int i = 0; i < str1.length(); i++) {
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(i);
                 
                if (holeMap.get(ch1) != holeMap.get(ch2)) {
                    isSame = false;
                    break;
                }
            }
            
            if(isSame) {
                System.out.println("#" + test_case + " SAME");
            }else {
                System.out.println("#" + test_case + " DIFF");
            }
        }
        sc.close();
    }
}