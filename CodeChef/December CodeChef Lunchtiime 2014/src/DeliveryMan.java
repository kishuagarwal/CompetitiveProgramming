import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeliveryMan {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
    int n,x,y;
        n = in.nextInt();
        x  = in.nextInt();
        y = in.nextInt();
        int a[] = new int[n];
        ArrayList<Pair> ax = new ArrayList<Pair>();
         for (int i = 0; i < n; i++) {
            a[i] = (in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            ax.add(new Pair(a[i],temp));
        }
        Collections.sort(ax);
        int i;
        int ans = 0;
        for ( i = 0; i < x; i++) {
            ans += ax.get(i).a;
        }
        if(x != n){
            for (int j = x; j < n; j++) {
                ans = ans + ax.get(j).b;
            }
        }
        System.out.println(ans);

        in.close();

    }
    static class Pair implements Comparable<Pair>{
        int a,b;
        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair b) {
            if(this.a > b.a){
                return -1;
            }
            if(this.a < b.a)
                return 1;
            return 0;}
    }
}
