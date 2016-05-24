import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;


public class Polygons {

	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		int n,m;
		long firstx,firsty,tempx,tempy,prevx,prevy;
		double sumx,sumy;
		StringTokenizer tokenizer;
		Polygon[] polygons;
		int ans[];
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(reader.readLine());
			polygons = new Polygon[n];
			ans = new int[n];
			for (int k = 0; k < n; k++) {
				m = Integer.parseInt(reader.readLine());
				tokenizer = new StringTokenizer(reader.readLine());
				firstx = Long.parseLong(tokenizer.nextToken());
				firsty = Long.parseLong(tokenizer.nextToken());
				sumx = 0;
				sumy = 0;
				prevx = firstx;
				prevy = firsty;
				for (int j = 0; j < m-1; j++) {
					tempx = Long.parseLong(tokenizer.nextToken());
					tempy = Long.parseLong(tokenizer.nextToken());
					//perimeter += (tempx - prevx) * (tempx - prevx) + (tempy - prevy) * (tempy - prevy);
					sumx += tempx * prevy;
					sumy += tempy * prevx;
					prevx = tempx;
					prevy = tempy;
				}
				//perimeter += (firstx- prevx) * (firstx - prevx) + (firsty - prevy) * (firsty - prevy);
				sumx += firstx * prevy;
				sumy += firsty * prevx;
				Polygon p = new Polygon();
				p.num = k;
				p.permiter = Math.abs(sumy - sumx);
				polygons[k] = p;
				}
				Arrays.sort(polygons);
				for (int j = 0; j < polygons.length; j++) {
					ans[polygons[j].num] = j;
				}
				for (int j = 0; j < polygons.length; j++) {
					System.out.print(ans[j] + " ");
					
				}
				System.out.println();
		}
		reader.close();
	}

	static class Polygon implements Comparable<Polygon> {
		int num;
		double permiter;
		@Override
		public int compareTo(Polygon that) {
			if (this.permiter < that.permiter) return -1;
			return 1;
		}
		
	}
}
