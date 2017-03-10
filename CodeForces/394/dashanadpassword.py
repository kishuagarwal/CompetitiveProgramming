import string

n, m = map(int, raw_input().split())

l = []
for _ in xrange(n):
    l.append(raw_input())
lower = string.ascii_lowercase
digits = string.digits
shorts = [[2*m]*3 for x in xrange(n)]
p = '#*&'
for i in xrange(n):
    for index, c in enumerate(l[i]):
        index = min(index, m - index)
        if c in lower:
            shorts[i][0] = min(shorts[i][0] , index)
        elif c in digits:
            shorts[i][1] = min(shorts[i][1] , index)
        elif c in p:
            shorts[i][2] = min(shorts[i][2] , index)

ans = 1000000000

for i in xrange(n):
    for j in xrange(i+1,n):
        for k in xrange(j+1,n):
            total = 100000000
            for x in range(3):
                for y in range(3):
                    if y == x:
                        continue
                    for z in range(3):
                        if z == x or z == y:
                            continue
                        total = min(total, shorts[i][x] + shorts[j][y] + shorts[k][z])
            ans = min(ans, total)

print ans

