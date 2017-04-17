import java.util.*;
import java.io.*;

public class CLIQUED {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int n,k,x,m,s,a,b,cos;

        for (int i = 1; i <= t; i++) {
            String input[] = reader.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);
            x = Integer.parseInt(input[2]);
            m = Integer.parseInt(input[3]);
            s = Integer.parseInt(input[4]);

            List<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            List<ArrayList<Integer>> cost = new ArrayList<ArrayList<Integer>>();

            long distances[] = new long[n];

            for (int j = 0; j < n; j++) {
                edges.add(new ArrayList<Integer>());
                cost.add(new ArrayList<Integer>());
                distances[j] = Long.MAX_VALUE;
            }

            for (int j = 0; j < m; j++) {
                input = reader.readLine().split(" ");
                a = Integer.parseInt(input[0]);
                b = Integer.parseInt(input[1]);
                cos = Integer.parseInt(input[2]);
                edges.get(a-1).add(b-1);
                cost.get(a-1).add(cos);
                edges.get(b-1).add(a-1);
                cost.get(b-1).add(cos);
            }

            boolean visited[] = new boolean[n];
            Queue<Pair> queue = new PriorityQueue<Pair>();
            queue.add(new Pair(s-1, 0));
            distances[s-1] = 0;
            boolean firstTime = true;
            while (queue.size() != 0) {
                Pair current = queue.poll();
                int currentNode = current.node;
                if (visited[currentNode])
                    continue;
                visited[currentNode] = true;
                if (currentNode < k) {
                    if (firstTime) {
                        firstTime = false;
                        for (int j = 0; j < k; j++) {
                            distances[j] = Math.min(distances[j], distances[currentNode] + x);
                            queue.add(new Pair(j, distances[j]));
                        }
                    }
                }
                for (int c = 0; c < edges.get(currentNode).size(); c++) {
                    int edge = edges.get(currentNode).get(c);
                    if (!visited[edge]) {
                        long distance = distances[currentNode] + cost.get(currentNode).get(c);
                        if (distances[edge] > distance) {
                            distances[edge] = distance;
                            queue.add(new Pair(edge, distance));
                        } 
                    }
                }

            }
            for (int j = 0; j < n; j++) {
                System.out.print(distances[j] + " ");
            }
            System.out.println();
        }

        reader.close();
    }

    static class Pair implements Comparable<Pair>{
        int node;
        long distance;
        Pair(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(Pair other) {
            long diff = this.distance - other.distance;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }


}