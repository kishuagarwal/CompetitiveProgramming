t = int(raw_input())

for i in xrange(t):
    s = raw_input().strip()
    s = list(s)
    sCount = 0
    mCount = 0
    n = len(s)
    eaten = [False for j in xrange(n)]
    for j in xrange(n):
        if s[j] == 'm':
            if j!= 0 and s[j-1] == 's' and not eaten[j-1]:
                sCount -= 1
                eaten[j-1] = True
            else:
                if j != n-1 and s[j+1] == 's':
                    sCount -= 1
                    eaten[j+1] = True
            mCount += 1

        else:
            sCount += 1

    if mCount > sCount:
        print 'mongooses'
    elif sCount > mCount:
        print 'snakes'
    else:
        print 'tie'
        

