import java.util.Scanner;

public class INTXOR {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            int[] ans = new int[n];

            // a,b,c
            System.out.println("1 1 2 3");
            System.out.flush();
            int fThree = in.nextInt();
            assert(fThree != -1);

            // b,c,d
            System.out.println("1 2 3 4");
            System.out.flush();
            int sThree = in.nextInt();
            assert(sThree != -1);

            // a,d
            int common = fThree ^ sThree;

            // e
            System.out.println("1 1 4 5");
            System.out.flush();
            ans[4] = in.nextInt();
            assert(fThree != -1);

            // f
            System.out.println("1 1 4 6");
            System.out.flush();
            ans[5] = in.nextInt();

            // Get next value by using previous 2 values
            for (int j = 6; j < n; j += 1) {
                System.out.println("1 " + (j - 1) + " " + j + " " + (j + 1));
                System.out.flush();
                int temp = in.nextInt();
                ans[j] = temp ^ ans[j - 2] ^ ans[j - 1];
            }

            // b
            System.out.println("1 2 " + (n - 1) + " " + n);
            System.out.flush();
            int temp = in.nextInt();
            ans[1] = ans[n - 2] ^ ans[n - 1] ^ temp;

            // c
            System.out.println("1 3 5 " + n);
            System.out.flush();
            temp = in.nextInt();
            ans[2] = ans[n - 1] ^ ans[4] ^ temp;

            // a
            ans[0] = fThree ^ ans[1] ^ ans[2];

            // d
            ans[3] = ans[0] ^ common;

            System.out.print("2 ");
            for (int j = 0; j < n; j += 1) {
                System.out.print(ans[j]);
                if (j != (n - 1)) {
                    System.out.print(" ");
                }
            }
            System.out.flush();
        }
        int output = in.nextInt();
        assert(output == 1);
    }
}