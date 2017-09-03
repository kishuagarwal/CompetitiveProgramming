q = int(raw_input())

for i in xrange(q):
    n = int(raw_input())
    l = map(int, raw_input().strip().split(' '))
    is_sorted = True
    unique = True
    inrange = True
    el = set()
    prev = 0
    for a in l:
        if a in el:
            unique = False
            break
        el.add(a)
        if a < 1 or a > n:
            inrange = False
            break
        if a < prev:
            is_sorted = False
        prev = a

    if not inrange or not unique or is_sorted:
        print 'Ugly'
    else:
        print 'Beautiful'
