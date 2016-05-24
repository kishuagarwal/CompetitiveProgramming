import java.util.Scanner;


public class ShortestPathInBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long x,y;
		long ans;
		for(int i = 1; i <= n; i++){
		x = in.nextLong();
		y = in.nextLong();
		ans = 0;
		while(x != y)
		{
			ans++;
			if(x > y){
				x = x >> 1;
				
			}
			else
				y = y >> 1;
		}
		System.out.println(ans);
		}
	}

}
