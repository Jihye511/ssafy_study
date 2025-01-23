import java.util.Scanner;

public class Boj_2991_사나운개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bark1 = sc.nextInt();
        int rest1 = sc.nextInt();
        int bark2 = sc.nextInt();
        int rest2 = sc.nextInt();

        int[] worker = new int[3];  //p m n
        for (int i = 0; i < 3; i++) {
            worker[i] = sc.nextInt();
        }

        for(int time: worker) {
            int cnt = 0;
            if (time % (bark1 + rest1) <= bark1 && time % (bark1 + rest1) > 0) {
                cnt+=1;
            }
            if (time % (bark2 + rest2) <= bark2 && time % (bark2 + rest2) > 0) {
                cnt+=1;
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
