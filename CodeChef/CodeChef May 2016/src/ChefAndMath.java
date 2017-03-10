import java.util.Arrays;
import java.util.Scanner;

public class ChefAndMath {

	static long fib[] = new long[50];
	static int count = 1;
	static long dp[][] = new long[50][11];
	
	
	private static void preprocess() {
		dp[0][1] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		for (int i = 2; i <= count; i++) {
			dp[i][1] = 1;
			dp[i][2] = 1;
			//int first = fib[i-1];
			//int second = fib[i-2];
			for (int j = 3; j <= 10; j++) {
				dp[i][j] = dp[i-1][j-1] * dp[i-2][j-1];
			}
	//		System.out.println(Arrays.toString(dp[i]));
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		fib[0] = 1;
		fib[1] = 2;

		while ((fib[count] + fib[count - 1]) < 1000000000) {
			fib[count+1] = fib[count] + fib[count - 1];
			count++;

			//System.out.println(fib[count]);
		}
		preprocess();
		int q= in.nextInt();
		long mod = 1000000007;
		for (int i = 1; i <= q; i++) {
			long x = in.nextLong();
			int k = in.nextInt();
			int j = 0;
			long ans = 0;
			for (; j < fib.length; j++) {
				if (fib[j] == x) {
					ans = dp[j][k];
					break;
				}
			}
			System.out.println(ans);
		//	System.out.println(ways(x,k));
		}
		in.close();

	}

}
