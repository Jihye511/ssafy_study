import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] values = {1, 5, 10, 50}; // I, V, X, L의 값
    static HashSet<Integer> uniqueNumbers = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.close();
        
        generateNumbers(0, 0, 0);
        System.out.println(uniqueNumbers.size());
    }

    static void generateNumbers(int index, int sum, int count) {
        if (count == N) {
            uniqueNumbers.add(sum);
            return;
        }
        
        for (int i = index; i < 4; i++) {
            generateNumbers(i, sum + values[i], count + 1);
        }
    }
}
