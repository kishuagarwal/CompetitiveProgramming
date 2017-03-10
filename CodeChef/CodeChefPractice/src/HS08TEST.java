import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class HS08TEST {
    public static void main(String args[])throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        double balance = Double.parseDouble(input[1]);
        if (x % 5 == 0 && (x+0.5) <= balance){
            balance -= x;
            balance -= 0.5;
        }
        System.out.printf("%.2f",balance);
        reader.close();
    }
}
