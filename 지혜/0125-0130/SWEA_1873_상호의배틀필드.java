package 설연휴;
import java.io.*;
import java.util.*;
public class SWEA_1873_상호의배틀필드 {
    static int H;
    static int W;
    static char[][] map;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t =1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            int x =0; //전차 위치좌표
            int y = 0;
            for(int i =0; i<H; i++){
                String str = br.readLine();
                for(int j =0; j<W; j++){
                    map[i][j] = str.charAt(j);
                    if(isTank(map[i][j])){
                        x = i;
                        y = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            //게임 실행
            for(int i =0; i<input.length(); i++){
                char play = input.charAt(i);
                if(play =='U'){
                    //전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동
                    map[x][y] = '^';
                    if(isValidMove(x-1,y)&& map[x-1][y] =='.'){
                        map[x-1][y]='^';
                        map[x][y] ='.';
                        x = x-1;
                    }
                }else if(play =='D'){
                    //전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동
                    map[x][y] = 'v';
                    if(isValidMove(x+1,y)&&map[x+1][y] =='.'){
                        map[x+1][y]='v';
                        map[x][y] ='.';
                        x = x+1;
                    }

                }else if(play =='L'){
                    //전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
                    map[x][y] = '<';
                    if( isValidMove(x,y-1)&&map[x][y-1] =='.'){
                        map[x][y-1]='<';
                        map[x][y] ='.';
                        y = y-1;
                    }

                }else if(play =='R'){
                    //전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동
                    map[x][y] = '>';
                    if(isValidMove(x,y+1)&& map[x][y+1] =='.'){
                        map[x][y+1]='>';
                        map[x][y] ='.';
                        y = y+1;
                    }

                }else if(play =='S'){
                    //전차가 현재 바라보고 있는 방향으로 포탄을 발사
                    char now = map[x][y];
                    if(now =='^'){
                        for(int j =x-1; j>=0; j--){
                            char next = map[j][y];
                            if(next =='.') continue;
                            else if(next =='*'){
                                map[j][y] ='.';
                                break;
                            }
                            else if(next =='#')break;
                            //외에는 걍 암것도 안일어남
                        }
                    }else if(now =='v'){
                        for(int j =x+1; j<H; j++){
                            char next = map[j][y];
                            if(next =='.') continue;
                            else if(next =='*'){
                                map[j][y] ='.';
                                break;
                            }
                            else if(next =='#')break;
                            //외에는 걍 암것도 안일어남
                        }

                    }else if(now =='<'){
                        for(int j =y-1; j>=0; j--){
                            char next = map[x][j];
                            if(next =='.') continue;
                            else if(next =='*'){
                                map[x][j] ='.';
                                break;
                            }
                            else if(next =='#')break;
                            //외에는 걍 암것도 안일어남
                        }

                    }else if(now =='>'){
                        for(int j =y+1; j<W; j++){
                            char next = map[x][j];
                            if(next =='.') continue;
                            else if(next =='*'){
                                map[x][j] ='.';
                                break;
                            }
                            else if(next =='#')break;
                            //외에는 걍 암것도 안일어남
                        }

                    }
                }

            }
            StringBuilder sb = new StringBuilder("#" + t + " ");
            for (char[] row : map) {
                sb.append(row).append("\n");
            }
            System.out.print(sb);

        }
    }
    static boolean isValidMove(int nx, int ny) {
        return nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.';
    }
    static boolean isTank(char c) {
        return c == '^' || c == 'v' || c == '<' || c == '>';
    }
}
