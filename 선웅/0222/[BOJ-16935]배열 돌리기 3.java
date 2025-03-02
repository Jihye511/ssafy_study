import java.util.*;

// 그냥 수학 문제인듯

public class Main {
    static int N, M, R;
    static int[][] arr;
    static int i = 1;
    static int[] calc;
    static int[][] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][M];
        // 입력 받고
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                arr[x][y] = sc.nextInt();
            }
        }

        // 연산 넣고
        calc = new int[R];
        boolean rotate = false;
        for (int turn = 0; turn < R; turn++) {
            int command = sc.nextInt();
            if (command == 3 || command == 4) {
                rotate = !rotate;
            }
            calc[turn] = command;
        }
        // 3번 4번을 홀수 번 하면 정답의 배열 크기가 달라짐(중요!!)
        if (rotate) {
            ans = new int[M][N];
        } else {
            ans = new int[N][M];
        }
        // 배열의 각 수별로 모든 연산을 마친 후 위치로 옮기기(딱 한 번 저장하므로 최적화가 적절히 이루어진듯)
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                int i = x;
                int j = y;
                int height = N;
                int width = M;
                for (int turn = 0; turn < R; turn++) {
                    int command = calc[turn];
                    // 연산별로 위치 계산(그냥 수학문제 맞는듯)
                    // 이런 건 공책에 직접 풀이해서 수식만 적는 게 편할 듯
                    switch (command) {
                        case 1: {
                            i = height - 1 - i;
                            break;
                        }
                        case 2: {
                            j = width - 1 - j;
                            break;
                        }
                        case 3: {
                            int temp = i;
                            i = j;
                            j = height - 1 - temp;
                            temp = width;
                            width = height;
                            height = temp;
                            break;
                        }
                        case 4: {
                            int temp = i;
                            i = width - 1 - j;
                            j = temp;
                            temp = width;
                            width = height;
                            height = temp;
                            break;
                        }
                        case 5: {
                            if (i >= 0 && i < height / 2 && j >= 0 && j < width / 2) {
                                j = j + width / 2;
                            } else if (i >= 0 && i < height / 2 && j >= width / 2 && j < width) {
                                i = i + height / 2;
                            } else if (i >= height / 2 && i < height && j >= width / 2 && j < width) {
                                j = j - width / 2;
                            } else if (i >= height / 2 && i < height && j >= 0 && j < width / 2) {
                                i = i - height / 2;
                            }
                            break;
                        }
                        case 6: {
                            if (i >= 0 && i < height / 2 && j >= 0 && j < width / 2) {
                                i = i + height / 2;
                            } else if (i >= 0 && i < height / 2 && j >= width / 2 && j < width) {
                                j = j - width / 2;
                            } else if (i >= height / 2 && i < height && j >= width / 2 && j < width) {
                                i = i - height / 2;
                            } else if (i >= height / 2 && i < height && j >= 0 && j < width / 2) {
                                j = j + width / 2;
                            }
                            break;
                        }
                    }
                }
                ans[i][j] = arr[x][y];
            }
        }
        // 정답의 크기에 따라 출력 방법이 달라짐(중요!!)
        if (rotate) {
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    System.out.printf("%d ", ans[x][y]);
                }
                System.out.println();
            }
        } else {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    System.out.printf("%d ", ans[x][y]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}