import java.util.Scanner;
import java.util.StringTokenizer;


public class CookingMachine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long a,b,first,second,count;
		for (int i = 1; i <= t; i++) {
			count = 0;
			a = in.nextLong();
			b = in.nextLong();
			first = Long.highestOneBit(a);
			second = a & (~first) ;
			second = Long.highestOneBit(second);
			while (second != 0) {
				count++;
				second >>= 1;
			}
			a >>= count;
			while (a < b) {
				count++;
				a <<= 1;
			}
			while (a > b) {
				count++;
				a >>= 1;
			}
			System.out.println(count);
		}
		in.close();
	}

}
