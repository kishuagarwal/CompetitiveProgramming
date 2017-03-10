import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class SignWave {
    public static void main(String args[])throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int s,c,k;
        long power;
        long points[] = new long[51];
        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            s = Integer.parseInt(input[0]);
            c = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);

            Arrays.fill(points, 0);
            if (s >= 1)
                points[s] = 3;
            power = 2;
            for (int j = s-1; j >= 1; j--) {
                points[j] = points[j+1] + power;
                power <<= 1;
            }
            if(c >= 1)
                points[s] += 2;
            for (int j = 1; j <= c; j++) {

            }
            System.out.println(points[k]);
        }
        reader.close();
    }
}
