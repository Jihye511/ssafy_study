package 설연휴;

import java.io.*;
import java.util.*;

public class 백준_2941_크로아티아알파벳 {
    static String[] croatia = {"c=", "c-", "dz=", "d-", "lj","nj","s=","z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(String str : croatia){
            input = input.replace(str, "A");
        }
        System.out.println(input.length());
    }
}