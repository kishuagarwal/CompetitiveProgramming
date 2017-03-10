t = int(raw_input())
for i in xrange(t):
    n = int(raw_input())
    l = map(int, raw_input().strip().split(' '))
    l.sort()
    if (l[0] == l[1]) or (l[0] < (l[1] - 1)): 
        print l[0]
    elif l[-1] == l[-2] or l[-1] > (l[-2] + 1):
        print l[-1]
    else:
        for j in xrange(1,n-1):
            if l[j] != (l[j-1] + 1) or l[j] != (l[j+1] - 1):
                print l[j]
                break