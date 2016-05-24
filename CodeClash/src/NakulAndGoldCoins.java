import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 21-02-2015.
 */
public class NakulAndGoldCoins {

    private static int count[];
    private static int count2[];
    static int n[];
    public static void main(String args[]){
//        count =  new int [1000000];
 //       count2 = new int[1000000];
        n = new int[100000000];
        //seive();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            System.out.println(count[r] - count[l-1]);
        }
        in.close();
    }


    public static void seive (){
        for (int i = 2; i < count.length; i++) {
            if(count[i] != 0) continue;
            for (int j = i+i; j < count.length; j += i) {
                count[j]++;
            }
        }
        for (int i = 2; i < count.length; i++) {
            for (int j = i+i; j < count.length; j += i) {
                count2[j]++;
            }
        }
        for (int i = 1; i < count.length; i++){
            if(count[i] == count2[i] && count[i] == 2)
             count[i] = count[i-1] + 1;
            else
                count[i] = count[i-1];
        }
    }
}

