t = int(raw_input())

for i in xrange(t):
    n,k = map(int, raw_input().strip().split(' '))
    p = map(float, raw_input().strip().split(' '))
    p.sort()
    ans = 0
    for j in xrange(0,k+1):
        if j == k:
            _p = p[:j]
        else:
            _p = p[:j] + p[-(k-j):]
        dp = [[0.0 for y in xrange(k+1)] for x in xrange(k+1)]
        dp[0][0] = 1.0
        for x in xrange(1,k+1):
            for y in xrange(x):
                dp[y][x] += dp[y][x-1] * (1- _p[x-1])
                dp[y+1][x] += dp[y][x-1] * _p[x-1]
        ans = max(ans, dp[k/2][k])

    print 'Case #{0}: {1}'.format(i+1, ans)