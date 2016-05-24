import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Kishu Agarwal on 18-05-2016.
 */
public class RoyAndCoinBoxes {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer;
        int a[] = new int[n];
        SegmentTreeLazyPropagation st = new SegmentTreeLazyPropagation(a);
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            st.updateRange(l-1,r-1,1);
          //  System.out.println(st.toString());
        }
        for (int i = 0; i < n; i++) {
            st.queryRange(i,i);
        }
        //System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(reader.readLine());
            int start = 0, end = a.length -1;
            int mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                if (a[mid] >= x) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            if (a[mid] == x)
                mid--;
            System.out.println(a.length - mid -1);
        }
    }


    static class SegmentTreeLazyPropagation {

        int a[];
        int st[];
        int lazy[];
        public SegmentTreeLazyPropagation(int a[]) {
            this.a = a;
            int size = (1 << (int)(Math.ceil((Math.log(a.length) / Math.log(2))) + 1)) -1;
            st = new int[size];
            lazy = new int[size];
            build(0,0,a.length-1);
        }


        private int build(int currentNode, int ss, int se) {
            if (ss == se) {
                //leaf node
                st[currentNode] = a[ss];
                return st[currentNode];
            }
            int mid = (ss + se) / 2;
            int p1 = build(2 * currentNode + 1, ss, mid);
            int p2 = build(2 * currentNode + 2, mid+1, se);
            st[currentNode] = p1 + p2;
            return st[currentNode];
        }

        /**
         * Returns the value of the query from A[qs:qe]
         * @param qs the starting point in the input array
         * @param qe the ending point in the input array
         * @return the result of the query
         */
        public int queryRange(int qs, int qe) {
            return queryRangeUtil(0, 0, a.length -1, qs, qe);
        }

        private int queryRangeUtil(int currentNode, int ss, int se, int qs, int qe) {
            if (lazy[currentNode] != 0) {
                st[currentNode] += (se - ss + 1) * lazy[currentNode];
                if (ss != se ) {
                    lazy[currentNode * 2 + 1] += lazy[currentNode];
                    lazy[currentNode * 2 + 2] += lazy[currentNode];
                }
                else
                    a[ss] = st[currentNode];
                lazy[currentNode] = 0;
            }

            //if out of range then return
            if (ss > qe || se < qs)
                return 0;
            //if completely within the query range, then return the node value
            if (ss >= qs && se <= qe) {
                return st[currentNode];
            }
            //else it partially covers
            int mid = (ss + se) / 2;
            int p1 = queryRangeUtil(2 * currentNode + 1, ss, mid, qs, qe);
            int p2 = queryRangeUtil(2 * currentNode + 2, mid + 1, se, qs, qe);
            return p1 + p2;
        }

        /**
         *
         * Update the value of the A[us:ue] by value
         * @param us the start position
         * @param ue  the end position
         * @param value the value by which to increase each element
         */
        public void updateRange(int us, int ue, int value) {
            updateRangeUtil(0,0,a.length-1,us,ue, value);
        }

        private void updateRangeUtil(int currentNode, int ss, int se, int us, int ue, int diff) {
            //check if the currentNode has any pending updates
            if (lazy[currentNode] != 0) {
                st[currentNode] += (se - ss + 1) * lazy[currentNode];
                if (ss != se) {
                    //if not the leaf node then set pending updates on the children
                    lazy[2 * currentNode + 1] += lazy[currentNode];
                    lazy[2 * currentNode + 2] += lazy[currentNode];
                }
                lazy[currentNode] = 0;
            }

            //Check for out of range
            if (ue < ss || us > se) {
                return;
            }

            //if completely inside
            if (ss >= us && se <= ue) {
                st[currentNode] += (se - se + 1 ) * diff;
                if (ss != se) {
                    //set the lazy flag on the children
                    lazy[2 * currentNode + 1] += diff;
                    lazy[2 * currentNode + 2] += diff;
                }
                else
                    a[ss] = st[currentNode];
                return;
            }
            int mid = (ss + se) / 2;
            updateRangeUtil(2 * currentNode + 1, ss, mid, us, ue, diff);
            updateRangeUtil(2 * currentNode + 2, mid + 1, se, us, ue, diff);
            st[currentNode] = st[currentNode * 2 + 1] + st[currentNode * 2 + 2];
        }

        public String toString() {
            return Arrays.toString(st);
        }
    }
}
