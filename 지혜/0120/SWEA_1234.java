package algorithm_study;
import java.io.*;
import java.util.*;

public class SWEA_1234 {
	static int size;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t=1; t<=10; t++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int i =0; i<size; i++) {
				int num = input.charAt(i)-'0';
				list.add(num);
			}
			boolean check;
			do {
				check = false;
				
				for(int i=0; i<list.size()-1; i++) {
					if(list.get(i).equals(list.get(i+1))) {
						list.remove(i+1);
						list.remove(i);
						check =true;
						break;
						
					}
				}
				
			}while(check);
//			while(true) {
//				boolean check=false;
//				ArrayList<Integer> temp = new ArrayList<>(list);
//				int before = temp.get(0);
//				for(int i =1; i<temp.size(); i++) {
//					
//					if(before.equals(temp.get(i)) {
//						list.remove(Integer.valueOf(before));
//						list.remove(Integer.valueOf(cur));
//						check = true;
//						if(i != temp.size()-1) {
//							before = temp.get(i+1);
//							i++;
//						}
//						
//					}else {
//						before = cur;
//					}
//				}
//				if(!check) break;
//			
//			}
//			
			for(int val : list) {
				sb.append(val);
			}
			System.out.println("#"+t+" "+sb.toString());
		}
	
	}
}
