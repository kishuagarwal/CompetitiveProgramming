n,k = map(int, raw_input().strip().split())

for i in xrange(k):
    s = map(int, raw_input().strip().split())
    s = s[::-1]
    for j in xrange(1,n):
        if s[j] < s[j-1]:
            break
    next_highest = None
    pos = -1
    for x in xrange(j):
        if s[x] > s[j] and next_highest is None or s[x] < next_highest:
            next_highest = s[x]
            pos = x
    s[pos], s[j] = s[j], s[pos]
    temp = s[:j]
    temp.sort(reverse=True)
    for x in xrange(j):
        s[x] = temp[x]

    for j in s[::-1]:
        print j,
    print 

    # 6 5 3 4 2 1
