import java.util.*;

public class Main {
    static int H, W, N;
    static int[][] stickers;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        stickers = new int[N][2];

        // 스티커 입력
        for (int i = 0; i < N; i++) {
            stickers[i][0] = sc.nextInt();
            stickers[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int x, y, area;

                area = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];

                x = stickers[i][0] + stickers[j][0];
                y = Math.max(stickers[i][1], stickers[j][1]);
                if (x <= H && y <= W || y <= H && x <= W) {
                    max = Math.max(max, area);
                }

                x = stickers[i][0] + stickers[j][1];
                y = Math.max(stickers[i][1], stickers[j][0]);
                if (x <= H && y <= W || y <= H && x <= W) {
                    max = Math.max(max, area);
                }

                x = stickers[i][1] + stickers[j][0];
                y = Math.max(stickers[i][0], stickers[j][1]);
                if (x <= H && y <= W || y <= H && x <= W) {
                    max = Math.max(max, area);
                }

                x = stickers[i][1] + stickers[j][1];
                y = Math.max(stickers[i][0], stickers[j][0]);
                if (x <= H && y <= W || y <= H && x <= W) {
                    max = Math.max(max, area);
                }

            }
        }
        System.out.println(max);
        sc.close();
    }
}