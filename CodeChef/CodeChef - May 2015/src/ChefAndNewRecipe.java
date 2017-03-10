import java.util.Scanner;


public class ChefAndNewRecipe {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n,temp;
		int ans,min;
		for (int i = 1; i <= t; i++) {
			n = in.nextInt();
			ans = 0;
			min = in.nextInt();
			for (int j = 2; j <= n;j++) {
				temp = in.nextInt();
				if (temp < min) {
					ans += min;
					min = temp;
				}
				else 
					ans += temp;
				
			}
			if (n == 1) ans = 2;
			else ans += 2;
			if (min < 2)
				System.out.println(-1);
			else
				System.out.println(ans);
		}
		in.close();
	}

}
