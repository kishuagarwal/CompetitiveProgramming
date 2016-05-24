import java.util.Scanner;


public class ChefAndMemoryLimit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long currentAllocation,ans;
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			ans = in.nextLong();
			currentAllocation = ans;
			for (int j = 1; j < n; j++) {
				long temp = in.nextLong();
				if (temp > currentAllocation) { 
					ans += temp - currentAllocation;
					currentAllocation = temp;
				}
				else
					currentAllocation = temp; 
			}
			System.out.println(ans);
		}
		in.close();
	}

}
