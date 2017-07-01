t = int(raw_input())

for i in xrange(t):
    n = int(raw_input())
    if n == 1:
        print 1
        continue
    if n == 2:
        print "1 2"
        continue
    prev = 2
    print 1,3,
    prev = 3
    for j in xrange(2,n):
        prev += 2
        print prev,
    print