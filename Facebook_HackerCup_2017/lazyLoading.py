t = int(raw_input())
for i in range(1,t+1):
    n = int(raw_input())
    w = [0 for j in range(n)]
    for j in range(n):
        w[j] = int(raw_input())

    w.sort()
    ans = 0
    first = 0
    last = n-1
    while first <= last:
        s = w[last]
        while first < last and s < 50:
            s += w[last]
            first += 1
        last -= 1
        if s >= 50:
            ans += 1
    print 'Case #{0}: {1}'.format(i,ans)