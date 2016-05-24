import java.util.HashMap;
import java.util.Scanner;


public class CodeChefAndPasswordCracking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n;
		char p,c;
		char s[];
		for(int i = 1; i <= t; i++)
		{
			n = in.nextInt();
			HashMap<Character, Character> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				map.put(in.next().charAt(0), in.next().charAt(0));
			}
			s = in.next().toCharArray();
			boolean dotPresent = false;
			for (int j = 0; j < s.length;j++) {
				if(map.get(s[j]) != null)
				{
					s[j] = map.get(s[j]);
				}
				
				if(s[j] == '.')
					dotPresent  = true;
				
			}
			int start = 0,end = s.length-1;
			for (int j = 0; j < s.length; j++) {
				if(s[j] == '0')
					start++;
				else
					break;
				
			}
			if(dotPresent)
			for(int j = s.length-1; j>=0;j-- )
			{
				
				if(s[j] == '0')
					end--;
				else
					if(s[j] == '.')
					{
						end--;
						break;
					}
				else
					break;
			}
			if(start <= end)
			System.out.println(new String(s,start,end-start+1));
			else
				System.out.println(0);
			
			
			
		}
		in.close();
	}

}
