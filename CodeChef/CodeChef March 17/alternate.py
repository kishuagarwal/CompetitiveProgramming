t = int(raw_input())
for i in xrange(t):
    n = int(raw_input())
    a = map(int, raw_input().strip().split(' '))
    b = map(int, raw_input().strip().split(' '))
    ans = 0
    temp = 0
    for j in xrange(n):
        if j % 2 == 0:
            ans += a[j]
            temp += b[j]
        else:
            ans += b[j]
            temp += a[j]

    print min(ans,temp)