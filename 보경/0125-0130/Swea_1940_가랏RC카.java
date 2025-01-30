import java.util.Scanner;

public class Swea_1940_가랏RC카 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int speed = 0; //초기 속도
            int distance = 0;
            for (int j = 0; j < n; j++) {
                int cm = sc.nextInt();
                if (cm == 1) { //가속
                    int changeSpeed = sc.nextInt();
                    speed += changeSpeed;
                    distance += speed;
                }
                else if (cm == 2) {
                    int changeSpeed = sc.nextInt();
                    if (changeSpeed > speed) {
                        speed = 0;
                        continue;
                    }
                    speed -= changeSpeed;
                    distance += speed;
                }

                else {
                    //속도 유지
                    distance += speed;
                }
            }
            System.out.printf("#%d %d\n", i+1, distance);
        }
    }
}
