t = int(raw_input())

for i in xrange(t):
    s = raw_input()
    co, ce, jo, je = 0,0,0,0
    for day, c in enumerate(s):
        if day % 2 == 0:
            if c == 'C':
                ce += 1
            if c == 'J':
                je += 1
        else:
            if c == 'C':
                co += 1
            if c == 'J':
                jo += 1

    ans = 10 * (min(ce,co)+ min(jo,je)) + 5 * abs(co-ce)
    print 'Case #{0}: {1}'.format(i+1, ans)