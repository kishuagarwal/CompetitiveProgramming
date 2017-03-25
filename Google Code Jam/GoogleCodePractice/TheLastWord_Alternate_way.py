t = int(raw_input())

for i in xrange(1, t+1):
    s = raw_input()
    ans = ''
    for c in s:
        ans = max(ans + c, c + ans)
    print 'Case #{0}: {1}'.format(i,ans)


