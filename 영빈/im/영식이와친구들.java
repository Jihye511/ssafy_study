import java.util.*;


public class boj1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] seat = new int[N];
        int pos = 0;
        int count = 0;


        for(int i = 0; i < N; i++)
        {
            seat[i] = 0;
        }


        seat[pos] = 1;
        while(true)
        {

            if(seat[pos] == M)
            {
                break;
            }
            
            if(seat[pos]%2 == 1)
            {
                if(pos + L >= N)
                {
                    pos = pos + L - N;
                }
                else{
                    pos += L;
                }
                
            }
            else
            {
                if(pos - L < 0)
                {
                    pos = pos - L + N;
                }
                else{
                    pos -= L;
                }
                
            }
            seat[pos]++;
            count++;
            

        }

        System.out.println(count);
        
    }
    
}
