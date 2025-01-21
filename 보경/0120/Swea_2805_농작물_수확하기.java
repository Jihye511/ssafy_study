import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_2805_농작물_수확하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int total = 0;
            int size = Integer.parseInt(bf.readLine());

            int[][] maps = new int[size][size];

            //배열 입력 받기
            for (int j = 0; j < size; j++) {
                String input = bf.readLine();
                for (int k = 0; k < size; k++) {
                    maps[j][k] = input.charAt(k) - '0';
                }
            }

            for (int cnt = 0; cnt < size/2; cnt++) {
                for (int z = 0; z < cnt*2+1; z++) {  //읽을 개수
                    total += maps[cnt][Math.abs(size / 2 - cnt) + z];
                    total += maps[size-1-cnt][Math.abs(size / 2 - cnt)];
                }
            }

            for (int j = 0; j < size; j++) {
                total += maps[size/2][j];
            }

            System.out.printf("#%d %d\n",i+1, total);
        }
    }
}
