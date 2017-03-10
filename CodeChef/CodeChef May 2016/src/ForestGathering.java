import java.math.BigInteger;
import java.util.Scanner;

public class ForestGathering {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long w = in.nextLong();
		long l = in.nextLong();
		long totalRate = 0;
		int h[] = new int[n];
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = in.nextInt();
			r[i] = in.nextInt();
			totalRate += r[i]; // in one month, how much grows
		}
		long start = 0, end = (long) 10e18;
		long mid = 0;
		BigInteger cwood = BigInteger.ZERO, temp = BigInteger.ZERO, max;
		BigInteger lb = BigInteger.valueOf(l), wb = BigInteger.valueOf(w);
		while (start <= end) {
			mid = start + ((end - start) >> 1);
			// calculate amount of cuttable wood at this point
			cwood = BigInteger.ZERO;
			for (int i = 0; i < n; i++) {
				max = BigInteger.valueOf(mid).multiply(BigInteger.valueOf(r[i]));
				
				
				//System.out.println(max);
				temp = max.add(BigInteger.valueOf(h[i]));
				if (temp.compareTo(lb) >= 0) {
					cwood = cwood.add(temp);
				}
				
			}
			//System.out.println(start + "  " + end + "  " + mid + "  " + cwood);
			//if (cwood.compareTo(wb) == 0) {
			//	break;
			//}
			if (wb.compareTo(cwood) == 1) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		if (cwood.compareTo(wb) == -1)
			mid++;
		System.out.println(mid);
		in.close();

	}

}
