import java.io.*;
import java.net.Inet4Address;
import java.util.*;
public class SWEA_1248 {
    static int V,E,first,second;
    static ArrayList<Integer>[] parents;
    static ArrayList<Integer>[] child;
    static int subtree;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T; t++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st= new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            parents = new ArrayList[V+1];
            child = new ArrayList[V+1];
            subtree = 0;
            for(int i =0; i<=V; i++){
                parents[i] = new ArrayList<>();
                child[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<E; i++){
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                parents[c].add(p); //부모를 저장
                child[p].add(c);
            }

            ArrayList<Integer> list1 = bfs(first);
            ArrayList<Integer> list2 = bfs(second);
            int root = -1;
            loop:
            for(int v : list1){
                for(int m : list2){
                    if(v == m){
                        root = v;
                        break loop;
                    }
                }
            }

            System.out.println("#" +t+ " " + root +" " +subTree(root,0));

        }

        
    }
    public static int subTree(int c, int depth){
        boolean[] v = new boolean[V+1];
        int cnt=1;
        Queue<Integer> q= new LinkedList<>();
        q.offer(c);
        v[c] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0; i<child[cur].size(); i++){
                int next = child[cur].get(i);
                if(v[next]) continue;

                v[next] = true;
                q.offer(next);
                cnt++;
            }
        }
        return cnt;
    }
    public static ArrayList<Integer> bfs(int idx){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] v = new boolean[V+1];
        Queue<Integer> q= new LinkedList<>();
        q.offer(idx);
        v[idx] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0; i<parents[cur].size(); i++){
                int next = parents[cur].get(i);
                if(v[next]) continue;

                list.add(next);
                v[next] = true;
                q.offer(next);
            }
        }
        return list;
    }
}
