import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class ZombieWar {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int testCases,t,k,n,p,d;
		testCases = in.nextInt();
		int zombiesEnergy[] = new int[50];
		boolean canAdvance;
		for(int i= 1; i <= testCases;i++){
			n = in.nextInt();
			t = in.nextInt();
			for(int j = 0; j <  n;j++)
				zombiesEnergy[j] = in.nextInt();
			p = in.nextInt();
			d = in.nextInt();
			Arrays.sort(zombiesEnergy, 0, n);
			canAdvance = false;
			for(int s = 1; s <= t;s++){
				  for(int pos = n-1; pos>=0;pos++){
					if(zombiesEnergy[pos] == -1)
						continue;
					if(zombiesEnergy[pos]<=p ){
						p += (p-zombiesEnergy[pos]);
						zombiesEnergy[pos] = -1;
						break;
					}
				}
				if(p >= d){
					canAdvance = true;
				}
			}
			
			if(canAdvance)
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
		in.close();
	}

}
