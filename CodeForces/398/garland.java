import java.util.*;
import java.io.*;

public class garland implements Runnable{

    private int total_temps[];
    private ArrayList<Integer> tree[];
    private int x;
    private boolean x_present;
    private int where;
    private int root;
    public static void main(String args[]) {
        new Thread(null, new garland(), "1", 1 << 29).start();
    }


    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            tree = new ArrayList[n];
            for (int i = 0; i < n;i++) {
                tree[i] = new ArrayList<Integer>();
            }
            total_temps = new int[n];
            int total_temp = 0;
            root = 1;
            for (int i =0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                int a = Integer.parseInt(tokenizer.nextToken());
                int t = Integer.parseInt(tokenizer.nextToken());
                if (a == 0)
                    root = i;
                else
                    tree[a-1].add(i);
                total_temps[i] = t;
                total_temp += t;

            } 
            x = total_temp / 3;
            if (total_temp % 3 == 0) {
                find(root, root);
            }
            System.out.println(-1);    
        }
        catch(Exception e) {

        }
        
    }

    public void find(int node, int parent) {
        int two_x_found= 0;
        //if (n == 1000000 && count > 1000000)
        //    System.out.println(node+ " " + parent);
        int where_found[] = new int[2];
        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            find(child, node);
            total_temps[node] += total_temps[child];
            if (x_present && two_x_found < 2) {
                where_found[two_x_found] = where;
                two_x_found += 1;
            }
            
        }
        if (two_x_found == 2) {
            System.out.println((where_found[0]+1) + " " + (where_found[1]+1));
            System.exit(0);
        }
        if (node != root && total_temps[node] == 2*x && two_x_found > 0) {
            System.out.println((node+1) + " " + (where_found[0]+1));
            System.exit(0);
        }
            
        if (node != root && total_temps[node] == x) {
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