import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 09-03-2015.
 */
public class QR2011A {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int o[] = new int[100];
        int b[] = new int[100];
        for (int i = 1; i <= t; i++) {
            String input[] = in.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int ocount = 0;
            int bcount = 0;
            for (int j = 1; j < input.length; j+=2) {
                if (input[j].charAt(0) == 'O'){
                    o[ocount++] = Integer.parseInt(input[j+1]);
                }
                else{
                    b[bcount++] = Integer.parseInt(input[j+1]);
                }
            }

        }
        in.close();
    }
}
