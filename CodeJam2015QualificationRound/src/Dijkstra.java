import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Dijkstra {

	static int table[][] = {{1,2,3,4},
			 {2,-1,4,-3},
			 {3,-4,-1,2},
			 {4,3,-2,-1}};
	public static void main(String[] args)throws IOException {
		Scanner in =  new Scanner(new File("in.in"));
		PrintWriter writer = new PrintWriter("out.out");
		int t= in.nextInt();
		int toSearch;
		for (int i = 1; i <= t; i++) {
			int len,x;
			len = in.nextInt();
			x = in.nextInt();
			char l[] = in.next().toCharArray();
			int result = 1;
			toSearch = 2;
			for (int k = 0; k <= len; k++) {
				if (k == len){
					x--;
					k = -1;
					if (x == 0)
						break;
					continue;
				}
				int c = (l[k] == '1')  ? 1 : (l[k] -'h') + 1;
				result = multiply(result, c);
				//System.out.println(result);
				if (toSearch == 4)
					continue;
				if (result == toSearch) {
					toSearch++;
					result = 1;
				}
				
			}
			writer.print("Case #"+i+": ");
			if (toSearch == 4 && result == 4) {
				writer.println("YES");
				
			}
			else
				writer.println("NO");
				
		}
		in.close();
		writer.close();
	}
	
	private static  int multiply(int a,  int b) {
		int temp = table[Math.abs(a) -1][b-1];
		if (a * temp < 0) {
			a = -Math.abs(temp);
		}
		else a = Math.abs(temp);
		return a;
	}

}
