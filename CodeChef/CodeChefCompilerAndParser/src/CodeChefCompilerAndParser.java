import java.util.Scanner;


public class CodeChefCompilerAndParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 1; i <= t; i++ )
		{
			int prefixLength = 0;
			int leftCount = 0;
			String s = in.next();
			for(int j = 0; j < s.length(); j++ )
			{
				if(s.charAt(j) == '<')
				{
					leftCount++;
				}else
					if(s.charAt(j) == '>')
					{
						
						leftCount--;
				}
				if(leftCount<0)
					break;
				if(leftCount == 0)
					prefixLength = j+1;
			}
			System.out.println(prefixLength);
		}
		in.close();
	}

}
