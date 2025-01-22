import java.util.Scanner;

public class swea2805 {

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int size = sc.nextInt();
            int[][] map = new int[size][size];

            for(int i = 0; i < size; i++)
            {
                for(int j =0; j < size; j++)
                {
                    map[i][j] = sc.nextInt();
                }
            }
            
            int middle = (size-1)/2;
            int sum = 0;

            for(int i = 0; i < size; i++)
            {
                for(int j =0; j < size; j++)
                {
                    if(i+j < middle)
                    {
                        continue;
                    }
                    else if(Math.abs(i - j) > middle)
                    {
                        continue;
                    }
                    else if((i+j) * 3 > middle)
                    {
                        continue;
                    }
                    sum += map[i][j];

                }
            }

            System.out.println(sum);

		}

    }
    
}
