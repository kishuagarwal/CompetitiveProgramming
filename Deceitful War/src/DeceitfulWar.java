import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class DeceitfulWar {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new File("input.in"));
		PrintWriter write = new PrintWriter(new File("output.out")); 
		int t = in.nextInt();
		int n,j,k,optimalWar,optimalDeceitfulWar,lastBiggest;
		double first[] = new double[1000]; 
		double second[] = new double[1000];
		boolean taken[] = new boolean[1000]; 
		for(int i = 1; i <= t; i++){
			n = in.nextInt();
			for(j = 0; j < n;j++){
				first[j] = in.nextDouble();
			}
			for(j = n; j < 10; j++)
				first[j] = 2.0;
			for(j = 0; j < n;j++){
				second[j] = in.nextDouble();
			}
			for(j = n; j < 10; j++)
				second[j] = 2.0;
			Arrays.sort(first);
			Arrays.sort(second);
			Arrays.fill(taken, false);
			optimalWar = 0;
			optimalDeceitfulWar = 0;
			lastBiggest = n-1; 
			for(j = n-1 ; j >= 0; j--){
				if(second[j] < first[lastBiggest])
					{
					optimalDeceitfulWar++;
					lastBiggest--;
					}
			}
			for(j = 0 ; j <n; j++){
				for(k = 0; k < n;k++){
					if(!taken[k] && second[k] > first[j]){
						taken[k] = true;
						break;
					}
				}
				if(k == n){
					optimalWar++; 
				}
			}
			write.println("Case #"+i+": "+optimalDeceitfulWar+" "+optimalWar);
		}
		in.close();
		write.close();
	}

}
