import java.util.Scanner;


public class NoisyNeighbours {

	private static int best;
	private static boolean ap[][];
	private static int r,c;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int te;
		for (int i = 1; i <= t; i++) {
			r = in.nextInt();
			c = in.nextInt();
			te = in.nextInt();
			best = Integer.MAX_VALUE;
			boolean apl[] = new boolean[r *c];
			solve(apl,0,te,0);
			System.out.println(best);
		}
		in.close();
	}
	
	private static void solve(boolean apl[], int pos , int tenants, int filled ) {
		if (pos == apl.length) {
			find(apl);
			return;
		}
		solve(apl,pos+1,tenants,filled);
		apl[pos] = true;
		if (filled < tenants)
			solve(apl,pos+1,tenants,filled+1);
		apl[pos] = false;
	}
	
	private static void find(boolean apl[]) {
		ap = new boolean[r][c];
		int temp = 0;
		for (int i = 0; i < r; i++ ) {
			for (int j = 0; j < c; j++)
			{
				ap[i][j] = apl[temp];
				temp++;
			}
		}
		
		int count = 0;
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				if (!ap[x][y]) continue;
				if (y != c-1 && ap[x][y+1]) count++;
				if (x != r-1 && ap[x+1][y]) count++;
			}
		}
		best = Math.min(best, count);
		System.out.println(count);
		
	}

}
