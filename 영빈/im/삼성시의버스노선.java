import java.util.Scanner;

class swea6485 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            int num[] = new int[5001];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                for (; a <= b; a++) {
                    num[a]++;
                }
            }
            int p = sc.nextInt();
            for (int i = 0; i < p; i++) {
                sb.append(num[sc.nextInt()]).append(" ");
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
    }
}