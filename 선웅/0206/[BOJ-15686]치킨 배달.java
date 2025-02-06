import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 지도 입력 및 집, 치킨집 좌표 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cell = Integer.parseInt(st.nextToken());
                if (cell == 1) {
                    houses.add(new Point(i, j));
                } else if (cell == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        
        // 치킨집 조합으로 최대 M개 선택
        combination(0, 0, new int[M]);
        
        System.out.println(answer);
    }
    
    // 재귀를 이용한 조합 생성 (치킨집 인덱스를 저장)
    static void combination(int start, int depth, int[] comb) {
        if (depth == M) {
            int cityDistance = 0;
            // 각 집에 대해 선택된 치킨집 중 최소 거리를 구함
            for (Point house : houses) {
                int minDistance = Integer.MAX_VALUE;
                for (int idx : comb) {
                    Point chicken = chickens.get(idx);
                    int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                    minDistance = Math.min(minDistance, distance);
                }
                cityDistance += minDistance;
            }
            answer = Math.min(answer, cityDistance);
            return;
        }
        
        for (int i = start; i < chickens.size(); i++) {
            comb[depth] = i;
            combination(i + 1, depth + 1, comb);
        }
    }
    
    // 좌표를 표현하기 위한 클래스
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
