import java.util.Scanner;


public class CommonModules {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n,m,a,b,q,commonModules = Integer.MAX_VALUE,t;
		boolean dependencies[][] = new boolean[51][51];
		n = in.nextInt();
		m = in.nextInt();
		for (int i = 0; i < m; i++) {
			a = in.nextInt();
			b = in.nextInt();
			dependencies[a][b] = true;
					}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(dependencies[i][k] && dependencies[k][j])
						dependencies[i][j] = true;
				}
			}
		}
		for (int i = 1; i <= n; i++)
				dependencies[i][i] = false;
		
		q= in.nextInt();
		for (int i = 0; i < q; i++) {
			t = in.nextInt();
			int dependency = 0;
			for (int j = 1; j <= n; j++) {
				if(dependencies[t][j])
					dependency = dependency | (1 << j);
			}
			commonModules = commonModules & dependency;
		}
		boolean any = false;
		for (int j = 1; j <=n; j++) {
			if((commonModules & (1 << j)) != 0 )
			{
				any = true;
				System.out.print(j+" ");
			}
			}
		if(!any)
			System.out.println(-1);
		in.close();
	}

}
