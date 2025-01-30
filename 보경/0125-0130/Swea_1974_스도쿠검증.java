import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Swea_1974_스도쿠검증 {
    //가로 세로 3x3 격자 비교
    static int[][] sudo = new int[9][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int flag = 1; //겹치지 않음
            for(int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudo[i][j] = sc.nextInt();
                }
            }

            if (!check()){
                flag = 0;
            }

            System.out.printf("#%d %d\n", t+1,flag);

        }


    }

    public static boolean check() {
        //가로
        for (int i = 0; i < 9; i++) {
            if (!compare(sudo[i])) {
                return false;
            }
        }

        //세로
        for (int i = 0; i < 9; i++) {
            int[] v = new int[9];
            for (int j = 0; j < 9; j++) {
                v[j] = sudo[j][i];
            }
            if (!compare(v)) {
                return false;
            }
        }

        //3x3격자 체크
        for (int i = 0; i < 9; i+=3) {
            int[] v = new int[9];
            int idx = 0;
            for (int j = i; j < i+3; j++) {
                for (int k = i; k < i+3; k++) {
                    v[idx] = sudo[j][k];
                    idx++;
                }
            }
            if (!compare(v)) {
                return false;
            }
        }

        return true;
    }

    //한 줄 씩 체크
    public static boolean compare(int[] target) {
        Set<Integer> check = new HashSet<>();
        for (int i : target) {
            if (!check.add(i)) {
                return false;
            }
        }
        return true;
    }
}
