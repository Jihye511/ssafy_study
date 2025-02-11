import java.util.*;

public class Main {
    static int N;
    static int[][] playersScores;
    static List<List<Integer>> perm = new ArrayList<>();
    static int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static int maxScore = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        playersScores = new int[N][10];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 9; j++) {
                playersScores[i][j] = sc.nextInt();
            }
        }
        boolean[] used = new boolean[nums.length];
        permutation(new ArrayList<>(), used, perm);
        for (List<Integer> l : perm) {
            countScore(l);
        }
        if(maxScore != Integer.MIN_VALUE){
        System.out.println(maxScore);
        }else{
            System.out.println(0);
        }
        sc.close();
    }

    public static void countScore(List<Integer> list) {
        int score = 0;
        int index = 0;
        for (int game = 0; game < N; game++) {
            int out = 0;
            int[] basemen = new int[4];
            while (out < 3) {
                int player = list.get(index);
                int hit = playersScores[game][player];
                index = (index + 1) % 9;
                switch (hit) {
                    case 0: {
                        out++;
                        break;
                    }
                    case 1: {
                        score += basemen[3];
                        basemen[3] = basemen[2];
                        basemen[2] = basemen[1];
                        basemen[1] = 1;
                        break;
                    }
                    case 2: {
                        score += basemen[3] + basemen[2];
                        basemen[3] = basemen[1];
                        basemen[2] = 1;
                        basemen[1] = 0;
                        break;
                    }
                    case 3: {
                        score += basemen[3] + basemen[2] + basemen[1];
                        basemen[3] = 1;
                        basemen[2] = 0;
                        basemen[1] = 0;
                        break;
                    }
                    case 4: {
                        score += basemen[3] + basemen[2] + basemen[1] + 1;
                        basemen[3] = 0;
                        basemen[2] = 0;
                        basemen[1] = 0;
                        break;
                    }

                }
            }
        }
        maxScore = Math.max(maxScore, score);
    }

    public static void permutation(List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (current.size() == 3) {
            used[0] = true;
            current.add(nums[0]);
            permutation(current, used, result);
            current.remove(current.size() - 1);
            used[0] = false;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                permutation(current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }

    }
}