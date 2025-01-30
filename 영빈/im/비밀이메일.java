import java.io.*;

public class boj2999 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        int N = message.length();
        int R = 0, C = 0;

        for (int r = N; r > 0; r--) {
            if (N % r == 0 && r <= N / r) {
                R = r;
                C = N / r;
                break;
            }
        }

        char[][] arr = new char[R][C];

        int m = 0;
        loop: for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                arr[i][j] = message.charAt(m++);

                if (m == message.length())
                    break loop;
            }
        }

        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                answer += arr[i][j];
        }

        System.out.println(answer);
    }
}