import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.hackerearth.com/problem/algorithm/help-ashu-1/
 * Created by Kishu Agarwal on 17-05-2016.
 */
public class HelpAshu {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a1[] =new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = Integer.parseInt(tokenizer.nextToken());
        }
        SegmentTree segmentTree = new SegmentTree(a1);
        //System.out.println(segmentTree.toString());
        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            //System.out.println(segmentTree.toString());
            tokenizer = new StringTokenizer(reader.readLine());
            int queryType = Integer.parseInt(tokenizer.nextToken());
            int first = Integer.parseInt(tokenizer.nextToken());
            int second = Integer.parseInt(tokenizer.nextToken());
            switch (queryType) {
                case 0 : segmentTree.update(first-1, second);
                    break;
                case 1: System.out.println(segmentTree.query(first-1,second-1));
                    break;
                case 2: System.out.println((second - first + 1) - segmentTree.query(first-1,second-1));
                    break;

            }
            
        }
    }

    static class SegmentTree {

        private int a[];
        private int st[];
        public SegmentTree(int a[]) {
            this.a = a;
            int size = (1 << (int)(Math.ceil((Math.log(a.length) / Math.log(2))) + 1)) -1;
            //System.out.println(size);
            st = new int[size];
            build(0,0,a.length-1);
        }

        private void build(int currentNode, int ss, int se) {
         //   System.out.println(currentNode + " " +  ss + "  " + se);

            if (ss == se) {
                //leaf node
                st[currentNode] = ((a[ss] % 2 == 0) ? 1 : 0);
                return;
            }
            int mid = (ss + se) / 2;
            build(2 * currentNode + 1, ss, mid);
            build(2 * currentNode + 2, mid+1, se);
            st[currentNode] = st[currentNode * 2 + 1] + st[currentNode * 2 + 2];

        }

        /**
         * Returns the value of the query from A[qs:qe]
         * @param qs the starting point in the input array
         * @param qe the ending point in the input array
         * @return the result of the query
         */
        public int query(int qs, int qe) {
           return queryUtil(0, 0, a.length -1, qs, qe);
        }

        private int queryUtil(int currentNode, int ss, int se, int qs, int qe) {
            //if out of range then return
            if (ss > qe || se < qs)
                return 0;
            //if completely within the query range, then return the node value
            if (ss >= qs && se <= qe) {
                return st[currentNode];
            }
            //else it partially covers
            int mid = (ss + se) / 2;
            int p1 = queryUtil(2 * currentNode + 1, ss, mid, qs, qe);
            int p2 = queryUtil(2 * currentNode + 2, mid + 1, se, qs, qe);
            return p1 + p2;
        }

        /**
         * Update the value of the A[index] to value
         * @param index the position
         * @param value the new value
         */
        public void update(int index, int value) {
            if (a[index] % 2 != value % 2)
                if (value % 2 == 0) {
                    updateUtil(0, 0, a.length - 1, index, 1);
                }
                else {
                    updateUtil(0, 0, a.length - 1, index, -1);
                }
            a[index] = value;
        }

        private void updateUtil(int currentNode, int ss, int se, int index, int diff) {
            if (index < ss || index > se) {
                return;
            }
            if (ss == se) {
                st[currentNode] += diff;
                return;
            }
            int mid = (ss + se) / 2;
            st[currentNode] += diff;
            updateUtil(2 * currentNode + 1, ss, mid, index, diff);
            updateUtil(2 * currentNode + 2, mid + 1, se, index, diff);
        }

        public String toString() {
            return Arrays.toString(st);
        }
    }
}
