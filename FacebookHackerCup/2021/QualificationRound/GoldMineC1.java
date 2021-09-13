import java.util.*;

public class GoldMineC1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t ; i += 1) {
            int n = in.nextInt();
            int[] amount = new int[n];
            for (int j = 0; j < n; j += 1) {
                amount[j] = in.nextInt();
            }

            Map<Integer, List<Integer>> edges = new HashMap<>();
            for (int j = 0; j < n - 1; j += 1) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                edges.putIfAbsent(a, new ArrayList<>());
                edges.putIfAbsent(b, new ArrayList<>());
                edges.get(a).add(b);
                edges.get(b).add(a);
            }

            List<Long> sumTillleaf = new ArrayList<>();
            List<List<Integer>> pathTillLeaves = new ArrayList<>();
            computeSumTillLeaf(edges, amount, -1, 0, 0L, new ArrayList<>(), sumTillleaf, pathTillLeaves);

            int maxPos = 0;
            for (int j = 0; j < sumTillleaf.size(); j += 1) {
                if (sumTillleaf.get(j) > sumTillleaf.get(maxPos)) {
                    maxPos = j;
                }
            }

            Long sum = sumTillleaf.get(maxPos);

            if (edges.getOrDefault(0, new ArrayList<>()).size() > 1) {
                amount[0] = 0;
                int maxChildNode = pathTillLeaves.get(maxPos).get(1);

                for (int j = 0; j < edges.get(0).size(); j += 1) {
                    if (edges.get(0).get(j) == maxChildNode) {
                        edges.get(0).remove(j);
                        break;
                    }
                }

                for (int j = 0; j < edges.get(maxChildNode).size(); j += 1) {
                    if (edges.get(maxChildNode).get(j) == 0) {
                        edges.get(maxChildNode).remove(j);
                        break;
                    }
                }

                sumTillleaf.clear();
                pathTillLeaves.clear();
                computeSumTillLeaf(edges, amount, -1, 0, 0L, new ArrayList<>(), sumTillleaf, pathTillLeaves);

                maxPos = 0;
                for (int j = 0; j < sumTillleaf.size(); j += 1) {
                    if (sumTillleaf.get(j) > sumTillleaf.get(maxPos)) {
                        maxPos = j;
                    }
                }

                sum += sumTillleaf.get(maxPos);
            }
            System.out.println("Case #" + i + ": " + sum);

        }
    }

    private static void computeSumTillLeaf(Map<Integer, List<Integer>> edges, int[] amount, Integer parent, Integer node,
                                           Long sumTillNode, List<Integer> path,
                                           List<Long> sumTillLeaf, List<List<Integer>> paths) {
        path.add(node);
        if (edges.getOrDefault(node, new ArrayList<>()).size() == 0 || (edges.get(node).size() == 1 && parent != -1)) {
            sumTillLeaf.add(sumTillNode + amount[node]);
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (Integer edge: edges.get(node)) {
            if (!Objects.equals(edge, parent)) {
                computeSumTillLeaf(edges, amount, node, edge, sumTillNode + amount[node], path, sumTillLeaf, paths);
            }
        }
        path.remove(path.size() - 1);
    }
}
