package bitmanipulation;

import java.util.Scanner;

public class SansaAndXor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n;
		long nums[] = new long[100003];
		for (int i = 0; i < t; i++) {
			n = in.nextInt();
			for (int j = 0; j < n; j++) {
				nums[j] = in.nextLong();
			}
			long ans = 0;
			long count = 0;
			long left,right;
			for (int j = 0; j < n; j++) {
				//Find the odd number of occurences
				left = j;
				right = n-1-j;
				count = left + right +  left * right + 1;
				if (count % 2 == 1)
					ans ^= nums[j];
			}
			System.out.println(ans);
			
		}
		in.close();
	}

}
