import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CodeJamBoredSalesmanProblem {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
	static int directions[][];
	static int[] zips;
	static boolean[] visited;
	static PrintWriter writer;
	static int n,m;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new File("input.txt"));
		writer = new PrintWriter(new File("output.txt"));
	//	Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i  = 1; i <= t; i++)
		{
			n = in.nextInt();
			m = in.nextInt();
			zips = new int[n+1];
			visited = new boolean[n+1];
			for(int j = 1; j <= n;j++ )
				zips[j] = in.nextInt();
			directions = new int[n+1][n+1]; 
			for(int j = 0; j < m ; j++)
			{
				int x = in.nextInt();
				int y = in.nextInt();
				directions[x][y] = 1; 
			}
			writer.print("Case #"+i+": ");
			dfs(1);
			writer.println();
			
		}
		writer.close();
		in.close();
	}
	
	public static void dfs(int n)
	{
		visited[n] = true;
		writer.print(zips[n]);
		for(int i = 1; i <= n ; i++)
		{
			if(directions[n][i] == 1 && !visited[i])
			{
				dfs(i);
			}
		}
	}

}
