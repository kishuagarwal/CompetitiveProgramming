import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class COINS {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = reader.readLine();
        while (input != null){
            long num = Long.parseLong(input);
            long exchange = num /2  + num / 3 + num / 4;
            if (exchange > num)
                num = exchange;
            pw.println(num);
            input = reader.readLine();
        }
        reader.close();
        pw.flush();
        pw.close();
    }
}
