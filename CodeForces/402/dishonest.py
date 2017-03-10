n,k = map(int, raw_input().strip().split(' '))
a = map(int, raw_input().strip().split(' '))
b = map(int, raw_input().strip().split(' '))


ans = 0

c = [0 for i in xrange(n)]
for i in xrange(n):
    c[i] = (a[i],b[i])


def compare(first, second):
    d1 = first[0] - first[1]
    d2 = second[0] - second[1]
    if d1 < 0 and d2 < 0:
        return -(abs(d1) + abs(d2))
    elif d1 < 0:
        return -1
    elif d2 < 0:
        return 1
    else:
        return d1 - d2
c.sort(cmp=compare)

for i in xrange(n):
    if i < k:
        ans += c[i][0]
    else:
        ans += min(c[i][0], c[i][1])

print ans