package B형_0301_0302;
import java.io.*;
import java.util.*;
class Node{
    int num;
    String c;
    int left,right;
    public Node(int num, String c, int left, int right){
        this.num = num;
        this.c = c;
        this.left = left;
        this.right = right;
    }
}
public class SWEA_1231 {
    static Node[] node;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            node = new Node[N+1];
            StringTokenizer st;
            for(int i =0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String c = st.nextToken();
                int left = -1, right = -1;
                if (st.hasMoreTokens()) left = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right = Integer.parseInt(st.nextToken());
                node[num] =new Node(num,c,left,right);
            }
            inorder(1);
            System.out.println("#" +t + " "+ sb.toString());

        }
    }
    public static void inorder(int cur){
        if(cur ==-1 )return;
        if(node[cur] ==null) return;

        inorder(node[cur].left);
        sb.append(node[cur].c);
        inorder(node[cur].right);
    }
}