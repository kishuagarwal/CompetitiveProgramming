import sys
t = int(raw_input())

for i in xrange(t):
    j,p,s,k = map(int, raw_input().strip().split(' '))

    k = min(s,k)
    print 'Case #{0}: {1}'.format(i+1, j * p * k)
    for _j in xrange(1,j+1):
        for _p in xrange(1,p+1):
            for _k in xrange(1,k+1):
                print _j,_p,((_j + _p -3 + _k) % s) + 1