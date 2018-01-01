class SegmentTreeNode(object):
    def __init__(self, value):
        self.ones_subarrays = value
        self.len = 1
        self.len_ones_left = value
        self.len_ones_right = value

    def changeValue(self, value):
        self.ones_subarrays = value
        self.len_ones_left = value
        self.len_ones_right = value

    def __str__(self):
        return '%d %d %d %d' % (self.ones_subarrays, self.len, self.len_ones_left, self.len_ones_right)


class SegmentTree(object):
    def __init__(self, n, max_bound):
        self.size = n
        self.max_bound = max_bound
        self.tree = [SegmentTreeNode(0) for _ in range(4*n)]
        self.buildST()

    def buildST(self):
        # Set all the position to 0
        for i in range(self.size):
            self.update(i, 0)

    def combine(self, left, right):
        res = SegmentTreeNode(0)
        # Resulting length is the combined length of the left and child nodes
        res.len = left.len + right.len
        # len_ones_left of the resulting node would be equal to the len_ones_left
        # of the left node unless when len_ones_left is equal to the left node length
        # in which case we need to add the len_ones_left of the right node as well
        res.len_ones_left = left.len_ones_left
        if left.len_ones_left == left.len:
            res.len_ones_left += right.len_ones_left

        res.len_ones_right = right.len_ones_right
        if right.len_ones_right == right.len:
            res.len_ones_right += left.len_ones_right

        res.ones_subarrays = left.ones_subarrays + right.ones_subarrays + left.len_ones_right * right.len_ones_left

        return res

    def query(self, l, r):
        return self.queryST(0, 0, self.size - 1, l, r).ones_subarrays

    def queryST(self, node, node_l, node_r, l, r):
        # If the node lies completely inside the query range
        if node_l >= l and node_r <= r:
            return self.tree[node]
        # Else if the node is completely outside the range, then we return a empty segment tree node
        # with value 0
        if node_l > r or node_r < l:
            return SegmentTreeNode(0)
        m = (node_l + node_r) // 2  # Get the middle point
        return self.combine(self.queryST(node * 2 + 1, node_l, m, l, r),
                            self.queryST(node * 2 + 2, m + 1, node_r, l, r))
    
    def update(self, pos, newValue):
        # Set the newValue passed at position `pos` in the seg tree
        # If the new value is less than the max bound for this tree, then set the
        # value in the tree as 1 else store 0
        self.updateST(0, 0, self.size - 1, pos, 1 if newValue < self.max_bound else 0)

    def updateST(self, node, node_l, node_r, index, newValue):
        # Base Base
        if node_l == node_r:
            # If we have reached the leaf node, then simply update it's value
            self.tree[node].changeValue(newValue)
            return

        # Calculate the middle point
        m = (node_l + node_r) // 2
        # Update only the necessary child of the node
        if index <= m:
            self.updateST(node * 2 + 1, node_l, m, index, newValue)
        else:
            self.updateST(node * 2 + 2, m + 1, node_r, index, newValue)

        # Then recalculate the current node value
        self.tree[node] = self.combine(self.tree[node * 2 + 1], self.tree[node * 2 + 2])


n, q, l, r = map(int, input().split())
stl = SegmentTree(n, l)
strp = SegmentTree(n, r + 1)

for i in range(q):
    typ, x, y = map(int, input().split())
    if typ == 1:
        stl.update(x-1, y)
        strp.update(x-1, y)
    else:
        print(strp.query(x-1, y-1) - stl.query(x-1, y-1))
