import java.util.Arrays;
import java.util.Scanner;


public class SetDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n;
		long nums[];
		long mod = 1000000007,ans,power,powerSum,prev;
		for (int i = 1; i <= t; i++) {
			n = in.nextInt();
			nums = new long[n];
			for (int j = 0;j < n; j++) 
				nums[j] = in.nextLong();
			Arrays.sort(nums);
			ans = 0;
			power = 1;
			powerSum = 1;
			prev = nums[0];
			for (int j = 1; j < n;j++) {
				ans = (ans +  powerSum * nums[j] - prev) % mod;
				power = (power * 2) % mod;
				powerSum = (powerSum + power) % mod;
				prev = (prev * 2 + nums[j]) % mod;
			}
			System.out.println(ans);
		}
		in.close();
		
	}

}
