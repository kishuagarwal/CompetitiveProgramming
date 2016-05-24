import java.util.Scanner;


public class MansaAndTheStones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n,a,b,lastWritten,current;
		for (int i = 0; i < t; i++) {
			n = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			if(b < a){
				int temp = a;
				a = b;
				b = temp;
			}
			n--;
            lastWritten = 0;
			if(a != b)
			for(int j = n; j >= 0;j--){
                current=(a*j+b*(n-j));
                if(lastWritten != current)
				System.out.print(current+" ");
                lastWritten = current;
			}
			else
				System.out.print(a*n);
			System.out.println();
		}
		in.close();
	}

}
