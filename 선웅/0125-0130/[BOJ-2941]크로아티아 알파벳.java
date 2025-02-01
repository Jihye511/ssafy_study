import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        String input = scanner.nextLine();

        // 크로아티아 알파벳 배열
        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 크로아티아 알파벳을 "*"로 치환
        for (String alphabet : croatianAlphabets) {
            input = input.replace(alphabet, "*");
        }

        // 최종 문자열의 길이 출력
        System.out.println(input.length());
    }
}
