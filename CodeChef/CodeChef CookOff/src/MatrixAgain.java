import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 21-12-2014.
 */
public class MatrixAgain {

    static int n,m,mod;
   /* public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        mod = 10000007;
        int matrix[][] = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(product(matrix,m).mod(BigInteger.valueOf(mod))  );
        in.close();
    }
*/
    public static BigInteger product(int matrix[][] ,int column){
        BigInteger ans = BigInteger.ZERO;
        if(column == 0)
            return BigInteger.ONE;
        BigInteger previous = product(matrix, column-1);
        for (int i = 1; i <= n ; i++) {
            ans = (ans.add(BigInteger.valueOf(matrix[i][column]).multiply(previous)));
        }
        return ans;
    }
}
