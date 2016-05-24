import java.util.Scanner;


public class StoneGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n;
		boolean losingPositions[] = new boolean[10001];
		losingPositions[2] = true;
		losingPositions[5] = true;
		for(int i = 6; i <= 10000; i++){
			if(!losingPositions[i-1] && !losingPositions[i-4])
				losingPositions[i] = true;
		}
		
		
		for(int i= 1; i<= t;i++){
			n =in.nextInt();
			if(losingPositions[n] ) //losing postion
			{
				System.out.println("No");
			}
			else
				System.out.println("Yes");
		}
		in.close();
	}

}
