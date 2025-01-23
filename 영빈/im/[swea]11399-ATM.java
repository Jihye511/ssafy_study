import java.util.Arrays;
import java.util.Scanner;;

public class swea1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];

        for(int i = 0; i < N; i++)
        {
            P[i] = sc.nextInt();
        }


        Arrays.sort(P);
        int total = 0;
        int[] D = new int[N];
        for(int i = 0; i < N; i++)
        {
            D[i] = 0;
        }
        for(int i =0; i<N; i++) {
            
            for(int j = 0; j <= i; j++){
                D[i] += P[j];
            }
        }

        for(int i = 0; i < N; i++)
        {
            total += D[i];
        }
        System.out.println(total);

        
    }

}
