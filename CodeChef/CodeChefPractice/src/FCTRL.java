import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class FCTRL {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long num,twoCount,fiveCount,power;
        for (int i = 0; i < n; i++) {
            num = Long.parseLong(reader.readLine());
            twoCount = 0;
            power = 2;
            while (power <= num){
                twoCount += num/power;
                power <<= 1;
            }
            fiveCount = 0;
            power = 5;
            while (power <= num ){
                fiveCount += num/power;
                power *= 5;
            }
            System.out.println(Math.min(twoCount,fiveCount));
        }
        reader.close();
    }
}
