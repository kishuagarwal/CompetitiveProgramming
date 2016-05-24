import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 05-12-2014.
 */
public class Solution {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n,k,numbers[] = new int[1001];
        int largest ,largestPos,ans,xor;
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            k = in.nextInt();
            for (int j = 0; j < n; j++) {
                numbers[j] = in.nextInt();
            }
            ans = k;
            for (int j = 0; j < n; j++) {
                largest = 0;
                largestPos = -1;
                for (int l = 0; l < n; l++) {
                    if(numbers[l] != -1) //not already taken
                    {
                        xor = numbers[l] ^ ans;
                        if(xor > largest){
                            largest = xor;
                            largestPos = l;
                        }
                    }
                }
                if(largest > ans){
                    ans = largest;
                    numbers[largestPos] = -1;
                }
            }

            System.out.println(ans);

        }
        in.close();
    }
}
