import java.util.Scanner;

public class BreakTheFriendShip {

	static int n;
	static boolean possible;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		int a, b;
		possible = true;
		boolean studentsLeft[] = new boolean[51];
		boolean friends[][] = new boolean[51][51];
		for (int i = 0; i < m; i++) {
			a = in.nextInt();
			b = in.nextInt();
			friends[a][b] = true;
			friends[b][a] = true;

		}

		for (int j = 1; j <= n; j++) {
			studentsLeft[j] = true;
		}
		int group[] = new int[2];
		
		
		add(group, friends,1,0);

		if(possible)
			System.out.println("Yes");
		else
			System.out.println("No");
		in.close();
	}
	
	public static void add(int groups[], boolean friends[][] , int person, int groupId){
		if((groups[groupId] & (1 << person)) != 0)
			return;
		groups[groupId] = groups[groupId] | (1 << person);
		for (int i =1; i <= n; i++) {
			if(friends[person][i]){
				if((groups[groupId] & (1 << i)) != 0)
				{
					possible = false;
					return;
				}
				add(groups,friends,i,1-groupId);
				if(possible == false)
					return;
			
			}
		}
	}
}
