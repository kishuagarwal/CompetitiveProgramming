t = int(raw_input())

for i in xrange(t):
    n = int(raw_input())
    h = map(int, raw_input().strip().split(' '))
    initial = sum(h)
    h[0] = min(1,h[0])
    for j in xrange(1,n):
        if h[j] > h[j-1] + 1:
            h[j] = h[j-1] + 1

    h[n-1] = min(1, h[n-1])
    for j in xrange(n-2,-1,-1):
        if h[j] > h[j+1] + 1:
            h[j] = h[j+1] + 1

    m = max(h)
    ans = 0
    for j in xrange(1,m+1):
        ans += j
    for j in xrange(1, m):
        ans += j
    print initial - ans




