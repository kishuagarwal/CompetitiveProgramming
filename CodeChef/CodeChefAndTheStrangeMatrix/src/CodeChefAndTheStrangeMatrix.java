import java.util.Arrays;
import java.util.Scanner;


public class CodeChefAndTheStrangeMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int p = in.nextInt();
		long array[] = new long[p+1];
		int repeats[] = new int[p+1]; 
		int columnNumbers[] = new int[p+1];
		int x,y;
		for(int i = 1; i <= p; i++)
		{
			x = in.nextInt();
			y = in.nextInt();
			array[i] = ((long)(x-1))*m+y-1;
		}
		Arrays.sort(array);
		//Arrays.toString(array);
		long lastElement = array[1];
		int lastPos = 1;
		repeats[1] = 1;
		columnNumbers[1] = (int) (array[1] %m);
		//merging of the common elements into one
		for(int i = 2; i <= p;i++)
		{
			if(lastElement == array[i])  //same element as last element
			{
				repeats[lastPos]++;
			}
			else{  // number is a new number
				lastElement = array[i];
				lastPos++; 
				columnNumbers[lastPos] = (int) (lastElement %m); 
				array[lastPos] = array[i];
				repeats[lastPos]=1;
			}
			
		}
		int pos = 1;
		for(int i =1; i <=n ;i++)
		{
			int j,starting = pos ;
			//finding where the current row is located
			for( j = pos; j <=lastPos && array[j] < (long)i*m; j++);
			//pos stores the out of the row number index position
			pos = j;
			boolean notPossible = false;
			for(int k = starting; k < pos; k++){
				if(repeats[k] == 1) //no problem in single change
					continue;
				//check for adjacent
				if(columnNumbers[k] == (m-1)) //no problem in last element in single row 
					continue;
				int nextElementRepeat = 0;
				if(k != (pos-1))
				{
					if(columnNumbers[k] +1 == columnNumbers[k+1])
					{
						nextElementRepeat = repeats[k+1];
					}
				}
				if(repeats[k] > nextElementRepeat+1)
				{
					notPossible = true;
					break;
						
				}
				
			}
			int cost;
			if(notPossible)
			{
				cost = -1;
			}
			else
			{
				int lower = 1;
				int upper = m;
				if(pos - starting > 0) //atleast single change
				{
				if(columnNumbers[starting] == 0){
					lower = lower + repeats[starting];
				}
				if(columnNumbers[pos-1] == (m-1))
					upper = upper + repeats[pos-1];
				}
				cost = upper - lower;
			}
			System.out.println(cost);
		}
		in.close();
	}

}
