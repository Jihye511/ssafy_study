import java.io.*;
import java.util.*;

public class 백준_11399 {

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        int sum=0;
        int total=0;
        for(int i =0; i<n; i++) {
            sum+= + map[i];
            total += sum;
        }
        System.out.println(total);
    }

}
