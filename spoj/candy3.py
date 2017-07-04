t = int(raw_input())

for i in xrange(t):
    raw_input()
    n = int(raw_input())
    total = 0
    for j in xrange(n):
        total += int(raw_input())

    if total % n == 0:
        print 'YES'
    else:
        print 'NO'