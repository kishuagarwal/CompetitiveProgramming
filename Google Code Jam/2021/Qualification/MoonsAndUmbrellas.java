import java.util.Scanner;

public class MoonsAndUmbrellas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();

            Character lastChar = null;
            int cost = 0;
            for (int j = 0; j < s.length(); j += 1) {
                char c = s.charAt(j);
                if (c == 'C') {
                    if (lastChar != null && lastChar == 'J') {
                        cost += y;
                    }
                    lastChar = c;
                } else if (c == 'J') {
                    if (lastChar != null && lastChar == 'C') {
                        cost += x;
                    }
                    lastChar = c;
                }
            }
            System.out.println("Case #" + i + ": " + cost);
        }
    }
}
