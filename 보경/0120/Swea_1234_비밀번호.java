import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_1234_비밀번호 {
    public static void main(String[] args) throws Exception {
        int T = 2;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < T; i++) {
            String[] input = bf.readLine().split(" ");
            int len = Integer.parseInt(input[0]);
            String pw = input[1];

            while (true) {
                String res = cut(pw,pw.length());
                if (res.equals(pw)) {
                    break;
                }
                pw = res;
            }
            System.out.print("#"+(i+1)+" " + pw);
        }
    }

    public static String cut(String str, int len) {
        for(int j = 0; j < len-1; j++) {
            if (str.charAt(j) == str.charAt(j+1)) {
                String temp = "";
                temp += str.substring(0,j);
                if (j+2 < len) { //맨 끝
                    temp += str.substring(j+2,len);
                }
                return temp;
            }
        }
        return str;
    }
}
