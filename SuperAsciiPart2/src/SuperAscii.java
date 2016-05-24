import java.io.CharConversionException;
import java.util.Scanner;


public class SuperAscii {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String input;
		int freq[];
		int totalCost;
		int charactersInSpare;
		for (int i = 0; i < t; i++) {
			input = in.next();
			charactersInSpare = 0;
			totalCost= 0;
			freq = new int[27];
			for (int j = 0; j < input.length(); j++) {
				freq[input.charAt(j)-'a'+1]++;
			}
			for (int j = 1; j < 27; j++) {
				if(freq[j] == 0) continue;
				if(freq[j] == j) continue;
				int diff = freq[j] - j;
				if(diff > 0)   //more characters to left
				{
					charactersInSpare += diff;
					freq[j] -= diff;
				}
				
			}
			
			for (int j = 1; j < 27; j++) {
				if(freq[j] == 0) continue;
				if(freq[j] == j) continue;
				int diff = j - freq[j]; // characters needed more
				if(charactersInSpare >= diff){
					totalCost += diff;
					charactersInSpare -= diff;
					freq[j] += diff;
				}
				else{ // not enough characters
					int left = diff - charactersInSpare;
					totalCost += left*2;
					totalCost += charactersInSpare;
					charactersInSpare = 0;
				}
			}
			
			if(charactersInSpare > 0){  //some left
				totalCost += charactersInSpare*3;
			}
			System.out.println(totalCost);
			
		}
		in.close();
	}

}
