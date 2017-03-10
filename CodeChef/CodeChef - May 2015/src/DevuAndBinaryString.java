import java.util.Scanner;

public class DevuAndBinaryString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n,k,count,ans;
		char input[];
		
		for (int i = 1; i <= t; i++) {
			n = in.nextInt();
			k = in.nextInt();
			input = in.next().toCharArray();
			count = 1;
			ans = 0;
			for (int j = 1; j < n; j++) {
				if (input[j] == input[j-1]) {
					count++;
				}
				else count = 1;
				if (count == k+1) {
					ans++;
					if (j != n-1) {
						if (input[j] == input[j+1]) {
							input[j] = (input[j] == '0') ? '1' : '0';
						}
						else {
							if (k == 1)
								{
									if (j == 1)
										input[j-1] = (input[j-1] == '0') ? '1' : '0';
									else
										input[j] = (input[j] == '0') ? '1' : '0';
								}
							else
								input[j-1] = (input[j-1] == '0') ? '1' : '0';
						}
					}
					else {
						input[j] = (input[j] == '0') ? '1' : '0';
					}
					count = 1;
				}
				
			}
			System.out.println(ans+"\n"+new String(input));
 		}
		in.close();
	}

}
