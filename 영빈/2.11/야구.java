package boj;

import java.util.Scanner;

public class 야구 {

    static int[][] player;
    static int[][] order;
    static boolean[] v;
    static int N;
    static int max = 0;

public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    
    
    N = sc.nextInt();
    player = new int[N + 1][10]; //N이닝, 등번호
    order = new int[N + 1][10]; //N이닝, 등번호
    v = new boolean[10];

    
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= 9; j++) {//[이닝][등번호]
            player[i][j] = sc.nextInt();
        }
    }
    
    attach(4, 1);
    permute(1);
    System.out.println(max);
    
    
    sc.close();
    
}

static void permute(int depth) {
	if(depth == 4) {
		permute(depth + 1);
		return;
	}
	
    if(depth == 10) {
        max = Math.max(max, play(order));
        return;
    }
    
    


    for(int i = 2; i <= 9; i++) {
    	
        if(!v[i]) {
        v[i] = true;
        
        attach(depth, i);
        permute(depth + 1);
        
        v[i] = false;
        }
    }
    return;
}

static void attach(int depth, int x) {
    for(int i = 1; i <= N; i++) {
        
        int temp = player[i][x];
        order[i][depth] = temp;
    }
}


static int play(int[][] ordered) {
    int score = 0;
    
    int n = 1;//이닝
    int x = 1;//등번호
    int outcount = 0;
    boolean[] base = new boolean[4]; //베이스에 주자가 있는지 없는지.

    while(n <= N) {
        
        if(ordered[n][x] == 0) {//아웃이라면
            outcount ++;
            if(outcount == 3) {
                outcount = 0;
                n++;
                for(int i = 1; i <= 3; i++) {
                    base[i] = false;
                }
            }
        }
        else {
            for(int i = 3; i >= 1; i--) 
            {//쳤을때
                if(base[i]) {//주자가 있다면
                    if(i + ordered[n][x] > 3) {//홈으로 들어온다면
                        score++;
                        base[i] = false;
                    }
                    else {
                        base[ordered[n][x] + i] = true;//진루
                        base[i] = false;
                    }
                }
            }
            if(ordered[n][x] > 3) score++;//타자는 홈런이라면
            else base[ordered[n][x]] = true;//아니라면 진루
        }
        x = (x < 9) ? x + 1 : 1;
        
    }
    return score;
}


    
}