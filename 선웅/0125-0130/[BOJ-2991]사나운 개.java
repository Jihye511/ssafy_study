import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int P = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();

        int count = 0;
        int quotient = P % (A + B);
        if (0 < quotient && quotient <= A)
            count++;
        quotient = P % (C + D);
        if (quotient <= C)
            count++;
        System.out.println(count);

        count = 0;
        quotient = M % (A + B);
        if (0 < quotient && quotient <= A)
            count++;
        quotient = M % (C + D);
        if (0 < quotient && quotient <= C)
            count++;
        System.out.println(count);

        count = 0;
        quotient = N % (A + B);
        if (0 < quotient && quotient <= A)
            count++;
        quotient = N % (C + D);
        if (0 < quotient && quotient <= C)
            count++;
        System.out.println(count);
        sc.close();
    }
}