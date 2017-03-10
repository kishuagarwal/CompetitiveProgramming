import java.util.*;
import java.io.*;

public class garland {

    private static int total_temps[];
    private static ArrayList<Integer> tree[];
    private static int x;
    private static boolean x_present;
    private static int where;
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        tree = new ArrayList[n+1];
        for (int i = 0; i < n+1;i++) {
            tree[i] = new ArrayList<Integer>();
        }
        total_temps = new int[n+1];
        int total_temp = 0;
        int root = 1;
        for (int i =0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int t = Integer.parseInt(tokenizer.nextToken());
            if (a == 0)
                root = i+1;
            tree[a].add(i+1);
            total_temps[i+1] = t;
            total_temp += t;

        } 
        x = total_temp / 3;
        if (total_temp % 3 == 0) {
            find(root);
        }
        System.out.println(-1);
    }


    public static void find(int node) {
        int two_x_found= 0;
        int where_found[] = new int[2];
        for (int child : tree[node]) {
            find(child);
            total_temps[node] += total_temps[child];
            if (x_present && two_x_found < 2) {
                where_found[two_x_found] = where;
                two_x_found += 1;
            }
            
        }
        if (two_x_found == 2) {
            System.out.println(where_found[0] + " " + where_found[1]);
            System.exit(0);
        }
        if (total_temps[node] == 2*x && x_present) {
            System.out.println(node + " " + where);
            System.exit(0);
        }
            
        if (total_temps[node] == x) {
            where_found[two_x_found] = node;
            two_x_found += 1;
        }

        if (two_x_found > 0) {
            x_present = true;
            where = where_found[0];
        }
        else
            x_present = false;
    }

}