import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num[] = new int[n];
        long a[][] = new long[11][11];
        long ans,mod = 1000000007;
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        for (int i = 0; i < (n-1); i++) {
            if(num[i] < 0 && num[i] == -num[i+1])
                a[i][i+1] = 1;
            else
                a[i][i+1] = 0;
        }
        int i,j;
        for (int inc = 2; inc < n; inc++) {
            for (int r = 0; r+inc < n; r++) {
                i = r;
                j = r+inc;
                if(num[i] < 0 && num[i] == -num[j]) //matching brackets at i and j
                a[i][j] += 1+a[i+1][j-1];
                if(num[i] < 0) //opening bracket at i than
                {
                    for (int k = i+1; k < j ; k++) {
                        if(num[i] != -num[k]) continue;
                        //one balanced because of matching only
                        //
                        a[i][j] += (1+a[i+1][k-1])*(1+a[k+1][j]);
                    }

                }
                if(num[j] > 0) //closing bracket at j than
                {
                    for (int k = i+1; k < j ; k++) {
                        if(num[j] != -num[k]) continue;
                        a[i][j] += (1+a[k+1][j-1])*(1+a[i][k-1]);
                    }
                }
                a[i][j] = a[i][j] %mod;
            }
        }
        System.out.println(a[0][n-1]);
    in.close();
    }
}
