import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 28-12-2014.
 */
public class StringMatching {

    public  static void main(String args[]){
        Scanner in = new Scanner(System.in);
        char a[] = in.next().toCharArray();
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            char b[] = in.next().toCharArray();
            int s[] = new int[a.length - b.length + 1];
            int numberOfOnes[] = new int[b.length];
            for (int j = 0; j < b.length; j++) {
                numberOfOnes[j] += b[j] - '0';
            }
            for (int j = 0; j < b.length; j++) {
                if(a[j] == '0')
                    s[j] =
            }
        }
        in.close();

    }
}
