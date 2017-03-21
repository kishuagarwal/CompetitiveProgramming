import sys


t = int(raw_input())

for i in xrange(t):
    b,m = map(int, raw_input().strip().split(' '))
    print "Case #{0}:".format(i+1),
    total = pow(2, b-2)
    if m > total:
        print 'IMPOSSIBLE'
        continue

    print 'POSSIBLE'
    for building in xrange(b):
        if building != 0:
            for j in xrange(b):
                if j > building:
                    sys.stdout.write('1')
                else:
                    sys.stdout.write('0')
        else:
            if m == pow(2, b-2):
                sys.stdout.write('0')
                for j in xrange(1,b):
                    sys.stdout.write('1')
            else:
                for j in xrange(b-1):
                    if ((1 << (b-j-2)) & m) > 0:
                        sys.stdout.write('1')
                    else:
                        sys.stdout.write('0')
                print '0',
        print