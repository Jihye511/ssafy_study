import java.util.Scanner;
//시계방향
public class Jol_1707_달팽이_사각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] snail = new int[n][n];

        //끝까지가면 방향 전환
        int[] d_r = {0,1,0,-1};
        int[] d_c = {1,0,-1,0};

        int move = n-1; //처음 이동거리
        int num = 1;

        for (int i = 0; i < n; i++) {
            snail[0][i] = num++;
        }

        int pos = 1;
        int cr = 0;
        int cc = n-1;
        while(move > 0) {
            for (int cnt = 0; cnt < 2; cnt++) {
                for (int i = 0; i < move; i++) {
                    cr = cr + d_r[pos % 4];
                    cc = cc + d_c[pos % 4];
                    snail[cr][cc] = num++;
                }
                pos += 1;
            }
            move -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                sb.append(String.valueOf(snail[i][j])).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
