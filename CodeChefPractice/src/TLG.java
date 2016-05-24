import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class TLG {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        String input[] = reader.readLine().split(" ");
        boolean first;
        int f,s,maxLead,currentLead;
        f = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        first = f > s;
        maxLead = Math.abs(f-s);
        for (int i = 1; i < n; i++) {
            input = reader.readLine().split(" ");
            f += Integer.parseInt(input[0]);
            s += Integer.parseInt(input[1]);
            currentLead = Math.abs(f-s);
            if (currentLead > maxLead){
                maxLead = currentLead;
                first = f > s;
            }
        }
        if (first)
        writer.print("1 "+maxLead);
        else
        writer.print("2 "+maxLead);
        reader.close();
        writer.flush();
        writer.close();
    }
}
