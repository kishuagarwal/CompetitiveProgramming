import java.util.Scanner;


public class ChefAndTheDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner in = new Scanner(System.in);
	int n = in.nextInt(),m = in.nextInt();
	String input = in.next();
	//System.out.println(input);
	int count[] = new int[10];
	int ans[] = new int[n];
	int x,j,a,b,s;
	for(int i = 0; i < n; i++)
	{
		a = 0;
		b = 0;
		s = input.charAt(i) - '0';
		for(j = 0; j <= s; j++)
			if(count[j] != 0)
				a += count[j]*(s -j); 
		for(j = s +1; j < 10; j++)
			if(count[j] != 0)
			b += count[j]*(j - s); 
		ans[i] = b +a;
		count[s]++;
	}
	
	for(int i = 1; i <= m; i++)
	{
		x = in.nextInt();
		System.out.println(ans[x-1]);
	}
	}

}
