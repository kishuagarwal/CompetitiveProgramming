import heapq
t = int(raw_input())

for i in xrange(t):
    n = int(raw_input())
    c = map(int, raw_input().strip().split(' '))
    h = []
    for index, x in enumerate(c):
        heapq.heappush(h, [-x, index])

    print 'Case #{0}:'.format(i+1),
    while n > 2:
        c, index = heapq.heappop(h)
        c = -c
        print chr(65 + index),
        c -= 1
        if c == 0:
            n -= 1
        else:
            heapq.heappush(h, [-c, index])
    a,a_index = heapq.heappop(h)
    b,b_index = heapq.heappop(h)
    a = -a
    while a > 0:
        print chr(65 + a_index) + chr(65+b_index),
        a -= 1

    print

