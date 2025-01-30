import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int storeCount = scanner.nextInt();

        List<Integer> storePositions = new ArrayList<>();
        for (int i = 0; i < storeCount; i++) {
            int direction = scanner.nextInt();
            int distance = scanner.nextInt();
            storePositions.add(convertToPerimeterPosition(direction, distance, width, height));
        }

        int guardDirection = scanner.nextInt();
        int guardDistance = scanner.nextInt();
        int guardPosition = convertToPerimeterPosition(guardDirection, guardDistance, width, height);

        int perimeter = 2 * (width + height);
        int totalDistance = 0;

        // 각 상점과 동근이 사이의 최단 거리 계산
        for (int storePosition : storePositions) {
            int clockwiseDistance = Math.abs(guardPosition - storePosition);
            int counterClockwiseDistance = perimeter - clockwiseDistance;
            totalDistance += Math.min(clockwiseDistance, counterClockwiseDistance);
        }

        // 출력
        System.out.println(totalDistance);
    }

    // 상점의 위치를 블록의 둘레 위치로 변환
    private static int convertToPerimeterPosition(int direction, int distance, int width, int height) {
        if (direction == 1) { // 북쪽
            return distance;
        } else if (direction == 2) { // 남쪽
            return width + height + (width - distance);
        } else if (direction == 3) { // 서쪽
            return 2 * (width + height) - distance;
        } else { // 동쪽
            return width + distance;
        }
    }
}
