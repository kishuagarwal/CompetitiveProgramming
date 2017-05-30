t = int(raw_input())

for i in xrange(t):
    n,m = map(int, raw_input().strip().split(' '))
    for j in xrange(m):
        raw_input()
    if (n - (2 * m)) % 2 == 0:
        print 'yes'
    else:
        print 'no'