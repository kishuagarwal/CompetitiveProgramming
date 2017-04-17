t = int(raw_input())

for i in xrange(t):
    first = raw_input().strip().split(' ')
    second = raw_input().strip().split(' ')
    count = 0
    for f in first:
        if f in second:
            count += 1

    if count >= 2:
        print 'similar'
    else:
        print 'dissimilar'