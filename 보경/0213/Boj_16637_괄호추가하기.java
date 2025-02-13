import java.util.*;
import java.io.*;

public class Boj_16637_괄호추가하기 {
    static ArrayList<ArrayList<Integer>> bracket;
    static int result;
    static int len;
    static char[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //연산자 우선순위 동일

        len = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        //괄호를 추가하거나 안하거나
        //짝수 : 숫자, 홀수 : 연산자

        result = Integer.MIN_VALUE;
        getResult(1,input[0]-'0');
        System.out.println(result);
    }

    static int calc(int a, int b, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
        }
        return -1;
    }

    //idx : 현재 연산자, res : 이전 계산값
    static void getResult(int idx, int res) {
        //8*3+5+2
        if (idx >= len) {
            result = Math.max(res,result);
            return;
        }

        //뒤에 괄호를 씌울 수 있는 연산이 남아 있는 경우
        if (idx + 3 < len) {
            //괄호
            //오른쪽 연산 먼저 수행후 현재 연산자로 계산
            getResult(idx+4,calc(res,calc(input[idx+1] - '0',input[idx+3]  - '0',input[idx+2]),input[idx]));
        }

        //괄호x
        //현재 연산 먼저 수행
        getResult(idx+2, calc(res,input[idx+1]-'0',input[idx]));
    }
}
