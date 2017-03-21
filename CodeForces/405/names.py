n, k = map(int, raw_input().strip().split(' '))

s = raw_input().strip().split(' ')
l= len(s)

ans = []

if 'YES' in s:
    for i in xrange(n):
        t = i % 10
        r = i / 10
        x = chr(65+t) 
        for j in xrange(r):
            x = x + chr(97+t)
        ans.append(x)
    p = s.index('YES')
    for i in xrange(p-1, -1,-1):
        ans[i] = ans[i+k-1]

    for i in xrange(p+1, l):
        if s[i] == 'NO':
            ans[i+k-1] = ans[i]

else:
    for i in xrange(n):
        ans.append('A')

for i in xrange(n):
    print ans[i],

