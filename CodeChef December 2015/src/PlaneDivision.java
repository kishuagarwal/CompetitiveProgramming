import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PlaneDivision {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Line> lines = new HashSet<Line>();
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(reader.readLine());
			lines.clear();
			for (int j = 0; j < n; j++) {
				String input[] = reader.readLine().split(" ");
				long a = Long.parseLong(input[0]);
				long b = Long.parseLong(input[1]);
				long c = Long.parseLong(input[2]);
				lines.add(new Line(a, b, c));

			}
			Line[] points = lines.toArray(new Line[0]);
			//System.out.println(lines);
			Arrays.sort(points);
			int max = 0, count = 1;
			int index = 1;
			while (index < points.length) {
				if (points[index].a == points[index - 1].a && points[index].b == points[index - 1].b) {
					count++;
				} else {
					if (count > max) {
						max = count;

					}
					count = 1;
				}
				index++;

			}
			if (count > max) max = count;
			System.out.println(max);
		}
		reader.close();
	}
	
	static class Line implements Comparable<Line>{
		long a,b,c;
		double slope;
		
		Line (long a,long b, long c) {
			this.a = a;
			this.b = b;
			this.c = c;
			denomize();
			slope = -a/(double)b;
		}
		
		void denomize() {
			long first = gcd(a,b);
			long second = gcd(first,c);
			a /= second;
			b /= second;
			c /= second;
		}
		
		long gcd(long a, long b) {
			long t;
			while (b != 0 ) {
				t = b;
				b = a % b;
				a = t;
			}
			return a;
		}

	
		@Override
		public int compareTo(Line o) {
			if (this.a == o.a && this.b == o.b) return 0;
			if (this.slope < o.slope) return -1;
			return 1;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (a ^ (a >>> 32));
			result = prime * result + (int) (b ^ (b >>> 32));
			result = prime * result + (int) (c ^ (c >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Line other = (Line) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}

		@Override
		public String toString() {
		return slope + "";
		}
		
	}
	
	

}
