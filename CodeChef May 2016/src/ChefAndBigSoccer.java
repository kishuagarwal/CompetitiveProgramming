import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefAndBigSoccer {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		long mod = 1000000007;
		for (int i = 1; i <= t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			tokenizer = new StringTokenizer(reader.readLine());
			long ways1[] = new long[n];
			long ways2[] = new long[n];
			long waysCurrent[] = ways1, waysPrevious[] = null;
			boolean current1;
			int strength = Integer.parseInt(tokenizer.nextToken());
			if (s - strength > 0) {
				ways1[s - strength - 1]++;
			}
			if (s + strength <= n) {
				ways1[s + strength - 1]++;
			}
			current1 = true;
			for (int j = 1; j < m; j++) {
				
				strength = Integer.parseInt(tokenizer.nextToken());
				if (current1) {
					current1 = false;
					waysCurrent = ways2;
					waysPrevious = ways1;
				}
				else {
					current1 = true;
					waysCurrent = ways1;
					waysPrevious = ways2;
				}
				//System.out.println(Arrays.toString(waysPrevious));
				for (int k = 0; k < n; k++) {
					waysCurrent[k] = 0;
					if (k - strength >= 0) {
						waysCurrent[k] = waysPrevious[k - strength];
					}
					if (k + strength <= n - 1) {
						waysCurrent[k] += waysPrevious[k + strength];
					}
					if (waysCurrent[k] > mod)
						waysCurrent[k] = waysCurrent[k] % mod;
				}
			}
			for (int j = 0; j < n; j++) {
				System.out.print((waysCurrent[j] % mod) + " ");
			}
			System.out.println();
		}
		reader.close();

	}

}
