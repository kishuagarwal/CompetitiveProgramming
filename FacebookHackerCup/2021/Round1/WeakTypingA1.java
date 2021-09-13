import java.util.Scanner;

public class WeakTypingA1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            String s = in.next();
            int count = 0;

            char lastChar = 'A';
            for (int j = 0; j < n; j += 1) {
                char c = s.charAt(j);
                if (c == 'F') {
                    continue;
                }
                if (c != lastChar) {
                    count += 1;
                }
                lastChar = c;
            }
            count = Math.max(0, count - 1);
            System.out.println("Case #" + i + ": " + count);
        }
    }
}
