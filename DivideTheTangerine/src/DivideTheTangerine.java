import java.util.Scanner;


public class DivideTheTangerine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in =  new Scanner(System.in);
		int t1= in.nextInt();
		int n,k,p,a,b,s,j,t;
		boolean input[] = new boolean[50000003]; 
		boolean input2[] = new boolean[50000003];
		for(int i = 1; i <= t1; i++){
		 n = in.nextInt();
		 k = in.nextInt();
		 p = in.nextInt();
		 for(j = 0; j < k ; j++ ){
			 a = in.nextInt();
			 b = in.nextInt();
			 if(b < a){
				 for(t = a; t <= n; t++)
					 input[t] = true;
				 for(t = 1; t < b; t++)
					 input[t] = true;
				 input[b]  = false;
			 }
			 else
			 {
			 for(s = a; s < b; s++){
				 input[s] = true;
			 }
			 input[b] = false;
			 }
		 }
		 for(j = 0; j < p ; j++ ){
			 a = in.nextInt();
			 b = in.nextInt();
			 if(b < a){
				 for(t = a; t <= n; t++)
					 input2[t] = true;
				 for(t = 1; t < b; t++)
					 input2[t] = true;
				 input2[b]  = false;
			 }
			 else
			 {
			 for(s = a; s < b; s++){
				 input2[s] = true;
			 }
			 input2[b] = false;
			 }
		 }
		 for( j = 1; j <= n; j++){
			 if(input2[j] ==  false && input[j] == true)
				 break;
		 }
		 if(j == (n+1))
			 System.out.println("Yes");
		 else
			 System.out.println("No");
		 
		}
		in.close();
	}

}
