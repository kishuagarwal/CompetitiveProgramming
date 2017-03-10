import java.util.Scanner;

public class Main {

    static int n;
    static int positions[];

  /*  public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n =in.nextInt();
        int m = in.nextInt();
        positions = new int[n+1];
        boolean  graph[][] = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b= in.nextInt();
            graph[a][b] = true;
            graph[b][a] = true;
        }
        System.out.println(minimalWeight(graph, 1));
        in.close();
    }
*/
    public static long minimalWeight(boolean graph[][] , int pos){
        if(pos == n)
            return 0;
        long min  = Long.MAX_VALUE;
        for (int i = 1; i <= 10; i++) {
            positions[pos] = i;
            min = Math.min(min,minimalWeight(graph,pos+1));
        }

        return min;
    }
}
