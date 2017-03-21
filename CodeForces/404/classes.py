n = int(raw_input())
a = []
for i in xrange(n):
    x,y = map(int,raw_input().strip().split(' '))
    a.append((x,y))

m = int(raw_input())
b = []
b1 = []
for i in xrange(m):
    x,y = map(int,raw_input().strip().split(' '))
    b.append((x,y))
    b1.append((y,x))

b.sort()
b1.sort()
ans = 0

def dis(x,y):
    c = [x,y]
    c.sort()
    if c[1][0] <= c[0][1]:
        return 0

    return c[1][0] - c[0][1]


for i in xrange(n):
    first = dis(a[i], (b1[0][1], b1[0][0]))
    last = dis(a[i], b[-1])
    ans = max(ans, first, last)

print ans