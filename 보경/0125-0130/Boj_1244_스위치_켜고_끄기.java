import java.util.Scanner;

public class Boj_1244_스위치_켜고_끄기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        boolean[] switches = new boolean[S+1];
        for (int i = 1; i <= S; i++) {
            int s = sc.nextInt();
            if (s == 0) {
                switches[i] = false;
            }
            else {
                switches[i] = true;
            }
        }

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int gender = sc.nextInt();
            int s = sc.nextInt();

            if (gender == 1) {
                //남자
                int counter = s;
                for (int j = s; j <= S; j += counter) {
                    switches[j] = !switches[j];
                }
            }

            else if (gender == 2) {
                //여자
                int counter = 1;
                switches[s] = !switches[s];
                while(true) {
                    if (s+counter <= S && s - counter >= 1) {
                        if (switches[s+counter] == switches[s-counter]) {
                            switches[s+counter] = !switches[s+counter];
                            switches[s-counter] = !switches[s-counter];
                            counter+=1;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i < S+1; i++) {
            if (switches[i]) {
                System.out.print("1 ");
            }
            else {
                System.out.print("0 ");

            }
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
