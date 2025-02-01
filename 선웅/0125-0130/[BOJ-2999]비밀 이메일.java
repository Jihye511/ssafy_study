import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 메시지를 받음
        String encryptedMessage = scanner.nextLine();
        int N = encryptedMessage.length();

        // R과 C를 찾음 (R <= C, R * C = N)
        int R = 0, C = 0;
        for (int r = 1; r <= Math.sqrt(N); r++) {
            if (N % r == 0) {
                R = r;
                C = N / r;
            }
        }

        // 행렬을 생성하고 암호 메시지를 행렬에 채움
        char[][] matrix = new char[R][C];
        int index = 0;
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                matrix[i][j] = encryptedMessage.charAt(index++);
            }
        }

        // 행렬을 행 단위로 읽어서 복호 메시지를 생성
        StringBuilder decodedMessage = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                decodedMessage.append(matrix[i][j]);
            }
        }

        // 결과 출력
        System.out.println(decodedMessage.toString());
        scanner.close();
    }
}
