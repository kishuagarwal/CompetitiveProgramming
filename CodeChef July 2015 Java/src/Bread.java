import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Bread {

	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		long n,k,curb,curd,count;
		while (t-- > 0) {
			tokenizer = new StringTokenizer(reader.readLine());
			n = Long.parseLong(tokenizer.nextToken());
			k = Long.parseLong(tokenizer.nextToken());
			curb = 0; //current opened packet of bread
			count = 0; //count of bread packets needed
			tokenizer = new StringTokenizer(reader.readLine());
			while (n-- > 0) {
				curd = Long.parseLong(tokenizer.nextToken());  //how many breads are required today
				curd -= curb; //if possible, eat from the already opened packet of bread
				count += Math.ceil((double)curd / k);		
				curb = k - (curd % k);
				if (curb > 0 ) curb--;
			}
			System.out.println(count);
		}
		reader.close();
	}

}
