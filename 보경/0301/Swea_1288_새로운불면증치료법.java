import java.io.*;
import java.util.*;
public class Swea_1288_새로운불면증치료법 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
//            int cnt = 0;
//            boolean[] num = new boolean[10]; //얘를 비트마스킹
            int total = (1 << 10) -1 ;  //1111111111
//            System.out.println(Integer.toBinaryString(total));
            int visited = 0; //0000000000
            int repeat = 1;
            while (true) {
                int target = N * repeat;
                //하나씩 파싱
                while (target > 0) {
                    int n = target % 10;
                    target /= 10;
                    visited |= (1 << n);  //1로 설정
                }
                if (visited == total) {
                    break;
                }
                repeat++;
            }
            System.out.printf("#%d %d\n",t,N*repeat);
        }
    }
}
