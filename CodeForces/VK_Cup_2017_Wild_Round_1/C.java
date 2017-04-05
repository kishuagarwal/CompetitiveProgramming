import java.util.*;
import java.io.*;


public final class C {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int count[] = {6,2,5,5,4,5,6,3,7,6};

        StringBuilder ans = new StringBuilder("");
        while (n > 0) {
            int minimum = 10;
            int pos = 10;
            for (int i = 0; i < 10; i++) {
                if (count[i] <= n && count[i] < minimum) {
                    minimum = count[i];
                    pos = i;
                }
            }
            if (minimum != 10) {
                ans.insert(0, pos);
                n -= minimum;
            }
            else
                break;
        }
        boolean found = false;
        if (n == 1) {
            int length = ans.length();
            for (int j = 0; j < length; j++) {
                if (count[ans.charAt(j) - '0'] < 7) {
                    for (int i = 9; i >= 0; i--) {
                        if (count[i] == count[ans.charAt(j) - '0'] + 1) {
                            ans = new StringBuilder(ans.substring(0, j) + i + ans.substring(j+1));
                            found = true;
                            break;
                        }
                    }
                }
                if (found)
                    break;
            }
        }
        System.out.println(ans);

        reader.close();
    }
}