import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevengeOfThePancakes {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= t; i++) {
			char c[] = reader.readLine().toCharArray();
			int dp[][] = new int[2][c.length];
			if (c[0] == '+') {
				dp[0][0] = 0;
				dp[1][0] = 1;
			}
			else {
				dp[0][0] = 1;
				dp[1][0] = 0;
			}
			for (int j = 1; j < c.length; j++) {
				if (c[j] == '+') {
					dp[0][j] = dp[0][j-1];
					dp[1][j] = dp[0][j-1] + 1;
				}
				else {
					dp[0][j] = dp[1][j-1] + 1;
					dp[1][j] = dp[1][j-1];
				}
			}
			System.out.println("Case #" + i + ": " + Math.min(dp[0][c.length-1], dp[1][c.length-1] + 1));
		}
		reader.close();
	}

}
