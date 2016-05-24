import java.util.Scanner;


public class Hedgemony {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		double heights[] = new double[1000];
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			for (int j = 0; j < n; j++) 
				heights[j] = in.nextInt();
			double ans = 0.0;
			for (int j = 1; j < n-1; j++) {
				double target = (heights[j-1] + heights[j+1]) /2;
				heights[j] = Math.min(heights[j], target);
			}
			System.out.println("Case #" + i + ": " + heights[n-2]);
			
		}
		in.close();
		
	}

}
