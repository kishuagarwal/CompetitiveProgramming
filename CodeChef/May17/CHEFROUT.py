t = int(raw_input())

for i in xrange(t):
    s = raw_input()
    prev = 'A'
    for c in s:
        if c < prev:
            print 'no'
            break
        prev = c
    else:
        print 'yes'