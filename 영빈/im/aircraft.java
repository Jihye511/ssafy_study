import java.util.Scanner;


public class App {

    private static boolean isValid(int[][] map, int x1, int y1, int x2, int y2, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = x1; i <= x2; i++)
        {
            for (int j = y1; j <= y2; j++)
            {
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        return (max - min) <= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    map[i][j] = sc.nextInt();
                }
            }

            int maxArea = 0;

            for (int x1 = 0; x1 < n; x1++) //전체맵 탐색
            {
                for (int y1 = 0; y1 < n; y1++) 
                {
                    for (int x2 = x1; x2 < n; x2++) //부분맵 탐색
                    {
                        for (int y2 = y1; y2 < n; y2++) 
                        {
                            if (isValid(map, x1, y1, x2, y2, k)) //부분맵이 K값에대해 유효한지지
                            {
                                int area = (x2 - x1 + 1) * (y2 - y1 + 1);
                                maxArea = Math.max(maxArea, area);
                            }
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + maxArea);
        }

        sc.close();
    }
}
