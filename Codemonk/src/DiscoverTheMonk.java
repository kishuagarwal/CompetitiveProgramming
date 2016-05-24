import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class DiscoverTheMonk {

	public static void main1(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n,q;
		String input[] = reader.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		q = Integer.parseInt(input[1]);
		
		int num[] = new int[n];
		input = reader.readLine().split(" ");
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(num);
		for (int i = 0; i < q ; i++) {
			int s = Integer.parseInt(reader.readLine());
			int l = 0;
			int h = n-1;
			while ( l <= h) {
				int mid = (l + h) >> 1;
				if (num[mid] == s) {
					break;
				}
				if (num[mid] > s) 
					h = mid - 1;
				else
					l = mid + 1;
			}
			if (l <= h) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		reader.close();

	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n,q;
		String input[] = reader.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		q = Integer.parseInt(input[1]);
		
		HashSet<Integer> nums = new HashSet<Integer>();
		input = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(input[i]));
		}
		
		for (int i = 0; i < q ; i++) {
			int s = Integer.parseInt(reader.readLine());
			
			if (nums.contains((Integer)s)) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		reader.close();

	}
	
	
	

}
