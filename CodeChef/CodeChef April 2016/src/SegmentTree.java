import java.util.Arrays;

public class SegmentTree {

	private int segmentTree[];
	private int arr[];

	public SegmentTree(int arr[]) {
		this.arr = arr;
		int height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
		int size = (int) Math.pow(2, height);
		segmentTree = new int[2 * size - 1];
		constructSegmentTree(0, 0, arr.length - 1);
	}

	private int constructSegmentTree(int currentNode, int start, int end) {
		// System.out.println(currentNode + " " + start + " " + end);
		if (start == end) {
			// leaf node
			segmentTree[currentNode] = arr[start];
			return segmentTree[currentNode];
		}

		int mid = start + ((end - start) >> 1);
		segmentTree[currentNode] = constructSegmentTree(2 * currentNode + 1, start, mid)
				+ constructSegmentTree(2 * currentNode + 2, mid + 1, end);
		return segmentTree[currentNode];
	}

	private void updateValue(int index, int newValue) {

		int diff = newValue - arr[index];
		updateValueUtil(diff, index, 0, 0, arr.length - 1);
	}

	public int updateValueUtil(int diff, int index, int currentNode, int segmentStart, int segmentEnd) {
		// if out of range then skip
		if (index < segmentStart || index > segmentEnd)
			return 0;

		if (segmentStart == segmentEnd) {
			segmentTree[currentNode] += diff;
			return diff;
		}

		int mid = segmentStart + ((segmentEnd - segmentStart) >> 1);
		int increment = updateValueUtil(diff, index, 2 * currentNode + 1, segmentStart, mid)
				+ updateValueUtil(diff, index, 2 * currentNode + 2, mid + 1, segmentEnd);
		segmentTree[currentNode] += increment;
		return increment;

	}

	@Override
	public String toString() {
		String segTree = "";
		for (int i = 0; i < segmentTree.length; i++) {
			segTree += segmentTree[i] + "  ";
		}
		return segTree;
	}

	private int getSumUtil(int queryStart, int queryEnd, int currentNode, int segmentStart, int segmentEnd) {
		// System.out.println(queryStart + " " + queryEnd + " " + currentNode +
		// " " + segmentStart + " " + segmentEnd);
		// inside the range
		if (queryStart <= segmentStart && queryEnd >= segmentEnd) {
			return segmentTree[currentNode];
		}
		// out of range
		if ((queryStart < segmentStart && queryEnd < segmentStart)
				|| (queryStart > segmentEnd && queryEnd > segmentEnd)) {
			return 0;
		}

		if (segmentStart == segmentEnd) {
			return segmentTree[currentNode];
		}

		// if covers some of the part
		int mid = segmentStart + ((segmentEnd - segmentStart) >> 1);
		return getSumUtil(queryStart, queryEnd, 2 * currentNode + 1, segmentStart, mid)
				+ getSumUtil(queryStart, queryEnd, 2 * currentNode + 2, mid + 1, segmentEnd);

	}

	public int getSum(int queryStart, int queryEnd) {
		return getSumUtil(queryStart, queryEnd, 0, 0, arr.length - 1);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 5 };
		System.out.println("Original Array is \n" + Arrays.toString(arr));
		SegmentTree tree = new SegmentTree(arr);
		System.out.println("Segment Tree is \n" + tree.toString());
		int l = 3, r = 3;
		System.out.println("Sum from " + l + " to " + r + " is " + tree.getSum(l, r));
		System.out.println("Updating the value of index 0 to 4");
		tree.updateValue(0, 4);
		System.out.println("Segment Tree after updation is \n" + tree.toString());

	}

}
