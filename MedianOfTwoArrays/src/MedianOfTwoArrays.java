import java.util.Arrays;


public class MedianOfTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 100;
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i = 0 ; i< n;i++)
		{
			a[i] = (int)(Math.random()*100); 
			b[i] = (int)(Math.random()*100);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int c[] = new int[2*n];
		for(int i = 0; i < n; i++)
			c[i] = a[i];
		for(int i = 0; i < n;i++)
		{
			c[n+i] = b[i];
		}
		Arrays.sort(c);
		int median = findMedian(a,b,0,a.length-1,0,b.length-1);
		System.out.println(median+" correct "+c[n-1]);
		if(median != c[n-1])
			System.out.println(Arrays.toString(a)+"\n"+Arrays.toString(b));
		
	}
	
	public static int findMedian(int a[],int b[], int l1,int u1,int l2,int u2){
		
		if(u1-l1 == 1){
			if(b[l2] > a[l1] && b[l2] < a[u1] )
				return b[l2];
			if(b[l2] > a[l1] && b[l2] > a[u1])
				return a[u1];
			if(a[l1] > b[l2] && a[l1] < b[u2])
				return a[l1];
			else
				return b[u2]; 
		}
		
		int medianPos1 = (l1+u1)/2;
		int medianPos2 = (l2+u2)/2;
		int median1 = a[medianPos1];
		int median2 = b[medianPos2];
		if(median1 <= median2){
			if(((u1-l1) % 2) == 0)
			return findMedian(a,b,medianPos1,u1,l2,medianPos2);
			else
				return findMedian(a,b,medianPos1,u1,l2,medianPos2+1);
		}
		else
			if(((u2-l2) % 2) == 0)
			return findMedian(a,b,l1,medianPos1,medianPos2,u2);
			else
			return findMedian(a,b,l1,medianPos1+1,medianPos2,u2);
	}

}
