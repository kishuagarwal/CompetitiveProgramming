import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Haircut {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(new File("out.out"));
		int t = in.nextInt(); 
		long n;
		int b;
		boolean same;
		for (int i = 1; i <= t; i++) {
			b = in.nextInt();
			n = in.nextLong();
			int bar[] = new int[b];
			double rate = 0;
			same = true;
			for (int j = 0; j < b; j++) {
				bar[j] = in.nextInt();
				rate += (double)1/bar[j];
				
			}
			int first = bar[0];
			for (int j = 1; j < b;j++) {
				if (first != bar[j])
				{
					same = false;
					break;
				}
			}
			rate = 1/rate;
			double time = rate * (n-1);
			double time2= rate * (n-2);
/*			if (same) {
				barber = (int) (n % b);
				if (barber == 0)
					barber = b;
			}
*/			System.out.println("Case #"+i+": "+barber(bar,time) + "  " + barber(bar,time2)) ;
			
		}
		in.close();
		writer.close();
	}
	
	private static int barber(int bar[], double time) {
		int barber = 1;
		double mindiff = time - ((int)(time / bar[0])) * bar[0] ;
		for (int j = 1; j < bar.length; j++) {
			double diff = time - ((int)(time / bar[j])) * bar[j] ;
			if (diff < mindiff) {
				mindiff = diff;
				barber = j+1;
			}
		}
		return barber;
	}

}
