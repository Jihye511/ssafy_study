import java.util.Scanner;

public class boj2991 {// 사나운개
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int C = sc.nextInt();
        int D = sc.nextInt();

        int P = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();
        int time = 0;
        boolean firence1;
        boolean firence2;

        int attack1 = 0;
        int attack2 = 0;
        int attack3 = 0;

        while (time < 1000) {
            if (time % (A + B) < A) {
                firence1 = true;
            } else {
                firence1 = false;
            }

            if (time % (C + D) < C) {
                firence2 = true;
            } else {
                firence2 = false;
            }

            if (time + 1 == P) {
                if (firence1)
                    attack1++;
                if (firence2)
                    attack1++;
            }
            if (time + 1 == M) {
                if (firence1)
                    attack2++;
                if (firence2)
                    attack2++;
            }
            if (time + 1 == N) {
                if (firence1)
                    attack3++;
                if (firence2)
                    attack3++;
            }

            time++;
        }

        System.out.println(attack1);
        System.out.println(attack2);
        System.out.println(attack3);
    }
}
