package bitmanipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		BigInteger num;
		for (int i = 0; i < t; i++) {
			num = in.nextBigInteger();
			if (num.equals(BigInteger.ONE))
			{
				System.out.println("Richard");
				continue;
			}
			num = num.shiftRight(1);
			int rightMostOne = num.getLowestSetBit();
			System.out.println(rightMostOne);
			if ((num.bitCount() + rightMostOne) % 2 == 0)
				System.out.println("Richard");
			else
				System.out.println("Louise");
		}
		in.close();
	}

}
