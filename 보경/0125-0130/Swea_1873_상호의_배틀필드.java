import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Swea_1873_상호의_배틀필드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            char[][] game = new char[height][width];
            int currR = -1;
            int currC = -1;
            char dir = 'U';
            for (int i = 0; i < height; i++) {
                String input = sc.next();
                for (int j = 0; j < width; j++) {
                    char c = input.charAt(j);
                    game[i][j] = c;
                    if (c == 'v' || c == '<' || c == '>' || c == '^') {
                        currR = i;
                        currC = j;

                        switch (c) {
                            case 'v' : dir = 'D'; break;
                            case '<' : dir = 'L'; break;
                            case '>' : dir = 'R'; break;
                            case '^' : dir = 'U'; break;
                        }
                    }
                }
            }

            Map<Character,int[][]> direction = new HashMap<>();
            direction.put('U', new int[][]{{-1, 0}});
            direction.put('D', new int[][]{{1, 0}});
            direction.put('L', new int[][]{{0, -1}});
            direction.put('R', new int[][]{{0, 1}});

            int N = sc.nextInt();
            String input = sc.next();
            for (int i = 0; i < N; i++) {
                char c = input.charAt(i);

                //이동
                if (c == 'U' || c == 'D' || c == 'L' || c == 'R') {
                    //전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
                    dir = c;
                    int[][] mv = direction.get(c);
                    int nr = currR + mv[0][0];
                    int nc = currC + mv[0][1];

                    if (nr >= 0 && nr < height && nc >= 0 && nc < width) {
                        if (game[nr][nc] == '.')  {  //이동
                            game[currR][currC] = '.';  //이동 후 평지 설정
                            currR = nr;
                            currC = nc;
                        }
                    }
                }

                //슛
                else {
                    int[][] mv = direction.get(dir);
                    int nr = currR;
                    int nc = currC;
                    while (true) {
                        nr += mv[0][0];
                        nc += mv[0][1];

                        if (nr < 0 || nr >= height || nc < 0 || nc >= width) {
                            break;
                        }

                        if (game[nr][nc] == '#') {
                            break;
                        }

                        if (game[nr][nc] == '*') {
                            game[nr][nc] = '.';
                            break;
                        }


                    }
                }
            }

            //명령 끝
            System.out.print("#" + (t+1) + " ");
            //지도 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < height; i++) {
                sb.setLength(0);
                for (int j = 0; j < width; j++) {
                    if (i == currR && j == currC) {
                        switch (dir) {
                            case 'U' : sb.append('^'); break;
                            case 'D' : sb.append('v'); break;
                            case 'L' : sb.append('<'); break;
                            case 'R' : sb.append('>'); break;
                        }
                    }
                    else {
                        sb.append(game[i][j]);
                    }
                }

                System.out.println(sb);
            }

        }
    }
}
