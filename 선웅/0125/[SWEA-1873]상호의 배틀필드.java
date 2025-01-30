import java.util.Scanner;

public class Solution {
    static int H, W, N;
    static char[][] map;
    static int tankR, tankC;       // 전차의 현재 위치
    static char tankDir;           // 전차가 바라보는 방향

    // 이동을 위한 방향 벡터
    // up, down, left, right 순서
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    // 방향 문자 -> 인덱스 매핑용 (U, D, L, R 순)
    // U -> 0, D -> 1, L -> 2, R -> 3
    private static int dirToIndex(char dir) {
        switch (dir) {
            case '^': return 0; // U
            case 'v': return 1; // D
            case '<': return 2; // L
            case '>': return 3; // R
        }
        return -1; // error case
    }

    // 명령 문자(U, D, L, R)를 방향 문자(^, v, <, >)로 변환하기
    private static char commandToTankDir(char cmd) {
        switch (cmd) {
            case 'U': return '^';
            case 'D': return 'v';
            case 'L': return '<';
            case 'R': return '>';
        }
        return '^'; // 기본값, 사실상 도달하지 않을 것
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            // H, W 읽기
            H = sc.nextInt();
            W = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            map = new char[H][W];
            tankR = -1;
            tankC = -1;
            tankDir = '^'; // 기본값

            // 맵 입력받으면서 전차 위치, 방향 찾기
            for (int i = 0; i < H; i++) {
                String row = sc.nextLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = row.charAt(j);

                    // 전차가 놓여있는 칸 탐색
                    if (map[i][j] == '^' || map[i][j] == 'v' 
                            || map[i][j] == '<' || map[i][j] == '>') {
                        tankR = i;
                        tankC = j;
                        tankDir = map[i][j];
                        // 해당 칸을 평지로 바꿔둔다(전차는 따로 위치/방향 보관)
                        map[i][j] = '.';
                    }
                }
            }

            N = sc.nextInt(); // 명령 개수
            sc.nextLine();    // 버퍼 비우기
            String commands = sc.nextLine(); // 명령어 문자열

            // 명령어 하나씩 처리
            for (int i = 0; i < N; i++) {
                char cmd = commands.charAt(i);

                if (cmd == 'U' || cmd == 'D' || cmd == 'L' || cmd == 'R') {
                    // 방향 갱신
                    tankDir = commandToTankDir(cmd);

                    // 이동 시도
                    moveTank(tankDir);
                } else if (cmd == 'S') {
                    // 포탄 발사
                    shoot(tankDir);
                }
            }

            // 모든 명령 처리 후, 전차가 위치한 곳에 전차 방향 기호를 표시
            map[tankR][tankC] = tankDir;

            // 출력
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

        sc.close();
    }

    // 전차 이동 함수
    private static void moveTank(char dir) {
        int idx = dirToIndex(dir);
        int nr = tankR + dR[idx];
        int nc = tankC + dC[idx];

        // 맵 범위 내이고 평지('.')일 경우 이동
        if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
            if (map[nr][nc] == '.') {
                tankR = nr;
                tankC = nc;
            }
        }
    }

    // 전차 사격 함수
    private static void shoot(char dir) {
        int idx = dirToIndex(dir);

        // 현재 전차 위치에서 시작하지 않고, 다음 칸부터 탐색
        int r = tankR + dR[idx];
        int c = tankC + dC[idx];

        // 게임 맵을 벗어날 때까지, 혹은 벽(# 혹은 *)에 부딪힐 때까지 이동
        while (r >= 0 && r < H && c >= 0 && c < W) {
            if (map[r][c] == '*') {
                // 벽돌 벽이면 파괴(평지로 변경) 후 포탄 소멸
                map[r][c] = '.';
                break;
            } else if (map[r][c] == '#') {
                // 강철 벽이면 그대로 두고 포탄 소멸
                break;
            }
            // 그 외이면 계속 직진
            r += dR[idx];
            c += dC[idx];
        }
    }
}
