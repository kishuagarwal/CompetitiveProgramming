import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpWatsonEscape {

	static long mod = 1000000007l;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
	
		for (int i = 1; i <= t; i++) {
			String input[] = reader.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			System.out.println((k * pow(k-1, n - 1)) % mod);
			
		}
		reader.close();

	}
	
	public static long pow(long a, long b) {
		long ans = 1;
		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		ans = pow(a, b >> 1);
		if (b % 2 == 1)
			ans = (((a * ans) % mod ) * ans) % mod;
		else
			ans = (ans * ans) % mod;
		return ans;
			
	}

}
