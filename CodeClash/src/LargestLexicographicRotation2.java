import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 21-02-2015.
 */
public class LargestLexicographicRotation2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int best = 0;
        int first,second,limit;
        for (int i = 1; i < input.length(); i++) {
            first = best;
            second = i;
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(second) > input.charAt(first)){
                    best = i;
                    break;
                }
                second = (second+1)%input.length();
                first = (first+1)%input.length();

            }
        }
         System.out.println(input.substring(best)+input.substring(0,best));
        in.close();
    }

}
