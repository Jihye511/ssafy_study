import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                if (word.length() > 0) {
                    result.append(word.reverse());
                    word.setLength(0);
                }
                inTag = true;
                result.append(c);
            } else if (c == '>') {
                inTag = false;
                result.append(c);
            } else if (inTag) {
                result.append(c);
            } else if (c == ' ') {
                result.append(word.reverse());
                result.append(c);
                word.setLength(0);
            } else {
                word.append(c);
            }
        }

        if (word.length() > 0) {
            result.append(word.reverse());
        }

        System.out.println(result);

        sc.close();
    }
}
