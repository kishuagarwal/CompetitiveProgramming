import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class EugeneFunction {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		long a, d, l, r;
		long ans;
		for (int i = 0; i < t; i++) {
			String[] line = reader.readLine().split(" ");
			a = Long.parseLong(line[0]);
			d = Long.parseLong(line[1]);
			l = Long.parseLong(line[2]);
			r = Long.parseLong(line[3]);
		
			long nineSum = 0;
			long currentNum = a + (l - 1) * d;
			for (long j = 1; j <= 9; j++) {
				nineSum += digitSum(currentNum);
				currentNum += d;
			}
			ans = 0;
			long divide = (r - l + 1) / 9;
			ans += nineSum * divide;
			currentNum = a + (((l + divide * 9-1) % 9)) * d;
			for (int j = 0; j < (r - l + 1) % 9; j++) {
				ans += digitSum(currentNum);
				currentNum += d;
			}
			System.out.println(ans);

		}

		reader.close();
	}

	public static long digitSum(long num) {
		while (num > 9) {
			long digitSum = 0;
			while (num > 0) {
				digitSum += num % 10;
				num /= 10;
			}
			num = digitSum;
		}

		return num;
	}
	
}
