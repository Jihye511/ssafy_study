import java.util.Scanner;

class swea6958 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] peoples = new int[n];
            int problem = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    peoples[i] += sc.nextInt();
                }
                problem = Math.max(peoples[i], problem);
            }
            for (int people : peoples) {
                if (people == problem)
                    count++;
            }
            System.out.println("#" + tc + " " + count + " " + problem);

        }
    }
}