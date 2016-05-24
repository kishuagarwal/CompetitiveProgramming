import java.util.Scanner;

public class CodeChefStone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();
		long array[] = new long[n];

		// take the input
		for (int i = 0; i < n; i++)
			array[i] = in.nextLong();

		// find the maximum position
		int maxPos = 0;
		for (int i = 1; i < n; i++)
			if (array[i] > array[maxPos])
				maxPos = i;

		// k > 0 do atleast once
		if (k > 0) {
			long temp = array[maxPos];
			for (int i = 0; i < n; i++) {
				array[i] = temp - array[i];
			}
			k--; //decrease k by one
		}
		
		
		
		if (k % 2 == 1) {   //we have to do one more time
			
			maxPos = 0;
			for (int i = 1; i < n; i++) {
				if (array[i] > array[maxPos])
					maxPos = i;
			}
			
			long temp = array[maxPos];
			for (int i = 0; i < n; i++)
				array[i] = temp - array[i];
		}
		for (int i = 0; i < n; i++)

			System.out.print(array[i] + " ");
		in.close();
	}

}
