import java.util.Scanner;

public class MAXEP {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int c = in.nextInt();

        int coins = 1000;

        int last = 0;
        int current;

        boolean found = false;

        int jump = 1;
        // jump * (jump - (1000 - c)) < -N

        for (int i = 1; i <= N; i += 1) {
            if ((i * (i - (coins - c))) < -N) {
                jump = i;
                break;
            }
        }

        jump = Math.min(256, N);

        while (true) {
            coins -= 1;
            // use increment of jump
            current = Math.min(N, last + jump);
            System.out.println(1 + " " + current);
            System.out.flush();
            int state = in.nextInt();
            if (state == 0) {
                last = current;
            } else if (state == 1) {
                // it breaked
                // repair
                coins -= c;
                System.out.println(2);
                System.out.flush();
                // Check one by one
                for (int i = last + 1; i < current; i += 1) {
                    coins -= 1;
                    System.out.println(1 + " " + i);
                    System.out.flush();
                    state = in.nextInt();
                    if (state == 1) {
                        System.out.println(3 + " " + i);
                        System.out.flush();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    // then current is itself the breaking point
                    System.out.println(3 + " " + current);
                    System.out.flush();
                    break;
                } else {
                    break;
                }
            }
        }
    }

}