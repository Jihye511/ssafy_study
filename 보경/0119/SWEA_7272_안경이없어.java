import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SWEA_7272_안경이없어 {
    public static void main(String[] args) throws Exception {
        //B로 일단 쳐내고
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());

        HashMap<Character, Integer> map = new HashMap<>();
        String zero = "CEFGHIJKLMNSTUVWXYZ";
        String one = "ADOPQR";


        for(int i=0; i < zero.length();i++) {
            char c = zero.charAt(i);
            map.put(c,0);
        }
        for(int i=0; i < one.length();i++) {
            char c = one.charAt(i);
            map.put(c,1);
        }
        map.put('B',2);

        for(int i=0;i<T;i++) {
            String[] input = buffer.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            System.out.printf("#%d %s\n", i+1,check(a,b,map));
        }
    }

    public static String check(String a, String b, HashMap<Character, Integer> map) {
        if (a.length() != b.length()) {
            return "DIFF";
        }

        for (int i=0;i<a.length();i++) {
            if (map.get(a.charAt(i)) != map.get(b.charAt(i))) {
                return "DIFF";
            }
        }
        return "SAME";
    }
}
