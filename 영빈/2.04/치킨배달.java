import java.util.Scanner;

public class SSAFY {
	static int[][] map;
	static int N;
	static int M;
	static int CD = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs();
		System.out.println(CD);
		
		
		
		

	}
	public static void dfs() {
		if(chickens() == M)
		{
			CD = Math.min(totalCD(), CD);
		}
		
		
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				if(map[i][j] == 2)
				{
					map[i][j] = 0;
					dfs();
					map[i][j] = 2;
				}
			}
		}
		
	}
	
	public static int chickens() {
		int num = 0;
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				if(map[i][j] == 2)
				{
					num++;
				}
			}
		}
		return num;
	}
	
	
	
	public static int totalCD() {
		int totalChickenDistance = 0;
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				if(map[i][j] == 1)
				{
					totalChickenDistance += chickend(i, j);
				}
			}
		}
		return totalChickenDistance;
	}
	
	public static int distance(int x, int y, int i, int j) {
		
		return (Math.abs(x - i) + Math.abs(y - j));
		
		
	}
	public static int chickend(int x, int y)
	{
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				if(map[i][j] == 2)
				{
					min = Math.min(min, distance(x, y, i, j));
				}
			}
		}
		return min;
	}
	
	
}
