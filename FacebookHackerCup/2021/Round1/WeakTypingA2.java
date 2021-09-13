import java.util.Scanner;

public class WeakTypingA2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            String s = in.next();

            /*char lastChar = 'A';
            int switches = -1;
            int lastNonFPosition = 0;
            long ans = 0;
            long lastIncrement = 0;

            for (int j = 0; j < n; j += 1) {
                char c = s.charAt(j);
                ans = (ans + lastIncrement) % 1000000007;
                if (c == 'F') {
                    continue;
                }
                if (c != lastChar) {
                    switches += 1;
                    if (switches > 0) {
                        lastIncrement += lastNonFPosition + 1;
                        ans += (lastNonFPosition + 1) % 1000000007;
                    }
                }
                lastChar = c;
                lastNonFPosition = j;
            }*/

            // Solution 2
            int lastNonFPosition = -1;
            char lastNonFChar = 'A';
            long ans = 0;
            for (int j = 0; j < n; j += 1) {
                char c = s.charAt(j);
                if (c == 'F') {
                    continue;
                }
                if (c != lastNonFChar && lastNonFPosition != -1) {
                    ans += ((long)(lastNonFPosition + 1) * (n - j)) % 1000000007;
                }
                lastNonFPosition = j;
                lastNonFChar = c;
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
