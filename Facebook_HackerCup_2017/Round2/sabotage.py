t = int(raw_input())
for i in xrange(t):
    n,m,k = map(int, raw_input().split())
    ans = n*m
    if n == 1 or m == 1 or m == 2 or n == 2 or k > min(n,m) or max(n,m) < 5:
        ans = -1
    else:
        if k == 1 and ((m >= 3 and n >= 5) or (n >= 3 and m >= 5)):
            ans = 5
        elif k!= 1 and ((m >= 2*k + 1 and n >= 3*k + 1) or (n >= 2*k + 1 and m >= 3*k + 1)):
            ans = 4
        if  m >= 2*k+3:
            if n >=k+1:
                required = min(n-1,n-k)/k
                if required*k < min(n-1,n-k):
                    required += 1
                if required * k < n:
                    ans = min(ans,required + 1)
        if n >= 2*k + 3:
            if m>=k+1:
                required = min(m-1, m-k)/k
                if required*k < min(m-1,m-k):
                    required += 1
                if required * k < n:
                    ans = min(ans, required + 1)

    if ans == n*m:
        ans = -1
    print 'Case #{0}: {1}'.format(i+1, ans)