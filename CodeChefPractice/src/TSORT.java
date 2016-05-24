import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class TSORT {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[1000001];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(nums,0,n);
        for (int i = 0; i < n; i++) {
            writer.print(nums[i]+"\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
