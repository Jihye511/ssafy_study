
import java.util.Scanner;



public class swea7272 {

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();

        for(int t = 0; t < T; t++)
        {
            String text1;
            String text2;

            text1 = sc.next();
            text2 = sc.next();

            char[] OK1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            char[] OK2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};



            for(int i = 0; i < text1.length(); i++)
            {
                char temp = text1.charAt(i);

                if(
                    temp == 'C' || temp == 'E' || temp == 'F' || temp == 'S' ||
                    temp == 'G' || temp == 'H' || temp == 'I' || temp == 'J' || 
                    temp == 'K' || temp == 'L' || temp == 'M' || temp == 'N' ||
                    temp == 'T' || temp == 'U' || temp == 'V' || temp == 'W' ||
                    temp == 'X' || temp == 'Y' || temp == 'Z')
                {
                    OK1[i] = '0';
                }
                else if(temp == 'B')
                {
                    OK1[i] = '2';
                }
                else
                {
                    OK1[i] = '1';
                }
            }
            for(int i = 0; i < text2.length(); i++)
            {
                char temp = text2.charAt(i);

                if(
                    temp == 'C' || temp == 'E' || temp == 'F' || temp == 'S' ||
                    temp == 'G' || temp == 'H' || temp == 'I' || temp == 'J' || 
                    temp == 'K' || temp == 'L' || temp == 'M' || temp == 'N' ||
                    temp == 'T' || temp == 'U' || temp == 'V' || temp == 'W' ||
                    temp == 'X' || temp == 'Y' || temp == 'Z')
                {
                    OK2[i] = '0';
                }
                else if(temp == 'B')
                {
                    OK2[i] = '2';
                }
                else
                {
                    OK2[i] = '1';
                }
            }
            String str1 = new String(OK1);
            String str2 = new String(OK2);

            if(str1.equals(str2))
            {
                System.out.printf("#%d SAME\n", t + 1);
            }
            else
            {
                System.out.printf("#%d DIFF\n", t + 1);
            }
        }
	}
}
    
}
