import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CodeJamLotteryGame {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter writer = new PrintWriter(new File("output.txt"));
	//	Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long a,b,k;
		for(int i = 1; i <= t; i++)
		{
			a = in.nextLong();
			b = in.nextLong();
			k = in.nextLong();
			int ans = 0;
//			for(int s = 0; s < a; s++)
//			{
//				for(int r = 0 ; r < b ;r++)
//				{
//					if((s & r) < k)
//						ans++;
//				}
//			}
			
			
			
			writer.println("Case #"+i+": "+ans);
		}
		writer.close();
		in.close();
	}

}
