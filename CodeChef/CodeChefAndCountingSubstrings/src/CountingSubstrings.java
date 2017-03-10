import java.util.Scanner;

public class CountingSubstrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t, onesCount, n;
		String input;
		long ans;

		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			n = in.nextInt();
			input = in.next();
			onesCount = 0;
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '1')
					onesCount++;
			}
			ans = ((long) (onesCount - 1) * (onesCount)) >> 1;
			ans += onesCount;
			System.out.println(ans);
		}
		in.close();
	}

}
