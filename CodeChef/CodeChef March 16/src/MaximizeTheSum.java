import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MaximizeTheSum {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n;
			long k;
			String input[] = reader.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			input = reader.readLine().split(" ");
		//	String input2[] = reader.readLine().split(" ");
		//	PriorityQueue<Pair> pairs = new PriorityQueue<>();
			/*for (int j = 0; j < n ; j++) {
				Pair p = new Pair();
				p.a = Integer.parseInt(input[j]);
				p.b = Integer.parseInt(input2[j]);
				pairs.add(p);
			}*/
			int a[] = new int[n];
			int b[] = new int[n];
			for (int j = 0 ; j < n; j++) {
				a[j] = Integer.parseInt(input[j]);
			}
			input = reader.readLine().split(" ");
			b[0] = Integer.parseInt(input[0]);
			int max = Math.abs(b[0]);
			int pos = 0;
			for (int j = 1 ; j < n; j++) {
				b[j] = Integer.parseInt(input[j]);
				if (Math.abs(b[j]) > max) {
					max = Math.abs(b[j]);
					pos = j;
				}
			}
			
			long sum = 0;
			
			for (int j = 0; j < n ;j++) {
				if (j == pos) {
					/*if (a[j]* b[j] > 0) {
						sum +=( Math.abs(a[j]) + k )* Math.abs(b[j]);
					}
					else {
						if (a[j] < 0) {
							sum += (-a[j] + k) * b[j];
						}
						else
							sum += (a[j]  - k) * b[j];
					}*/
					if (b[j] > 0)
						sum += (a[j] + k) * b[j];
					else
						sum += (a[j] - k) * b[j];
				}
				else {
					sum += (long)a[j] * b[j];
				}
			}
			System.out.println(sum);
		
			
		}
		reader.close();

	}
	
	/*static class Pair implements Comparable<Pair> {
		int a,b;

		@Override
		public int compareTo(Pair that) {
			return Math.abs(this.b) - Math.abs(that.b);
		}
	}*/

}
