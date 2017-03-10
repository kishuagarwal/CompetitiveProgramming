import java.util.Scanner;


public class CodeChefCodeJumping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long d = in.nextLong();
		if( d % 3 == 0 || ((d % 3 == 1 ) && (((d / 3) & 1) == 0)))
			System.out.println("yes");
		else
			System.out.println("no");
		in.close();
	}
	

}
