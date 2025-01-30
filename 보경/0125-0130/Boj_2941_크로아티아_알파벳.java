import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_2941_크로아티아_알파벳 {
    public static void main(String[] args) {
        /*
        c=
ć	c-
dž	dz=
đ	d-
lj	lj
nj	nj
š	s=
ž	z=
         */

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Set<String> len2 = Set.of("c=","c-","d-","lj","nj","s=","z=");
        Set<Character> chars = Set.of('c','d','l','n','s','z');
        String len3 = "dz=";

        int result = 0;

        int i = 0;
        while (i < input.length()) {
            //dz= 만 세글자
            if (chars.contains(input.charAt(i))) {
                if (i < input.length() - 1 && len2.contains(input.substring(i,i+2))) {
                    result += 1;
                    i+=2;
                    continue;
                }
                if (i + 3 <= input.length() && input.substring(i,i+3).equals(len3)) {
                    result += 1;
                    i += 3;
                    continue;
                }

            }
            result += 1;
            i += 1;
        }
        System.out.println(result);
    }
}
