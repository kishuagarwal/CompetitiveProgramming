n,m = map(long, raw_input().strip().split(' '))
ans = m

if m >= n:
    print n
else:
    l,h = 0, n
    while l < h:
        #print l,h
        mid = l + ((h -l) / 2)
        if (mid * (mid + 1)) / 2 >= (n-m):
            h = mid 
        else:
            l = mid + 1

    print(m + l)