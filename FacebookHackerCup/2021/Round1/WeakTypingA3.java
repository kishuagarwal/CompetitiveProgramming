import java.util.Scanner;

public class WeakTypingA3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            String s = in.next();

            // Locations of 'O' or 'X' extremes in the current segment
            long firstNonFPosition = -1;
            char firstNonFChar = 'A';
            long lastNonFPosition = -1;
            char lastNonFChar = 'A';
            long lastCharIncrementCount = 0;
            long firstCharIncrementTotal = 0;
            long switches = 0;

            long ans = 0;

            long currentLength = 0;

            long mod = 1000000007L;
            for (int j = 0; j < n; j += 1) {
                char c = s.charAt(j);
                if (c == '.') {
                    if (lastNonFPosition != -1) {
                        // Merge results from both halves
                        long newAns = (ans * 2) % mod;
                        long newSwitches = (switches * 2) % mod;
                        boolean newSwitch = false;
                        // Merge results from right into left
                        newAns = (newAns + ((currentLength * lastCharIncrementCount) % mod)) % mod;
                        // Merge results from left into right
                        newAns = (newAns + ((currentLength * firstCharIncrementTotal) % mod)) % mod;
                        // New Switch ??
                        if (firstNonFChar != lastNonFChar) {
                            newAns = (newAns + (((lastNonFPosition + 1) % mod) * ((currentLength - firstNonFPosition) % mod)) % mod) % mod;
                            newSwitches = (newSwitches + 1) % mod;
                            newSwitch = true;
                        }
                        ans = newAns;
                        firstCharIncrementTotal = ((2 * firstCharIncrementTotal) % mod + ((switches * currentLength) % mod) +
                                (newSwitch ? (currentLength - firstNonFPosition) % mod : 0)) % mod;
                        lastCharIncrementCount = ((2 * lastCharIncrementCount) % mod + ((switches * currentLength) % mod) +
                                (newSwitch ? (lastNonFPosition + 1) % mod : 0)) % mod;
                        lastNonFPosition = (lastNonFPosition + currentLength) % mod;
                        switches = newSwitches;
                    }
                    currentLength = (currentLength * 2) % mod;
                    continue;
                }

                currentLength = (currentLength + 1) % mod;

                ans = (ans + lastCharIncrementCount) % mod;
                firstCharIncrementTotal = (firstCharIncrementTotal + switches) % mod;
                if (c == 'F') {
                    continue;
                }

                if (lastNonFPosition != -1 && lastNonFChar != c) {
                    lastCharIncrementCount = (lastCharIncrementCount + (lastNonFPosition + 1)) % mod;
                    ans = (ans + lastNonFPosition + 1) % mod;
                    firstCharIncrementTotal = (firstCharIncrementTotal + 1) % mod;
                    switches = (switches + 1) % mod;
                }

                if (firstNonFPosition == -1) {
                    firstNonFPosition = (currentLength - 1) % mod;
                    firstNonFChar = c;
                }
                lastNonFPosition = (currentLength - 1) % mod;
                lastNonFChar = c;
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
