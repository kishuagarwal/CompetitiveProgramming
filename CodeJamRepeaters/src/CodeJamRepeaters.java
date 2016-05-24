import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CodeJamRepeaters {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter writer = new PrintWriter(new File("output.txt"));
		int t = in.nextInt();
		int n;
		String input[] = new String[100];
		char character[][] = new char[100][100];  
		int lengths[][] = new int[100][101];
		for(int i = 1; i <= t; i++ )
		{
			n  =in.nextInt(); 
			for(int j = 0; j < n;j++)
				input[j] = in.next();
			writer.print("Case #"+i+": ");
			int ans = 0;
			for(int j = 0; j < n; j++)
			{
				int pos = 0;
				character[j][0] = input[j].charAt(0);
				lengths[j][0] = 1;
				for(int k = 1; k < input[j].length(); k++)
				{
					if(input[j].charAt(k) == character[j][pos])
					{
						lengths[j][pos]++;
					}
					else
					{
						pos++;
						character[j][pos]= input[j].charAt(k);
						lengths[j][pos] = 1;
						
					}
				}
				lengths[j][100] = pos;
			}
			boolean possible = true;
			for(int k = 1; k < n;k++)
			{
				if(lengths[k][100] != lengths[k-1][100])
				{
					possible = false;
					break;
				}
			}
			
			char currentCharacter;
			if(possible)
			for(int k = 0; k <= lengths[0][100]; k++)
			{
				currentCharacter = character[0][k];
							
				int total = lengths[0][k];
				for(int j = 1; j < n ;j++)
				{
					if(character[j][k] == currentCharacter)
					{
						total += lengths[j][k];
					}
					else
					{
						possible = false;
						break;
					}
				}
				
				if(!possible)
				{
					
					break;
				}
				else
				{
					total = total/n;
					for(int j = 0; j < n;j++)
					{
						ans += Math.abs(lengths[j][k]-total);
					}
				}
					
			}
			if(!possible)
				writer.println("Fegla Won");
			else
				writer.println(ans);
			
		}
		writer.close();
		in.close();
	
	}

}
