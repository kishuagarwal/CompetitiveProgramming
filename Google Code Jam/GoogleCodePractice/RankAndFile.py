t = int(raw_input())

for i in xrange(1, t+1):
    n = int(raw_input())
    h = [0 for j in xrange(2600)]
    for j in xrange(2*n-1):
        l = map(int, raw_input().strip().split(' '))
        for height in l:
            h[height] += 1

    l = []
    for index, height in enumerate(h):
        if height % 2 == 1:
            l.append(index)

    l.sort()
    l = map(str, l)
    print 'Case #{0}: {1}'.format(i, ' '.join(l))