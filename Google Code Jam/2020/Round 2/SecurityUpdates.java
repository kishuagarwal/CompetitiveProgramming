import java.util.*;

public class SecurityUpdates {

    static class MyNode implements Comparable<MyNode> {
        int index;
        int value;

        public MyNode(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(MyNode o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t =  in.nextInt();

        for (int i = 1; i <= t; i++) {
            int c = in.nextInt();
            int d = in.nextInt();

            PriorityQueue<MyNode> latencyHeap = new PriorityQueue<>();

            int[] nodesLatencies = new int[c];
            int[] nodesInfo = new int[c];
            int[] nodesOrder = new int[c];

            for (int j = 1; j < c; j += 1) {
                int x = in.nextInt();
                nodesInfo[j] = x;

                if (x >= 0) {
                    latencyHeap.add(new MyNode(j, x));
                    nodesLatencies[j] = x;
                } else {
                    int nodeOrderIdx = -x;
                    while (nodesOrder[nodeOrderIdx] > 0) {
                        nodeOrderIdx += 1;
                    }
                    nodesOrder[nodeOrderIdx] = j;
                }
            }

            int currentNodesOrderIdx = 0;
            while (!latencyHeap.isEmpty()) {
                MyNode node = latencyHeap.poll();
                // Find an empty slot in nodesOrder
                while (nodesOrder[++currentNodesOrderIdx] != 0);
                nodesOrder[currentNodesOrderIdx] = node.index;
            }

            for (int j = 1; j < c; j++) {
                int nodeIdx = nodesOrder[j];
                int prevNodeIdx = nodesOrder[j - 1];
                if (nodesInfo[nodeIdx] < 0) {
                    // Previous is a latency value
                    if (nodesInfo[prevNodeIdx] >= 0) {
                        nodesLatencies[nodeIdx] = nodesLatencies[prevNodeIdx] + 1;
                    }
                    // Previous is a negative value
                    else {
                        // Previous has the same position
                        if (nodesInfo[prevNodeIdx] == nodesInfo[nodeIdx]) {
                            nodesLatencies[nodeIdx] = nodesLatencies[prevNodeIdx];
                        } else {
                            nodesLatencies[nodeIdx] = nodesLatencies[prevNodeIdx] + 1;
                        }
                    }
                }
            }

            // Nodes latencies has been decided

            System.out.print("Case #" + i + ": ");
            for (int j = 0; j < d; j++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;

                int latency = Math.abs(nodesLatencies[u] - nodesLatencies[v]);
                if (latency > 0) {
                    System.out.print(latency);
                } else {
                    System.out.print(1000000);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
