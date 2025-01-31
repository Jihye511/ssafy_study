import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static char[] ops;
    static int opCount;
    static long answer = Long.MIN_VALUE; // 문제에서 -2^31보다 크다고 했으므로 int 범위 내지만, 중간 계산 여유로 long 사용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine(); // 개행 처리
        String expression = sc.nextLine();

        // 숫자 개수: (N+1)/2
        // 연산자 개수: (N-1)/2
        int numCount = (N + 1) / 2;
        opCount = (N - 1) / 2;

        nums = new int[numCount];
        ops = new char[opCount];

        // expression 파싱
        // 짝수 인덱스: 숫자, 홀수 인덱스: 연산자
        int numIndex = 0, opIndex = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums[numIndex++] = expression.charAt(i) - '0';
            } else {
                ops[opIndex++] = expression.charAt(i);
            }
        }

        // 만약 연산자가 없는 경우 (N=1 등), 답은 해당 숫자 그 자체
        if (opCount == 0) {
            System.out.println(nums[0]);
            return;
        }

        // 비트마스크를 0부터 (1 << opCount) - 1 까지 순회
        // 각 연산자 위치 i에 대해 비트 i가 1이면 괄호로 묶는다는 의미
        for (int mask = 0; mask < (1 << opCount); mask++) {
            // 인접한 연산자에 모두 괄호가 씌워지면 안 되므로
            // 예: i번째 비트와 (i-1)번째 비트가 동시에 1이면 중첩
            if (!isValidMask(mask)) {
                continue;
            }
            // 이 마스크대로 괄호를 먼저 적용한 뒤, 나머지를 왼->오 순서대로 계산
            long result = evaluateMask(mask);
            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }

    // 연속(인접) 두 비트가 모두 1인지 체크 -> 있으면 false
    private static boolean isValidMask(int mask) {
        // 예: mask = 5 (binary 0101) -> 인접한 1이 있는지
        // i, i+1 둘 다 1이면 안 됨
        // 즉 (mask & (mask << 1)) != 0 이면 인접한 비트가 둘 다 1인 경우 존재
        // 하지만 여기서는 최대 연산자 수가 9이하이므로 단순 loop도 가능
        for (int i = 0; i < opCount - 1; i++) {
            if (((mask >> i) & 1) == 1 && ((mask >> (i + 1)) & 1) == 1) {
                return false;
            }
        }
        return true;
    }

    // mask에 따라 괄호를 먼저 계산하여 새로운 숫자와 연산자 목록을 만든 뒤,
    // 그것을 왼->오 순서대로 계산한 결과 반환
    private static long evaluateMask(int mask) {
        // 새로운 숫자/연산자 리스트(괄호로 인해 하나씩 줄어든 결과)
        List<Long> newNums = new ArrayList<>();
        List<Character> newOps = new ArrayList<>();

        newNums.add((long) nums[0]); // 첫 숫자 추가

        // 0번째 연산자부터 확인
        for (int i = 0; i < opCount; i++) {
            // 현재 연산자를 괄호로 묶는 경우
            if (((mask >> i) & 1) == 1) {
                // newNums의 마지막 값과 nums[i+1]을 ops[i]로 계산한 뒤 업데이트
                long prev = newNums.get(newNums.size() - 1);
                long next = nums[i + 1];
                long calcResult = calc(prev, ops[i], next);
                newNums.set(newNums.size() - 1, calcResult);
            } else {
                // 괄호로 묶지 않는 경우, 그냥 새 숫자와 연산자를 추가
                newNums.add((long) nums[i + 1]);
                newOps.add(ops[i]);
            }
        }

        // 이제 newNums와 newOps를 왼쪽부터 순서대로 연산
        long result = newNums.get(0);
        int idx = 0;
        for (char op : newOps) {
            idx++;
            result = calc(result, op, newNums.get(idx));
        }
        return result;
    }

    // 사칙연산(여기서는 +, -, *) 처리
    private static long calc(long a, char op, long b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        // 기본적으로 주어지지 않는 경우이지만, 혹시 모르므로
        return 0;
    }
}
