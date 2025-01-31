import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int speed = 0;
            int distance = 0;
            for (int i = 0; i < N; i++) {
                int command = sc.nextInt();
                switch (command) {
                    case 0: {
                        distance += speed;
                        break;
                    }
                    case 1: {
                        int up = sc.nextInt();
                        speed += up;
                        distance += speed;
                        break;
                    }
                    case 2: {
                        int down = sc.nextInt();
                        speed -= down;
                        if (speed < 0) {
                            speed = 0;
                        }
                        distance += speed;
                    }
                }
            }
            System.out.println("#" + t + " " + distance);
        }

        sc.close();
    }
}
