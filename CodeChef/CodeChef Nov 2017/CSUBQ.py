import sys
sys.setrecursionlimit(1000000)

class SegmentTreeNode(object):
    def __init__(self, value):
        self.ones_subarrays = value
        self.len = 1
        self.len_ones_left = value
        self.len_ones_right = value
        
    
class SegmentTree(object):
    def __init__(self, n, max_bound):
        self.size = n
        self.max_bound = max_bound
        self.tree = [SegmentTreeNode(0) for i in range(4*n)]
        self.buildST()

    def buildST(self):
        for i in range(self.size):
            self.update(i, 0)

    def combine(self, left ,right):
        res = SegmentTreeNode(0)
        res.len = left.len + right.len
        res.len_ones_left = left.len_ones_left
        if left.len_ones_left == left.len:
            res.len_ones_left += left.len_ones_right

        res.len_ones_right = right.len_ones_right
        if right.len_ones_right == right.len:
            res.len_ones_right += left.len_ones_right

        res.ones_subrarrays = left.ones_subarrays + right.ones_subarrays + left.len_ones_right * right.len_ones_left

        return res
        

    def query(self, l, r):
        return self.queryST( 0, 0, self.size - 1, l, r).ones_subarrays

    def queryST(self, node, node_l, node_r, l, r):
        if node_l >= l and node_r <= r:
            return self.tree[node]
        if r < node_l or l > node_r:
            return SegmentTreeNode(0)
        m = (node_l + node_r) // 2
        return combine(self.queryST(node * 2 + 1, node_l, m, l, r), self.queryST(node * 2 + 2, m + 1, node_r, l, r))
    
    def update(self, pos, newValue):
        self.updateST(0, 0, self.size - 1, pos, 1 if newValue < self.max_bound else 0)

    def updateST(self, node, node_l, node_r, index, newValue):
        #print(node, node_l, node_r)
        if node_l == node_r:
            self.tree[node] = SegmentTreeNode(newValue)
            return

        m = (node_l + node_r) // 2
        if index <= m:
            self.updateST(node* 2 + 1, node_l, m, index, newValue)
        else:
            self.updateST(node * 2 + 2, m + 1, node_r, index, newValue)

        self.tree[node] = self.combine(self.tree[node * 2 + 1], self.tree[node * 2 + 2])


n, q, l, r = list(map(int, input().strip().split(' ')))
stl = SegmentTree(n, l)
strp = SegmentTree(n, r + 1)
                     
for i in range(q):
    typ, x, y = list(map(int, input().strip().split(' ')))
    if typ == 1:
        stl.update(x-1, y)
        strp.update(x-1,y) 
    else:
        print(strp.query(l-1, r-1) - stl.query(l-1, r-1))
