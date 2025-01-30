import java.io.*;
import java.util.*;

class swea1873 {

    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            int x = 0;
            int y = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            // H*W 게임 맵
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] gameMap = new char[H][W];
            for (int i = 0; i < gameMap.length; i++) {
                String s = br.readLine();
                for (int j = 0; j < gameMap[i].length; j++) {
                    gameMap[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < gameMap.length; i++) {
                for (int j = 0; j < gameMap[i].length; j++) {
                    if (gameMap[i][j] == '<' || gameMap[i][j] == '>' || gameMap[i][j] == '^' || gameMap[i][j] == 'v') {
                        x = i;
                        y = j;
                        // 시작 위치
                    }
                }
            }

            // 사용자가 넣을 입력의 수
            int userN = Integer.parseInt(br.readLine());
            String userInput = br.readLine(); // 사용자 입력

            // 평지 : 전차가 들어갈 수 있음
            int next = 0;
            int nx = 0;
            int ny = 0;
            int d = state(gameMap[x][y]); // 현재상태

            // 사용자 입력 수만큼 돌리기
            for (int i = 0; i < userN; i++) {
                char input = userInput.charAt(i);

                switch (input) {
                    case 'U': {
                        d = 0;
                        gameMap[x][y] = '^';
                        int hx = x + dx[0];
                        int hy = y + dy[0];

                        if (rangeIn(hx, hy, gameMap) && gameMap[hx][hy] == '.') {
                            gameMap[hx][hy] = '^';
                            gameMap[x][y] = '.';
                            x = hx;
                            y = hy;
                        }

                        break;
                    }
                    case 'D': {
                        d = 1;
                        gameMap[x][y] = 'v';
                        int hx = x + dx[1];
                        int hy = y + dy[1];

                        if (rangeIn(hx, hy, gameMap) && gameMap[hx][hy] == '.') {
                            gameMap[hx][hy] = 'v';
                            gameMap[x][y] = '.';
                            x = hx;
                            y = hy;
                        }
                        break;
                    }
                    case 'L': {
                        d = 2;
                        gameMap[x][y] = '<';
                        int hx = x + dx[2];
                        int hy = y + dy[2];

                        if (rangeIn(hx, hy, gameMap) && gameMap[hx][hy] == '.') {
                            gameMap[hx][hy] = '<';
                            gameMap[x][y] = '.';
                            x = hx;
                            y = hy;
                        }
                        break;
                    }
                    case 'R': {
                        d = 3;
                        gameMap[x][y] = '>';
                        int hx = x + dx[3];
                        int hy = y + dy[3];

                        if (rangeIn(hx, hy, gameMap) && gameMap[hx][hy] == '.') {
                            gameMap[hx][hy] = '>';
                            gameMap[x][y] = '.';
                            x = hx;
                            y = hy;
                        }
                        break;
                    }
                    case 'S': {
                        int sx = x;
                        int sy = y;

                        while (rangeIn(sx, sy, gameMap)) {
                            sx += dx[d];
                            sy += dy[d];
                            if (rangeIn(sx, sy, gameMap)) {
                                next = gameMap[sx][sy];
                                if (next == '*') {
                                    gameMap[sx][sy] = '.';
                                    break;
                                } else if (next == '#') {
                                    break;
                                } else if (next == '.' || next == '-') {
                                    continue;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    default: {
                        break;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < gameMap.length; i++) {
                for (int j = 0; j < gameMap[i].length; j++) {
                    sb.append(gameMap[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static int state(char c) {
        if (c == '^') {
            return 0;
        } else if (c == 'v') {
            return 1;
        } else if (c == '<') {
            return 2;
        } else if (c == '>') {
            return 3;
        }
        return -1;
    }

    static boolean rangeIn(int x, int y, char[][] gameMap) {
        if (x >= 0 && x < gameMap.length && y >= 0 && y < gameMap[x].length) {
            return true;
        } else
            return false;
    }
}