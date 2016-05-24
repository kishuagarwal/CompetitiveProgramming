import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CommonSchedule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean matrix[][] = new boolean[5000][1440];
		int input = in.nextInt();
		String first,last;
		int best,worst;
		StringTokenizer tokens;
		for (int i = 0; i < n; i++) {
			Arrays.fill(matrix[i], true);
		}
		while(input != -1){
			first = in.next();
			last = in.next();
			tokens = new StringTokenizer(first,":");
			int firstPart = Integer.parseInt(tokens.nextToken());
		    int secondPart = Integer.parseInt(tokens.nextToken());
		    int startMinute = firstPart*60+secondPart;
		    
		    tokens = new StringTokenizer(last,":");
		    firstPart = Integer.parseInt(tokens.nextToken());
		     secondPart = Integer.parseInt(tokens.nextToken());
		    int endMinute = firstPart*60+secondPart;
		    
		    
		    for (int i = startMinute; i < endMinute; i++) {
				matrix[input-1][i] = false;
			}
		    input = in.nextInt();
		}
		worst = Integer.MAX_VALUE;
		best = 0;
		int beststart = 0,bestend = 0;
		int worststart = 0,worstend = 0;
		for (int i = 0; i < n; i++) {
			int localbest = 0;
			int localbeststart = 0,localbestend = 0;
			int start = -1,end= 0;
			for (int j = 0; j < 1440; j++) {
				if(start == -1 && matrix[i][j]){
					start = j;
					end = j;
				}
				if(start != -1 && matrix[i][j] ) end++;
				if(start != -1 && !matrix[i][j])
				{
					int temp = end - start+1;
					if(temp > localbest){
						localbest = temp;
						localbeststart = start;
						localbestend = end;
						
					}
					start = -1;
					
				}
			}
			if(localbest > best){
				best = localbest;
				beststart = localbeststart;
				bestend = localbestend;
			}
			if(localbest < worst){
				worst = localbest;
				worststart = localbeststart;
				worstend = localbestend;
			}
		}
		
		boolean common[] = new boolean[1440];
		Arrays.fill(common, true);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 1440; j++) {
				if(!matrix[i][j] ) {
					common[j] = false;
				}
			}
		}
		int start = -1,end = 0;
		int localbest = 0,localstart = 0,localend = 0;
		for (int j = 0; j < 1440; j++) {
			if(start == -1 && common[j]){
				start = j;
				end = j;
			}
			if(start != -1 && common[j] ) end++;
			if(start != -1 && !common[j])
			{
				int temp = end - start+1;
				if(temp > localbest){
					localbest = temp;
					localstart = start;
					localend = end;
					
				}
				start = -1;
				
			}
		}
		
		System.out.println(minutesToSTring(beststart) + " " + minutesToSTring(bestend));
		System.out.println(minutesToSTring(worststart) + " " + minutesToSTring(worstend));
		System.out.println(minutesToSTring(localstart) + " " + minutesToSTring(localend));
		
	}
	
	public static String  minutesToSTring(int minutes){
		int hours =  minutes / 60;
		int left = minutes - hours*60 ;
		String hourss = hours+"";
		String lefts = left+"";
		if(hourss.length() == 1)
			hourss = "0"+hourss;
		if(lefts.length() == 1)
			lefts = "0"+lefts;
		String converted = hourss + ":"+lefts;
		return converted;
	}

}
