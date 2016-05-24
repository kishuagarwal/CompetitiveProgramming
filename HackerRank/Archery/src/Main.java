import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        long radii[] = new long[n];
        for (int i = 0; i < n; i++) {
            radii[i] = in.nextLong();
            radii[i] = radii[i]*radii[i];
        }
        Arrays.sort(radii);
        int points = in.nextInt();
        long x1,x2,y1,y2,temp;
        for (int i = 0; i < points; i++) {
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            long distance1 = x1*x1+y1*y1;
            long distance2 = x2*x2+y2*y2;
            if(distance2 < distance1 ){
                temp = distance1;
                distance2 = distance1;
                distance1 = temp;
            }
            //pos1 is the circle is greater than the first point , -1 if not possible
            int pos1 = loc(radii,distance1,true);
            //pos2 is the circle which lies inside the point ,-1 if not possible
            int pos2 = loc(radii,distance2,false);
            if(pos1 != -1 && pos2 >= pos1)
                System.out.println(pos2-pos1+1);



        }
        in.close();
    }

    public static int loc(long radii[], long number,boolean isFirstPoint){
        int l= 0,u = radii.length-1;
        int middle = (l+u) >> 1;
        while( l <= u ){
            if(radii[middle] == number)
                return middle;
            if(radii[middle] < number)
                l = middle+1;
            else
                u = middle-1;
        }
        if(isFirstPoint){
            for(int i =Math.min(0,l); i < l;i++ ){
                if()
            }

        }else {

        }

    }
}
