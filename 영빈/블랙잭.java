import java.util.*;

public class boj2798 {

    static int M;
    static int N;
    static int[] card; 
    static int[] usedcard;
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        N = sc.nextInt();
        M = sc.nextInt();

        card = new int[N];
        for(int i = 0; i < N; i++)
        {
            card[i] = sc.nextInt();
        }

        usedcard = new int[N];
        for(int i = 0; i < N; i++)
        {
            usedcard[i] = 0;
        }

        dfs(0, 0, 0);
        System.out.println(res);

        sc.close();

    }

    static void dfs(int start, int cnum, int sum)
    {
        if(cnum == 3)
        {
            if(res < sum)
            {
                res = sum;
            }
            return;
        }

        for(int i = start + 1; i < N; i++)
        {
            if(sum + card[i] <= M)
            {
            dfs(i, cnum + 1, sum + card[i]);
            }
        }
    }
    
}
