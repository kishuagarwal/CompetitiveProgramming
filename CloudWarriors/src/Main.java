import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		int input1[] = {3,4,2,3,3,3,100000};
		int input2[] = {0,0,0,0,0,0,0,0,1,0,0,0};
		int input3[] = survivalcells(input1, input2);
		System.out.println(Arrays.toString(input3));
	}
	
	 public static int[] survivalcells(int[] input1,int[] input2)
	    {
	        int r,c,s1,s2,b1,b2,g;
	        r = input1[0];
	        c = input1[1];
	        s1 = input1[2];
	        s2 = input1[3];
	        b1 = input1[4];
	        b2 = input1[5];
	        g = input1[6];
	        int count[] = new int[r*c];
	        for (int i = 1; i <= g ;i++) {
	        	for (int j = 0; j < r*c;j++)
	        		count[j] = 0;
	        	for (int j = 0; j < r*c; j++) {
	        		if (input2[j] == 1) {
	        			if (j - c >= 0) count[j-c]++;
	        			if (j + c < r*c) count[j+c]++;
	        			if ((j % c) != 0 ) {
	        				count[j-1]++;
	        				if (j >= c) count[j-1-c]++;
	        				if (j < r*c -c) count[j-1+c]++;
	        			}
	        			if (((j + 1 )% c) != 0 ) {
	        				count[j+1]++;
	        				if (j < r*c-c) count[j+1+c]++;
	        				if (j >= c) count[j-c+1]++;
	        			}
	    
	        		}
	        	
	        	}
	        	//System.out.println(Arrays.toString(count));
	        	for (int j = 0; j < r*c; j++) {
	        		if (input2[j] == 1 && (count[j] < s1 || count[j] > s2)) input2[j] = 0;
	        		if (input2[j] == 0 && (count[j] >= b1 && count[j] <= b2)) input2[j] = 1;
	        	}
	    		//System.out.println(Arrays.toString(input2));

	        
	        }
	        return input2;
	        
	    }

}
