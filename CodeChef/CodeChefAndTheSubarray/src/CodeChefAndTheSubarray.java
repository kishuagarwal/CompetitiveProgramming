import java.util.Scanner;

public class CodeChefAndTheSubarray{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t,n = in.nextInt();
		int max = 0;
		int start = -1,end = -1;
		int distance; 
		for(int i = 0 ; i < n;i++)
		{
			t = in.nextInt();
			
			if(t == 0)
			{
				if(start != -1)
				{
				distance = end - start +1;
				System.out.println(distance);
				if(distance > max)
					max = distance;
				}
				start = -1;
				end = -1;
			}
			else
			{
				if(start == -1)
					{
						start++;
						end++;
					}
					else
						end++;
			}
		}
		if(start != -1)
		{
			distance = end - start +1;
			if(distance > max)
				max =distance;
		}
		System.out.println(max);

	}
}