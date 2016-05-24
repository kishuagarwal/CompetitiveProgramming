import java.math.BigDecimal;

public class CountingMatrices {

	/**
	 * @param args
	 */
	static int less[] = new int[1562500];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(lessProducts(1562500));
		//precalculate();
		//System.out.println((less[1562500-1].multiply(new BigDecimal("1562500")).intValue()));
		int mul,ans;
		for(int i = 3; i <= 2500; i++)
		{
			ans = 0;
			for(int j = 1; j < i; j++){
				mul = j*(i-j);
				if(less[mul-2] != 0){
					ans += less[mul-2];
				}
				else
				{
					ans += lessProducts(mul-1);
				}
			}
			//System.out.println(ans);
		}
		
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		precalculate();
//		int n, temp,s;
//		for (int i = 1; i <= t; i++) {
//			n = in.nextInt();
//			temp = 0;
//			s = n >> 1;
//			for (int j = 1; j <= s; j++) {
//				temp += ((j)*(n-j)-1)*less[(j)*(n-j) - 2];
//			}
//			temp = temp << 1;
//			if((n & 1) != 1)
//				temp -= ((n/2)*(n/2)-1)*less[(n/2)*(n/2)-2];
//			System.out.println(temp);
//
//		}
//		in.close();
		
	}
	
	public static void calculate(int n){
		less[0] = 1;
		for(int i = 1; i < 1562500; i++){
			less[i] = (int) (less[i-1]+(1.0/(i+1)));
		}
	}

	public static int lessProducts(int n) {
		double ans = 0.0;
		for (int i = 1; i <= n; i++) {
			ans += 1.0 / i;
		}
		//System.out.println((int)(ans*n));
		less[n-1] = (int) (ans*n);
		return less[n-1];
	}
	
	}
