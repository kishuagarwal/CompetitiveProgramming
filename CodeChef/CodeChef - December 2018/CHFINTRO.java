import java.util.Scanner;

public class CHFINTRO {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();

        for (int i = 0; i < n; i += 1) {
            int R = in.nextInt();
            if (R < r) {
                System.out.println("Bad boi");
            } else {
                System.out.println("Good boi");
            }
        }
    }
}