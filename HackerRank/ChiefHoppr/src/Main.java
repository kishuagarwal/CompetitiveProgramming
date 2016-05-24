import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int initial = 0,h,current = 0;
        for (int i = 0; i < n; i++) {
            h = in.nextInt();
            if(h >= current) //lose energy {
            {
                current -= (h - current);
                if(current < 0) {
                    initial += -current;
                    current = 0;
                }
            }
            else //gain energy
                current += current - h;
        }
        System.out.println(initial);

        in.close();
    }
}
