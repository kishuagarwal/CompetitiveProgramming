t = int(raw_input())
for i in xrange(t):
    n = int(raw_input())
    a = []
    for j in xrange(n):
        a.append(map(int, raw_input().strip().split(' ')))

    count = 0
    for j in xrange(n):
        for k in xrange(n):
            if a[j][k] == 0:
                count += 1

    required = 0
    k = 0
    for j in xrange(1,n):
        required += j * 2
        if required > count:
            k = n - j
            break
    print k