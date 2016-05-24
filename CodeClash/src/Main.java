import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int count[] = new int[30001];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(tokens.nextToken())]++;
        }
        for (int i = 1; i < 30000; i++) {
            if(count[i] >=3 )
                ans+=1;
            for (int j = 1; i+(2*j) <= 30000; j++) {
                ans += count[i] * count[i+j] * count[i+2*j];
            }
        }
        System.out.println(ans);
        reader.close();

    }
}
