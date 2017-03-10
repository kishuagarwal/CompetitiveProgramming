t = int(raw_input())
for _ in xrange(t):
    n = int(raw_input())
    l = map(int, raw_input().strip().split(' '))
    ans = 0
    count = 0
    prev = 2
    prev_t = 0
    i = 0
    while i < n and l[i] == 1:
        l.pop(0)
        n -= 1 
    for index, i in enumerate(l):
        if i == 1 and prev == 1:
            prev_t += 1
            ans = max(ans, prev_t)
            count += 1
        elif i == 1 and prev == 0:
            count += 1
            prev_t = max(prev_t + 1, index - count + 1)
            ans = max(ans, prev_t)
        prev = i
    print ans