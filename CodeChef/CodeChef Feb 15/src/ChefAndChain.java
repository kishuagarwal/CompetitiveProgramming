import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 08-02-2015.
 */
public class ChefAndChain {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String input = in.next();
            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                if (j % 2 == 0)
                    count += input.charAt(j) == '+' ? 0 : 1;
                else
                    count += input.charAt(j) == '-' ? 0 : 1;
            }

            System.out.println(Math.min(count,input.length()-count));

        }
        in.close();
    }
}
