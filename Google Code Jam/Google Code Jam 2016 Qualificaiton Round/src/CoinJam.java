import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinJam {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine()); 
		char c[] = new char[16];
		c[0] = '1';
		c[15] = '1';
		for (int i = 1; i <= 14; i++) {
			c[i] = '0';
		}
		long start = ( 1 << 15) + 1;
		long end = 0xFFFF;
		for (long i = start ; i <= end; i += 1) {
			
		}
		reader.close();

	}
	
	public static long base(char c[] , int base) {
		long ans = 0;
		long pow = 1;
		for (int j = c.length - 1;  j >= 0 ; j--) {
			if (c[j] == '1') ans += pow;
			pow *= base;
		}
		return ans;
	}

}
