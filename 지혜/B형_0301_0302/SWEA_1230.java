package B형_0301_0302;
import java.io.*;
import java.util.*;
public class SWEA_1230 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T =10;
        for(int t =1; t<=T;t++){
            int N = Integer.parseInt(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<M; i++){
                int idx =0;
                int count =0;
                String command = st.nextToken();
                if(command.equals("I")){
                    idx = Integer.parseInt(st.nextToken());
                    count = Integer.parseInt(st.nextToken());
                    while(count -->0){
                        list.add(idx++, Integer.parseInt(st.nextToken()));
                    }
                }else if(command.equals("D")){
                    idx = Integer.parseInt(st.nextToken());
                    count = Integer.parseInt(st.nextToken());
                    while(count -->0){
                        list.remove(idx);
                    }
                }else {
                    count = Integer.parseInt(st.nextToken());
                    while(count-->0){
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }

            }
            System.out.print("#" + t +" ");
            for(int i =0; i<10; i++){
                System.out.print(list.get(i) +" ");
            }
            System.out.println();
        }
    }
}
