import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            while (st.hasMoreTokens()) {
                String command = st.nextToken();
                if (command.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    List<Integer> temp = new ArrayList<>();
                    for (int i = 0; i < y; i++) {
                        temp.add(Integer.parseInt(st.nextToken()));
                    }
                    list.addAll(x, temp);
                } else if (command.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; i++) {
                        if (x < list.size()) {
                            list.remove(x);
                        }
                    }
                } else if (command.equals("A")) {
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; i++) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            
            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < 10 && i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
