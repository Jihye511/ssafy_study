import java.util.Scanner;

public class swea1289 {// 메모리복구
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < T; t++) {
            String str = sc.nextLine();
            int count = 0;
            if (str.charAt(0) == '0') {
                count--;
            }

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '1') {
                    while (i + 1 < str.length() && str.charAt(i + 1) == '1') {
                        i++;
                    }
                    count++;
                } else {
                    while (i + 1 < str.length() && str.charAt(i + 1) == '0') {
                        i++;
                    }
                    count++;
                }
            }
            System.out.printf("#%d %d\n", t + 1, count);
        }
    }

}
