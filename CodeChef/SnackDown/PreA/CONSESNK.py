t = int(raw_input())

for i in xrange(t):
    n,l,a,b = map(int, raw_input().strip().split(' '))
    s = map(int, raw_input().strip().split(' '))
    s.sort()
    ans = 0
    for j in xrange(1,n):
        if s[j] - s[j-1] < l:
            temp = s[j]
            s[j] = s[j-1] + l
            ans += abs(s[j] - temp)
        else:
            ans += s[j] - (s[j-1]+l)
        
    print ans