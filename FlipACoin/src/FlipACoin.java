
public class FlipACoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int trials = 10000;
		int numberOfTrials = 100;
		int headCount = 0;
		double avg;
		int total = 0;
		for(int j = 1; j <= trials; j++)
		{
			headCount = 0;
		for(int i = 1; i <= numberOfTrials; i++)
		{
			double outcome =  Math.random();
			if(outcome > 0.50)
				headCount++; 
		}
		System.out.println("Head came "+headCount+" times.");
		total += headCount;
		}
		System.out.println("Average came "+(double)total/trials);
		
	}

}
