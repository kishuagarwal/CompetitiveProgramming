import math

t=  int(raw_input())

for i in xrange(t):
    n, k = map(int, raw_input().strip().split(' '))
    available = set([n])
    count = {n : 1}
    total = 0
    while True:
        m = max(available)
        if m % 2 == 1:
            higher = lower = m / 2
        else:
            higher = m/ 2
            lower = higher - 1
        #higher = int(math.ceil((m - 1)/ 2.0))
        #lower = int(math.floor((m - 1) / 2.0))
        total += count[m]
        if total >= k:
            print 'Case #{0}: {1} {2}'.format(i+1, higher, lower)
            break
        available.remove(m)
        available.add(higher)
        available.add(lower)
        if higher in count:
            count[higher] += count[m]
        else:
            count[higher] = count[m]
        if lower in count:
            count[lower] += count[m]
        else:
            count[lower] = count[m]
