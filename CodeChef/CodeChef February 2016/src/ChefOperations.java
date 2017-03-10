import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefOperations {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i<= t;i++) {
			int n,x;
			
			long m;
			String input[] = reader.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			x = Integer.parseInt(input[1]);
			m = Long.parseLong(input[2]);
			input = reader.readLine().split(" ");
			long ans = 0,mod = 1000000007;
			for (int j = 0; j < x; j++ ) {
				ans += (Long.parseLong(input[j]) % mod) * ((m-j) % mod) * ((m-j+1) % mod) >> 1;
			    if (ans > mod) 
			    	ans = ans % mod;
			}
			System.out.println(ans);
		}
		reader.close();

	}

}
