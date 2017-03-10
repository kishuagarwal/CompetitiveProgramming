import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 06-03-2015.
 */
public class ChefAndNotebooks {
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int x,y,k,n,p,c;
        boolean isPossible;
        String input[];
        while(t-- > 0){
            input = in.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            n = Integer.parseInt(input[3]);
            isPossible = false;
            x = x-y;
            for (int i = 0; i < n; i++) {
                input = in.readLine().split(" ");
                p = Integer.parseInt(input[0]);
                c = Integer.parseInt(input[1]);
                if(p >= x && c <= k) isPossible = true;
            }
            if(isPossible) System.out.println("LuckyChef");
            else System.out.println("UnluckyChef");
        }
        in.close();
    }
}
