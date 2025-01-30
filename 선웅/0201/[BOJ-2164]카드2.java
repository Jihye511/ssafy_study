import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // Deque to simulate the card operations
        Deque<Integer> deque = new ArrayDeque<>();

        // Initialize the deque with cards from 1 to N
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        // Simulate the process until only one card is left
        while (deque.size() > 1) {
            // Remove the top card
            deque.pollFirst();
            // Move the next top card to the bottom
            deque.addLast(deque.pollFirst());
        }

        // Output the last remaining card
        System.out.println(deque.peekFirst());
    }
}
