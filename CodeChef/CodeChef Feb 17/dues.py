t = int(raw_input())
for _ in xrange(t):
    n = int(raw_input())
    l = map(int, raw_input().split(' '))
    month = n + 1
    for index, m in enumerate(l):
        if m == 0:
            month = index + 1
            break

    total = 1000 * n - (1000 * sum(l)) + 100 * (n - month + 1)
    print total