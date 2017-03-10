n = int(raw_input())
tree = [[] for i in  xrange(n)]
for i in xrange(n):
    a,b = map(int, raw_input().strip().split(' '))
    tree[a-1].append(b-1)
    tree[b-1].append(a-1)

d = 0
v = 0
for i in xrange(n):
    if len(tree[i]) > d:
        d = len(tree[i])
        v = i

